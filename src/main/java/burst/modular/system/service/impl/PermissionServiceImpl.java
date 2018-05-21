package burst.modular.system.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import burst.core.model.RequestData;
import burst.modular.system.entity.Permission;
import burst.modular.system.mapper.PermissionMapper;
import burst.modular.system.service.IPermissionService;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author renlinjun
 * @since 2018-05-21
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {
	
	
	//添加Permission
	public void add(RequestData requestData) {};
	//删除
	public void delete(RequestData requestData) {};
	//更新
	public void update(RequestData requestData) {};
	//查询
	public List<Permission> list(RequestData requestData) {
		return null;
	};
}
