package burst.modular.system.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import burst.core.model.RequestData;
import burst.core.model.ResponseData;
import burst.modular.system.entity.PermissionMenu;
import burst.modular.system.service.IPermissionMenuService;


/**
 * <p>
 * 权限菜单表 前端控制层
 * </p>
 *
 * @author renlinjun
 * @since 2018-05-21
 */
@RestController
@RequestMapping("/system/permissionMenu")
public class PermissionMenuController {
	
	@Autowired
	private IPermissionMenuService permissionMenuService;

	//添加PermissionMenu
	@RequestMapping(value="/add")
	public void add(RequestData requestData) {}
	
	/**
	 * 为权限分配菜单
	 * @return
	 */
	/**
	 * 为权限分配菜单
	 * @param requestData
	 * @return
	 */
	@RequestMapping(value="/assignMenu")
	public ResponseData assignMenu(@RequestBody RequestData requestData) {
		return permissionMenuService.assignMenu(requestData);
	}
	
	//删除
	@RequestMapping(value="/delete")
	public void delete(RequestData requestData) {};
	//更新
	@RequestMapping(value="/update")
	public void update(RequestData requestData) {};
	//查询
	@RequestMapping(value="/list")
	public List<PermissionMenu> list(RequestData requestData) {
		return null;
	};
}
