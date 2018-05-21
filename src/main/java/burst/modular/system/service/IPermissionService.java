package burst.modular.system.service;

import burst.modular.system.entity.Permission;
import com.baomidou.mybatisplus.service.IService;
import burst.core.model.RequestData;
import java.util.List;

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
	public void add(RequestData requestData);
	//删除
	public void delete(RequestData requestData);
	//更新
	public void update(RequestData requestData);
	//查询
	public List<Permission> list(RequestData requestData);
}
