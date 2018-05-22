package burst.modular.system.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import burst.core.model.RequestData;
import burst.modular.system.entity.RoleType;
import burst.modular.system.mapper.RoleTypeMapper;
import burst.modular.system.service.IRoleTypeService;

/**
 * <p>
 * 角色类型表 服务实现类
 * </p>
 *
 * @author renlinjun
 * @since 2018-05-21
 */
@Service
public class RoleTypeServiceImpl extends ServiceImpl<RoleTypeMapper, RoleType> implements IRoleTypeService {
	
	
	//添加RoleType
	public int add(RequestData requestData) {
		RoleType roleType = requestData.parseObj(RoleType.class);
		int result = baseMapper.insert(roleType);
		return result;
	};
	//删除
	public void delete(RequestData requestData) {};
	//更新
	public void update(RequestData requestData) {};
	//查询
	public List<RoleType> list(RequestData requestData) {
		return null;
	};
}
