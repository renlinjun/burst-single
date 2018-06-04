package burst.modular.system.mapper;

import java.util.List;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import burst.modular.system.entity.Permission;
import burst.modular.system.entity.Role;
import burst.modular.system.entity.RolePermission;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author renlinjun
 * @since 2018-06-04
 */
public interface RolePermissionMapper extends BaseMapper<RolePermission> {
	
	public List<Permission> queryPermissionByRole(List<Role> role);
}
