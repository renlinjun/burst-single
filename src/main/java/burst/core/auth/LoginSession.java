package burst.core.auth;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import burst.core.model.LoginInfo;
import burst.core.redis.RedisHandler;
import burst.core.util.HttpUtils;

/**
 * 登录信息操作类
 * @author RLJ
 *
 */
@Component
public class LoginSessionUtil {

	@Autowired
	private RedisHandler redisHandler;
	
	public LoginInfo getLoginInfo() {
		HttpServletRequest request = HttpUtils.getRequest();
		String token = request.getHeader("Authorization");
		return null;
	}
	
	
}
