package burst.modular.system.mapper;

import burst.modular.system.entity.Account;
import burst.modular.system.entity.Dept;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * @author yf.wang
 * @Title: 部门maybatis 映射接口
 * @Package
 * @Description:
 * @date 2018/5/30 15:40
 */
public interface DeptMapper extends BaseMapper<Dept> {

    /**
     * decription:查找树形结构
     * @return
     */
    public List<Dept> findAll ();


    /**
	 * description:逻辑删除 用户
	 * @param deptId
	 * @return
	 */
	public int delByDeptId(String deptId);



}
