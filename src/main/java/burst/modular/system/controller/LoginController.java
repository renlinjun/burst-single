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
import burst.modular.system.service.IAccountService;

/**
 * 登录操作相关controller
 * @author RLJ
 *
 */
@RestController
@RequestMapping(value="")
public class LoginController {
	
	@Autowired
	private IAccountService accountService;
	
	@Autowired
	private JwtToken jwtToken;
	
	/**
	 * 登录接口
	 * @return
	 */
	@RequestMapping(value="/login")
	public ResponseData login(@RequestBody RequestData requestData) {
		boolean flag = accountService.isLegal(requestData);
		if(flag) {
			String userId = requestData.getData().getString("user_id");
			String token = jwtToken.createToken(userId);
			JSONObject json = new JSONObject();
			json.put("token", token);
			return new ResponseData(ResultConstants.LOGIN_SUCCESS, json);
		}
		return new ResponseData(ResultConstants.LOGIN_CHECK_FAIL,"用户名密码错误");
	}

}
