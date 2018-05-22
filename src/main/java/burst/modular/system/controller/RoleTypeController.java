package burst.modular.system.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import burst.core.config.ResultConstants;
import burst.core.model.RequestData;
import burst.core.model.ResponseData;
import burst.modular.system.entity.RoleType;
import burst.modular.system.service.IRoleTypeService;


/**
 * <p>
 * 角色类型表 前端控制层
 * </p>
 *
 * @author renlinjun
 * @since 2018-05-21
 */
@RestController
@RequestMapping("/system/roleType")
public class RoleTypeController {
	
	@Autowired
	private IRoleTypeService roleTypeService;

	//添加RoleType
	@RequestMapping(value="/add")
	public ResponseData add(@RequestBody RequestData requestData) {
		int result = roleTypeService.add(requestData);
		if(result<=0) {
			return new ResponseData(ResultConstants.OPT_FAIL,"添加失败");
		}
		return new ResponseData(ResultConstants.SUCCESS_CODE);
	};
	//删除
	@RequestMapping(value="/delete")
	public void delete(RequestData requestData) {};
	//更新
	@RequestMapping(value="/update")
	public void update(RequestData requestData) {};
	//查询
	@RequestMapping(value="/list")
	public List<RoleType> list(RequestData requestData) {
		return null;
	};
}
