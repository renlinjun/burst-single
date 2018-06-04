package burst.modular.system.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.service.IService;

import burst.core.model.RequestData;
import burst.core.model.ResponseData;
import burst.modular.system.entity.OptResource;
import burst.modular.system.entity.Permission;
import burst.modular.system.entity.PermissionResource;

/**
 * <p>
 * 权限资源关联表 服务类
 * </p>
 *
 * @author renlinjun
 * @since 2018-05-21
 */
public interface IPermissionResourceService extends IService<PermissionResource> {

	

	/**
	 * 添加权限资源，支持批量添加
	 * 如果资源为多个则用","分割
	 * @param requestData
	 * @return
	 */
	public ResponseData add(RequestData requestData);
	//删除
	public void delete(RequestData requestData);
	//更新
	public void update(RequestData requestData);
	
	/**
	 * 查询
	 * @param requestData
	 * @return
	 */
	public List<PermissionResource> list(RequestData requestData);
	
	
	/**
	 * 根据权限ID批量删除该权限对应的资源
	 * @param permissionId
	 * @return
	 */
	public ResponseData removeAllByPermissionId(String permissionId);
	/**
	 * 批量更新权限对应的资源
	 * @param requestData
	 * @return
	 */
	public ResponseData updateBatch(RequestData requestData);
	
	/**
	 * 根据权限查询权限对应的操作资源
	 * 
	 * @param permission
	 * @return
	 *  	资源列表：列表中为资源map，其中key为url，value为资源
	 */
	public List<Map<String,OptResource>> queryOptResourceByPermission(List<Permission> permission);
}
