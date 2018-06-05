package burst.modular.system.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import burst.modular.system.service.IRolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import burst.core.model.RequestData;
import java.util.List;
import burst.modular.system.entity.RolePermission;


/**
 * <p>
 *  前端控制层
 * </p>
 *
 * @author renlinjun
 * @since 2018-06-04
 */
@RestController
@RequestMapping("/system/rolePermission")
public class RolePermissionController {
	
	@Autowired
	private IRolePermissionService rolePermissionService;

	//添加
	@RequestMapping(value="/add")
	public void add(RequestData requestData) {};
	/**
	  删除
	 @作者： renlinjun
	 @时间： 2018-06-04
	 */
	@RequestMapping(value="/delete")
	public void delete(RequestData requestData) {};
	//更新
	@RequestMapping(value="/update")
	public void update(RequestData requestData) {};
	//查询
	@RequestMapping(value="/list")
	public List<RolePermission> list(RequestData requestData) {
		return null;
	};
}
