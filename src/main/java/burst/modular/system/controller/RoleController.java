package burst.modular.system.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import burst.modular.system.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import burst.core.model.RequestData;
import java.util.List;
import burst.modular.system.entity.Role;


/**
 * <p>
 *  前端控制层
 * </p>
 *
 * @author renlinjun
 * @since 2018-05-16
 */
@RestController
@RequestMapping("/system/role")
public class RoleController {
	
	@Autowired
	private IRoleService roleService;

	//添加Role
	@RequestMapping(value="/add")
	public void add(RequestData data) {};
	//删除
	@RequestMapping(value="/delete")
	public void delete(RequestData data) {};
	//更新
	@RequestMapping(value="/update")
	public void update(RequestData data) {};
	//查询
	@RequestMapping(value="/list")
	public List<Role> list(RequestData data) {
		return null;
	};
}
