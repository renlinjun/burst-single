package burst.modular.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import burst.core.auth.JwtToken;
import burst.core.config.ResultConstants;
import burst.core.model.ResponseData;
import burst.modular.auth.impl.ILoginService;
import burst.modular.system.entity.Account;
import burst.modular.system.service.IAccountService;
import burst.modular.system.service.IUserRoleService;

@Service
public class LoginServiceImpl implements ILoginService {

	@Autowired
	private IAccountService accountService;
	
	private IUserRoleService userRoleService;
	
	
	@Autowired
	private JwtToken jwtToken;
	
	@Override
	public ResponseData checkUser(String accountName, String password) {
		//判断用户名密码是否合法
		Account account = accountService.checkAccount(accountName,password);
		if(account!=null) {
			String userId = account.getUserInfoId();
			String token = jwtToken.createToken(userId);
			JSONObject json = new JSONObject();
			json.put("token", token);
			return new ResponseData(ResultConstants.LOGIN_SUCCESS, json);
		}
		return new ResponseData(ResultConstants.LOGIN_CHECK_FAIL,"用户名密码错误"); 
	}
	
}
