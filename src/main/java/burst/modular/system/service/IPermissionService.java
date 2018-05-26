package burst.modular.system.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;

import burst.core.model.RequestData;
import burst.core.model.ResponseData;
import burst.modular.system.entity.Permission;

/**
 * <p>
 * 权限表 服务类
 * </p>
 *
 * @author renlinjun
 * @since 2018-05-21
 */
public interface IPermissionService extends IService<Permission> {

	

	//添加Permission
	public ResponseData add(RequestData requestData);
	//删除
	public void delete(RequestData requestData);
	//更新
	public void update(RequestData requestData);
	//查询
	public List<Permission> list(RequestData requestData);
}
