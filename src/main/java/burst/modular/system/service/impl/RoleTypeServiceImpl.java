package burst.modular.system.service.impl;

import burst.modular.system.entity.RoleType;
import burst.modular.system.mapper.RoleTypeMapper;
import burst.modular.system.service.IRoleTypeService;
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
public class RoleTypeServiceImpl extends ServiceImpl<RoleTypeMapper, RoleType> implements IRoleTypeService {
	
	@Autowired
	private RoleTypeMapper roleTypeMapper; 
	
	//添加RoleType
	public void add(RequestData requestData) {};
	//删除
	public void delete(RequestData requestData) {};
	//更新
	public void update(RequestData requestData) {};
	//查询
	public List<RoleType> list(RequestData requestData) {
		return null;
	};
}
