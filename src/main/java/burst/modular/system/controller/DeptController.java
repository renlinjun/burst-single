package burst.modular.system.controller;

import burst.core.config.ResultConstants;
import burst.core.model.RequestData;
import burst.core.model.ResponseData;
import burst.modular.system.entity.Dept;
import burst.modular.system.entity.Role;
import burst.modular.system.entity.UserInfo;
import burst.modular.system.service.IDeptService;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author yf.wang
 * @Title: mvc部门控制层
 * @Package
 * @Description: mvc部门控制层 人员将加挂在部门下
 * @date 2018/5/30 15:29
 */

@RestController
@RequestMapping("/system/dept")
public class DeptController {


    @Autowired
    private IDeptService deptService;

    /**
     * author：yufei.w
     * description：公用方法 任何访问到根路径下请求 都会先走这个方法
     *
     * @param requestData
     * @return
     */
    @ModelAttribute
    public Dept get(@RequestParam(required = false) RequestData requestData) {
        Dept deptParm = requestData.parseObj(Dept.class);
        if (StringUtil.isNullOrEmpty(deptParm.getId())) {
            Dept dept = deptService.get(deptParm.getId());
            return dept;
        } else {
            return new Dept();
        }
    }


    /**
     * description:树形结构查询（添加时候默认 首先选择上级机构，为空则数据库默认p_dept 为‘0’）
     *
     * @param requestData
     * @return
     */
    @RequestMapping(value = "/treeData")
    public ResponseData treeData(RequestData requestData) {
        List<Map<String, Object>> mapList = Lists.newArrayList();
        List<Dept> list = deptService.findAll(requestData);
        Map<String, Object> map = Maps.newHashMap();
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Dept dept = list.get(i);
                map.put("id", dept.getId());
                map.put("pId", dept.getpDeptId());
                map.put("pIds", dept.getpDeptIds());
                map.put("name", dept.getDeptName());

                mapList.add(map);
            }

        } else {
            return new ResponseData(ResultConstants.OPT_FAIL, "查询部门树形结构失败");
        }


        return new ResponseData(ResultConstants.SUCCESS_RESPONSE, "查询部门树形结构结果如下:" + mapList);

    }


    /**
     * 添加部门
     *
     * @param requestData
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/add")
    public ResponseData add(@RequestBody RequestData requestData) throws Exception {
        Integer dept = deptService.add(requestData);
        if (dept > 0) {
            return new ResponseData(ResultConstants.SUCCESS_RESPONSE);
        }

        return new ResponseData(ResultConstants.OPT_FAIL, "操作失败");
    }

    //删除
    @RequestMapping(value = "/delete")
    public ResponseData delete(RequestData requestData) {

        Integer result = deptService.delete(requestData);

        if (result > 0) {
            return new ResponseData(ResultConstants.SUCCESS_RESPONSE);
        }

        return new ResponseData(ResultConstants.OPT_FAIL, "操作失败");
    }


    /**
     * description:更新
     *
     * @param requestData
     */
    @RequestMapping(value = "/update")
    public ResponseData update(RequestData requestData, Dept dept) {
        //更新和 添加应该可以合并
        Integer result = deptService.update(requestData, dept);
        if (!"0".equals(result)) {
            return new ResponseData(ResultConstants.SUCCESS_RESPONSE, "操作成功用户表，更新用户表数据条数:" + result);
        }

        return new ResponseData(ResultConstants.OPT_FAIL, "数据库更新失败");
    }



    /**
     *
     * @param requestData
     * @return
     */
    @RequestMapping(value = "/list")
    public List<Role> list(RequestData requestData) {
        return null;
    }


    //--
}
