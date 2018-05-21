package burst.modular.system.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import burst.core.model.RequestData;
import burst.modular.system.entity.PermissionResource;
import burst.modular.system.mapper.PermissionResourceMapper;
import burst.modular.system.service.IPermissionResourceService;

/**
 * <p>
 * 权限资源关联表 服务实现类
 * </p>
 *
 * @author renlinjun
 * @since 2018-05-21
 */
@Service
public class PermissionResourceServiceImpl extends ServiceImpl<PermissionResourceMapper, PermissionResource> implements IPermissionResourceService {
	
	
	//添加PermissionResource
	public void add(RequestData requestData) {};
	//删除
	public void delete(RequestData requestData) {};
	//更新
	public void update(RequestData requestData) {};
	//查询
	public List<PermissionResource> list(RequestData requestData) {
		return null;
	};
}
