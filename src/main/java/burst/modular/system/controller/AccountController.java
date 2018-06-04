package burst.modular.system.controller;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import burst.modular.system.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import burst.core.model.RequestData;
import burst.core.model.ResponseData;

import java.util.List;
import burst.modular.system.entity.Account;


/**
 * <p>
 *  前端控制层
 * </p>
 *
 * @author renlinjun
 * @since 2018-05-16
 */
@RestController
@RequestMapping("/system/account")
public class AccountController {
	
	@Autowired
	private IAccountService accountService;

	//添加Account
	@RequestMapping(value="/add")
	public void add(RequestData requestData) {}
	//删除
	@RequestMapping(value="/delete")
	public void delete(RequestData requestData) {};
	//更新
	@RequestMapping(value="/update")
	public ResponseData update(@RequestBody RequestData requestData) {
		return accountService.update(requestData);
	}
	//查询
	@RequestMapping(value="/list")
	public List<Account> list(RequestData requestData) {
		return null;
	};
}
