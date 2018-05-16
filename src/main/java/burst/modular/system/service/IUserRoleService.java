package burst.modular.system.service;

import burst.modular.system.entity.UserRole;
import com.baomidou.mybatisplus.service.IService;
import burst.core.model.RequestData;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author renlinjun
 * @since 2018-05-16
 */
public interface IUserRoleService extends IService<UserRole> {

	

	//添加UserRole
	public void add(RequestData data);
	//删除
	public void delete(RequestData data);
	//更新
	public void update(RequestData data);
	//查询
	public List<UserRole> list(RequestData data);
}
