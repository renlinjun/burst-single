package burst.modular.system.service.impl;

import burst.core.model.RequestData;
import burst.modular.system.entity.Dept;
import burst.modular.system.mapper.DeptMapper;
import burst.modular.system.service.IDeptService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author yf.wang
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/5/3015:38
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements IDeptService {

    @Autowired
    private  DeptMapper deptMapper;


    @Override
    public Dept get(String deptParm) {
        return deptMapper.get(deptParm);
    }

    /**
     * 添加部门实现方法
     * @param requestData
     * @return
     */
    @Override
    public int add(RequestData requestData) {
        Dept dept = requestData.parseObj(Dept.class);
        // 如果没有设置父节点，则代表为根节点，有则获取父节点实体
        if (dept.getpDeptId() == null || StringUtils.isEmpty(dept.getpDeptId())
                || "0".equals(dept.getpDeptId())){
			dept.setpDeptId(null);
		}else{
			dept.setpDeptId(dept.getpDeptId());
		}

		// 设置新的父节点字符串
		dept.setpDeptIds(dept.getpDeptIds()+dept.getpDeptId()+",");
        // 保存
        int result = baseMapper.insert(dept);
        return result;
    }

    @Override
    public Integer delete(RequestData requestData) {

        //判断是否为子级结构 是，直接删除 否，必须删除其下所有子级结构 不然无法维护
        Dept dept = requestData.parseObj(Dept.class);
        String pid = dept.getpDeptId();
        String pids = dept.getpDeptIds();
        String findPids;
        int result;
        int j= pids.indexOf(pid);
        findPids= pids.substring(j,pids.length());
        //删除本身
        result=deptMapper.delByDeptId(dept.getId());
        if(!",".equals(findPids)){

            String[] pidsList = findPids.split(",");
            for(String pidsL : pidsList){
                if(!StringUtil.isNullOrEmpty(pidsL)){
                    //删除下级所有
                    result=deptMapper.delByDeptId(pidsL);
                }
            }

        }
                    return result;
    }

    @Override
    public Integer update(RequestData requestData,Dept dept) {

        Integer result = 0;
        Dept dept0 = requestData.parseObj(Dept.class);
        // 获取修改前的parentIds，用于更新子节点的parentIds
        String oldPid = dept.getpDeptId();
        String oldpids = dept.getpDeptIds();
        // 设置新的父节点串
        String pids = oldpids.replace(oldPid,dept0.getpDeptId());
        dept0.setpDeptIds(pids);
        result =deptMapper.updateByDeptId(dept0);
        return result;
    }

    /**
     * 查询
     * @param requestData
     * @return
     */
    @Override
    public List<Dept> list(RequestData requestData) {


        return null;
    }


    /**
     * descirption：全查
     * @param requestData
     * @return
     */
    @Override
    public List<Dept> findAll (RequestData requestData){
        List<Dept> deptList=deptMapper.findAll();

        return deptList;
    }
}
