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
import burst.modular.system.entity.UserRole;
import burst.modular.system.service.IUserRoleService;
import cn.hutool.core.util.StrUtil;


/**
 * <p>
 * 人员角色关联表 前端控制层
 * </p>
 *
 * @author renlinjun
 * @since 2018-05-21
 */
@RestController
@RequestMapping("/system/userRole")
public class UserRoleController {
	
	@Autowired
	private IUserRoleService userRoleService;

	//添加UserRole
	@RequestMapping(value="/add")
	public ResponseData add(@RequestBody RequestData requestData) {
		int result = userRoleService.add(requestData);
		if(result<=0) {
			return new ResponseData(ResultConstants.OPT_FAIL,"操作失败");
		}
		return new ResponseData(ResultConstants.SUCCESS_RESPONSE);
	}
	//删除
	@RequestMapping(value="/delete")
	public void delete(RequestData requestData) {}
	//更新
	@RequestMapping(value="/update")
	public void update(RequestData requestData) {}
	//查询
	@RequestMapping(value="/list")
	public List<UserRole> list(RequestData requestData) {
		return null;
	}
	
	@RequestMapping(value="/queryByUserId")
	public ResponseData queryByUserId(@RequestBody RequestData requestData) {
		String userId = requestData.getData().getString("userId");
		if(StrUtil.isEmpty(userId)) {
			return new ResponseData(ResultConstants.DATA_CHECK_ERROR,"用户ID不能为null");
		}
		List<Role> roles = userRoleService.queryRoleByUserId(userId);
		return new ResponseData(ResultConstants.SUCCESS_RESPONSE,roles);
	}
	
	@RequestMapping(value="/addBatch")
	public ResponseData addBatch(@RequestBody RequestData requestData) {
		int result = userRoleService.addBatch(requestData);
		if(result<0) {
			return new ResponseData(ResultConstants.OPT_FAIL,"操作失败");
		}
		return new ResponseData(ResultConstants.SUCCESS_RESPONSE);
	}
}
