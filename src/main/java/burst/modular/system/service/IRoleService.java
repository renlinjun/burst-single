package burst.modular.system.service;

import burst.modular.system.entity.Role;
import com.baomidou.mybatisplus.service.IService;
import burst.core.model.RequestData;
import java.util.List;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author renlinjun
 * @since 2018-05-21
 */
public interface IRoleService extends IService<Role> {

	

	//添加Role
	public void add(RequestData requestData);
	//删除
	public void delete(RequestData requestData);
	//更新
	public void update(RequestData requestData);
	//查询
	public List<Role> list(RequestData requestData);
}
