package burst.modular.system.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import burst.core.config.ResultConstants;
import burst.core.model.RequestData;
import burst.core.model.ResponseData;
import burst.modular.system.entity.OptResource;
import burst.modular.system.entity.Permission;
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
	
	
	//删除
	public void delete(RequestData requestData) {}
	//更新
	public void update(RequestData requestData) {}
	//查询
	public List<PermissionResource> list(RequestData requestData) {
		return null;
	}
	
	@Override
	public ResponseData add(RequestData requestData) {
		JSONObject data = requestData.getData();
		
		//获取权限ID
		String permissionId = data.getString("permission_id");
		//获取资源ID,多个资源用  ',' 分割
		String resourceIdStr = data.getString("resource_ids");
		//资源列表
		String[] resourceIds = resourceIdStr.split(",");
		
		List<PermissionResource> permissionResources = new ArrayList<PermissionResource>();
		for(int i=0;i<resourceIds.length;i++) {
			PermissionResource  permissionResource = new PermissionResource();
			permissionResource.setPermissionId(permissionId);
			permissionResource.setResourceId(resourceIds[i]);
			permissionResources.add(permissionResource);
		}
		
		int result = baseMapper.addBatch(permissionResources);
		if(result<0) {
			return new ResponseData(ResultConstants.OPT_FAIL,"操作失败");
		}
		
		return new ResponseData(ResultConstants.SUCCESS_RESPONSE);
	}
	
	@Override
	public ResponseData removeAllByPermissionId(String permissionId) {
		int result = baseMapper.removeAllByPermissionId(permissionId);
		
		if(result<0) {
			return new ResponseData(ResultConstants.OPT_FAIL,"操作失败");
		}
		return new ResponseData(ResultConstants.SUCCESS_RESPONSE);
	}
	
	@Transactional
	@Override
	public ResponseData updateBatch(RequestData requestData) {
		
		JSONObject data = requestData.getData();
		
		String permissionId = data.getString("permission_id");
		
		ResponseData removeResult = removeAllByPermissionId(permissionId);
		//如果删除失败，则返回失败信息
		if(removeResult.getCode()!=ResultConstants.SUCCESS_CODE) {
			removeResult.setMsg("更新失败");
			return removeResult;
		}
		
		ResponseData addResult = add(requestData);
		if(addResult.getCode()!=ResultConstants.SUCCESS_CODE) {
			addResult.setMsg("操作失败");
			return addResult;
		}
		
		return new ResponseData(ResultConstants.SUCCESS_RESPONSE);
	}
	
	@Override
	public List<Map<String,OptResource>> queryOptResourceByPermission(List<Permission> permissions) {
		//查询资源列表
		List<OptResource> optResources = baseMapper.queryOptResourceByPermission(permissions);
		//转换为以键值对的方式存储
		List<Map<String,OptResource>> optResourceMap = new ArrayList<>();
		for(int i=0;i<optResources.size();i++) {
			Map<String,OptResource> map = new HashMap<>();
			OptResource optResource = new OptResource();
			map.put(optResource.getResourceUrl(), optResource);
			optResourceMap.add(map);
		}
		return optResourceMap;
	}
}
