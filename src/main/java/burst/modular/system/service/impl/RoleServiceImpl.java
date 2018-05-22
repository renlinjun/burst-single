package burst.modular.system.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import burst.core.model.RequestData;
import burst.modular.system.entity.Role;
import burst.modular.system.mapper.RoleMapper;
import burst.modular.system.service.IRoleService;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author renlinjun
 * @since 2018-05-21
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {
	
	
	//添加Role
	public int add(RequestData requestData) {
		Role role = requestData.parseObj(Role.class);
		int result = baseMapper.insert(role);
		return result;
		
	};
	//删除
	public void delete(RequestData requestData) {};
	//更新
	public void update(RequestData requestData) {};
	//查询
	public List<Role> list(RequestData requestData) {
		return null;
	};
}
