package burst.modular.system.mapper;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import burst.modular.system.entity.Menu;
import burst.modular.system.entity.Permission;
import burst.modular.system.entity.PermissionMenu;

/**
 * <p>
 * 权限菜单表 Mapper 接口
 * </p>
 *
 * @author renlinjun
 * @since 2018-05-21
 */
public interface PermissionMenuMapper extends BaseMapper<PermissionMenu> {
	
	/**
	 * 为资源添加菜单
	 * @param permissionMenu
	 * @return
	 */
	public int assignMenu(List<PermissionMenu> permissionMenu);
	
	/**
	 * 根据权限列表查询权限对应的菜单列表
	 * @param permissions
	 * @return
	 */
	public List<Menu> queryMenuByPermission(List<Permission> permissions);

}
