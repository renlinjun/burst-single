package burst.modular.system.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;

import burst.core.model.RequestData;
import burst.modular.system.entity.Permission;
import burst.modular.system.entity.Role;
import burst.modular.system.entity.RolePermission;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author renlinjun
 * @since 2018-06-04
 */
public interface IRolePermissionService extends IService<RolePermission> {

	

	//添加RolePermission
	public void add(RequestData requestData);
	//删除
	public void delete(RequestData requestData);
	//更新
	public void update(RequestData requestData);
	//查询
	public List<RolePermission> list(RequestData requestData);
	
	/**
	 * 根据角色查询对应的权限列表
	 * @param roles
	 * @return
	 */
	public List<Permission> queryPermissionByRole(List<Role> roles);
}
