package burst.modular.system.mapper;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import burst.modular.system.entity.Dept;

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
    public List<Dept> findAll (String deptName);


    /**
	 * description:逻辑删除 用户
	 * @param deptId
	 * @return
	 */
	public int delByDeptId(String deptId);


	/**
	 * description:初始化查找实体
	 * @param deptParm
	 * @return
	 */
	public Dept get(String deptParm);


	/**
	 *
	 * @param dept
	 * @return
	 */
	public int updateByDeptId(Dept dept);
}
