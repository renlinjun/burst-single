package burst.modular.system.mapper;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import burst.modular.system.entity.PermissionResource;

/**
 * <p>
 * 权限资源关联表 Mapper 接口
 * </p>
 *
 * @author renlinjun
 * @since 2018-05-21
 */
public interface PermissionResourceMapper extends BaseMapper<PermissionResource> {
	
	/**
	 * 批量添加权限资源
	 * @param permissionResources
	 * @return
	 */
	public int addBatch(List<PermissionResource> permissionResources);
	
	/**
	 * 根据权限ID删除该权限关联的所有资源
	 * @param permissionId
	 * @return
	 */
	public int removeAllByPermissionId(String permissionId);

}
