package burst.modular.system.service.impl;

import burst.modular.system.entity.UserRole;
import burst.modular.system.mapper.UserRoleMapper;
import burst.modular.system.service.IUserRoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import burst.core.model.RequestData;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author renlinjun
 * @since 2018-05-16
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {
	
	@Autowired
	private UserRoleMapper userRoleMapper; 
	
	//添加UserRole
	public void add(RequestData requestData) {};
	//删除
	public void delete(RequestData requestData) {};
	//更新
	public void update(RequestData requestData) {};
	//查询
	public List<UserRole> list(RequestData requestData) {
		return null;
	};
}
