package burst.modular.system.service.impl;


import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import burst.core.model.RequestData;
import burst.modular.system.entity.Permission;
import burst.modular.system.entity.Role;
import burst.modular.system.entity.RolePermission;
import  burst.modular.system.mapper.RolePermissionMapper;
import burst.modular.system.service.IRolePermissionService;;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author renlinjun
 * @since 2018-06-04
 */
@Service
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionMapper, RolePermission> implements IRolePermissionService {
	
	
	//添加RolePermission
	public void add(RequestData requestData) {}
	//删除
	public void delete(RequestData requestData) {}
	//更新
	public void update(RequestData requestData) {}
	//查询
	public List<RolePermission> list(RequestData requestData) {
		return null;
	}
	
	/**
	 * 根据角色列表查询角色对应的权限
	 * @param roles
	 * @return
	 */
	@Override
	public List<Permission> queryPermissionByRole(List<Role> roles) {
		List<Permission> permissions = baseMapper.queryPermissionByRole(roles);
		return permissions;
	}
}
