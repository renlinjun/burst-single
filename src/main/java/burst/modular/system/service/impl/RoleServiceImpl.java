package burst.modular.system.service.impl;

import burst.modular.system.entity.Role;
import burst.modular.system.mapper.RoleMapper;
import burst.modular.system.service.IRoleService;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {
	
	@Autowired
	private RoleMapper roleMapper; 
	
	//添加Role
	public void add(RequestData data) {};
	//删除
	public void delete(RequestData data) {};
	//更新
	public void update(RequestData data) {};
	//查询
	public List<Role> list(RequestData data) {
		return null;
	};
}
