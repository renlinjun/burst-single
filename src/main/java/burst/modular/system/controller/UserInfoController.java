package burst.modular.system.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import burst.modular.system.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import burst.core.model.RequestData;
import java.util.List;
import burst.modular.system.entity.UserInfo;


/**
 * <p>
 * 人员信息表 前端控制层
 * </p>
 *
 * @author renlinjun
 * @since 2018-05-21
 */
@RestController
@RequestMapping("/system/userInfo")
public class UserInfoController {
	
	@Autowired
	private IUserInfoService userInfoService;

	//添加UserInfo
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
	public List<UserInfo> list(RequestData requestData) {
		return null;
	};
}
