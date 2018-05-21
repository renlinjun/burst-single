package burst.modular.system.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import burst.modular.system.service.IPermissionResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import burst.core.model.RequestData;
import java.util.List;
import burst.modular.system.entity.PermissionResource;


/**
 * <p>
 * 权限资源关联表 前端控制层
 * </p>
 *
 * @author renlinjun
 * @since 2018-05-21
 */
@RestController
@RequestMapping("/system/permissionResource")
public class PermissionResourceController {
	
	@Autowired
	private IPermissionResourceService permissionResourceService;

	//添加PermissionResource
	@RequestMapping(value="/add")
	public void add(RequestData requestData) {};
	//删除
	@RequestMapping(value="/delete")
	public void delete(RequestData requestData) {};
	//更新
	@RequestMapping(value="/update")
	public void update(RequestData requestData) {};
	//查询
	@RequestMapping(value="/list")
	public List<PermissionResource> list(RequestData requestData) {
		return null;
	};
}
