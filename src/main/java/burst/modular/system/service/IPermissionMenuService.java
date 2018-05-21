package burst.modular.system.service;

import burst.modular.system.entity.PermissionMenu;
import com.baomidou.mybatisplus.service.IService;
import burst.core.model.RequestData;
import java.util.List;

/**
 * <p>
 * 权限菜单表 服务类
 * </p>
 *
 * @author renlinjun
 * @since 2018-05-21
 */
public interface IPermissionMenuService extends IService<PermissionMenu> {

	

	//添加PermissionMenu
	public void add(RequestData requestData);
	//删除
	public void delete(RequestData requestData);
	//更新
	public void update(RequestData requestData);
	//查询
	public List<PermissionMenu> list(RequestData requestData);
}
