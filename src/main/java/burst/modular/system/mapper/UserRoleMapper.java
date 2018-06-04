package burst.modular.system.mapper;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import burst.modular.system.entity.Role;
import burst.modular.system.entity.UserRole;

/**
 * <p>
 * 人员角色关联表 Mapper 接口
 * </p>
 *
 * @author renlinjun
 * @since 2018-05-21
 */
public interface UserRoleMapper extends BaseMapper<UserRole> {
	
	//批量添加
	public int addBatch(List<UserRole> dataList);
	
	/**
	 * 根据人员ID查询该人员对应的角色列表
	 * @return
	 */
	public List<Role> queryRoleByUserId(String userId);

}
