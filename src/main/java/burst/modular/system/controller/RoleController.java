package burst.modular.system.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import burst.core.config.ResultConstants;
import burst.core.model.RequestData;
import burst.core.model.ResponseData;
import burst.modular.system.entity.Role;
import burst.modular.system.service.IRoleService;


/**
 * <p>
 * 角色表 前端控制层
 * </p>
 *
 * @author renlinjun
 * @since 2018-05-21
 */
@RestController
@RequestMapping("/system/role")
public class RoleController {
	
	@Autowired
	private IRoleService roleService;

	//添加Role
	@RequestMapping(value="/add")
	public ResponseData add(@RequestBody RequestData requestData) throws Exception {
		int result = roleService.add(requestData);
		if(result<=0) {
			return new ResponseData(ResultConstants.OPT_FAIL,"操作失败");
		}
		return new ResponseData(ResultConstants.SUCCESS_RESPONSE);
		
	};
	//删除
	@RequestMapping(value="/delete")
	public void delete(RequestData requestData) {};
	//更新
	@RequestMapping(value="/update")
	public void update(RequestData requestData) {};
	//查询
	@RequestMapping(value="/list")
	public List<Role> list(RequestData requestData) {
		return null;
	};

	/*-------------------进入业务 角色管理-------------------------*/

}
