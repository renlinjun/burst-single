package burst.modular.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import burst.core.auth.JwtToken;
import burst.core.config.ResultConstants;
import burst.core.model.RequestData;
import burst.core.model.ResponseData;
import burst.modular.auth.impl.ILoginService;

/**
 * 登录操作相关controller
 * @author RLJ
 *
 */
@RestController
@RequestMapping(value="")
public class LoginController {
	
	@Autowired
	private ILoginService loginService;
	
	@Autowired
	private JwtToken jwtToken;
	
	/**
	 * 登录接口
	 * @return
	 */
	@RequestMapping(value="/login")
	public ResponseData login(@RequestBody RequestData requestData) {
		String accountName = requestData.getData().getString("accountName");
		String password = requestData.getData().getString("password");
		return loginService.checkUser(accountName, password);
	}

}
