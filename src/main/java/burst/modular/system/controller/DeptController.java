package burst.modular.system.controller;

import burst.core.config.ResultConstants;
import burst.core.model.RequestData;
import burst.core.model.ResponseData;
import burst.modular.system.entity.Dept;
import burst.modular.system.entity.Role;
import burst.modular.system.service.IDeptService;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * @author yf.wang
 * @Title: mvc部门控制层
 * @Package
 * @Description: 部门控制层 人员将加挂在部门下
 * @date 2018/5/30 15:29
 */
public class DeptController {


    @Autowired
    private IDeptService deptService;



    /**
     * description:树形结构查询（添加时候默认 首先选择上级机构，为空则数据库默认p_dept 为‘0’）
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

        }else{
            return new ResponseData(ResultConstants.OPT_FAIL,"查询部门树形结构失败");
        }


        return new ResponseData(ResultConstants.SUCCESS_RESPONSE,"查询部门树形结构结果如下:"+mapList);

    }


    /**
     * 添加部门
     * @param requestData
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/add")
    public ResponseData add(@RequestBody RequestData requestData) throws Exception {
        Integer dept =deptService.add(requestData);
       if(dept>0) {
			return new ResponseData(ResultConstants.SUCCESS_RESPONSE);
		}

		return new ResponseData(ResultConstants.OPT_FAIL,"操作失败");
    }

    //删除
    @RequestMapping(value = "/delete")
    public void delete(RequestData requestData) {
      //判断是否为子级结构


      //是，直接删除


      //否，必须删除其下所有子级结构

    }

    //更新
    @RequestMapping(value = "/update")
    public void update(RequestData requestData) {
    }

    //查询
    @RequestMapping(value = "/list")
    public List<Role> list(RequestData requestData) {
        return null;
    }





    //--
}
