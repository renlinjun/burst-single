package burst.modular.auth;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import burst.core.auth.JwtToken;
import burst.core.config.ResultConstants;
import burst.core.model.LoginInfo;
import burst.core.model.ResponseData;
import burst.core.redis.RedisHandler;
import burst.modular.auth.impl.ILoginService;
import burst.modular.system.entity.Account;
import burst.modular.system.entity.Role;
import burst.modular.system.service.IAccountService;
import burst.modular.system.service.IUserRoleService;

@Service
public class LoginServiceImpl implements ILoginService {

	@Autowired
	private IAccountService accountService;
	@Autowired
	private IUserRoleService userRoleService;
	@Autowired
	private RedisHandler redisHandler;
	
	
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
			
			LoginInfo loginInfo = new LoginInfo();
			loginInfo.setAccountName(accountName);
			
			
			cacheRole(userId,token);
			
			return new ResponseData(ResultConstants.LOGIN_SUCCESS, json);
		}
		return new ResponseData(ResultConstants.LOGIN_CHECK_FAIL,"用户名密码错误"); 
	}
	
	/**
	 * 向redis中缓存人员对应的角色
	 * @param userId
	 */
	public void cacheRole(String userId,String token) {
		List<Role> roles = userRoleService.queryRoleByUserId(userId);
		redisHandler.put(token, roles);
	}
	
}
