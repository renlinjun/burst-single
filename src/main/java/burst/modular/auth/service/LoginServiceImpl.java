package burst.modular.auth.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import burst.core.auth.JwtToken;
import burst.core.config.GolbalConstants;
import burst.core.config.ResultConstants;
import burst.core.model.LoginInfo;
import burst.core.model.ResponseData;
import burst.core.redis.RedisHandler;
import burst.modular.auth.service.impl.ILoginService;
import burst.modular.system.entity.Account;
import burst.modular.system.entity.OptResource;
import burst.modular.system.entity.Permission;
import burst.modular.system.entity.Role;
import burst.modular.system.service.IAccountService;
import burst.modular.system.service.IPermissionResourceService;
import burst.modular.system.service.IRolePermissionService;
import burst.modular.system.service.IUserRoleService;

@Service
public class LoginServiceImpl implements ILoginService {

	@Autowired
	private IAccountService accountService;
	@Autowired
	private IUserRoleService userRoleService;
	@Autowired
	private IRolePermissionService rolePermission;
	@Autowired
	private IPermissionResourceService permissionResource;
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
			
			//缓存人员所拥有的资源
			cacheUserResource(userId,token);
			
			return new ResponseData(ResultConstants.LOGIN_SUCCESS, json);
		}
		return new ResponseData(ResultConstants.LOGIN_CHECK_FAIL,"用户名密码错误"); 
	}
	
	/**
	 * 向redis中缓存人员所拥有权限的菜单和资源
	 * @param userId
	 */
	public void cacheUserResource(String userId,String token) {
		//查询人员对应的角色列表
		List<Role> roles = userRoleService.queryRoleByUserId(userId);
		//缓存权限
		List<Permission> permissions = rolePermission.queryPermissionByRole(roles);
		//缓存权限
		redisHandler.put(token+GolbalConstants.PERMISSION_CACHE_SUFFIX, permissions);
		//查询权限对应的资源
		List<Map<String,OptResource>> optResources = permissionResource.queryOptResourceByPermission(permissions);
		//缓存权限对应的资源
		redisHandler.put(token+GolbalConstants.OPT_RESOURCE_CACHE_SUFFIX, optResources);
	}
	
	
}
