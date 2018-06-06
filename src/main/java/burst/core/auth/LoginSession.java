package burst.core.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import burst.core.config.GolbalConstants;
import burst.core.config.ResultConstants;
import burst.core.context.ContextHolder;
import burst.core.context.RequestHolder;
import burst.core.exception.CustomException;
import burst.core.model.LoginInfo;
import burst.core.redis.RedisHandler;

/**
 * 登录信息操作类
 * @author RLJ
 *
 */
@Component
public class LoginSession {

	@Autowired
	private RedisHandler redisHandler;
	
	/**
	 * 获取当前对象
	 * @return
	 */
	public static LoginSession getCurrentSession() {
		return ContextHolder.getApplicationContext().getBean(LoginSession.class);
	}
	
	/**
	 * 根据token获取当前登录人的信息
	 * @return
	 */
	public LoginInfo getLoginInfo() {
		//获取当前请求的token
		String token = RequestHolder.getString(GolbalConstants.TOKEN_STR);
		//判断token是否为null
		if(token.equals("")) {
			try {
				throw new CustomException(ResultConstants.NO_LOGIN.getCode(), "未登录或登录超时");
			} catch (CustomException e) {
				e.printStackTrace();
				return null;
			}
		}
		//从缓存中获取登录信息
		Object obj = redisHandler.getObj(token+GolbalConstants.LOGIN_INFO_SUFFIX);
		//如果未获取到登录信息则抛出异常
		if(obj==null) {
			try {
				throw new CustomException(ResultConstants.NO_LOGIN.getCode(), "未登录或登录超时");
			} catch (CustomException e) {
				
			}
		}
		return (LoginInfo)obj;
	}
	
	
}
