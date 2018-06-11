package burst.core.auth;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import burst.core.config.AuthProperties;
import burst.core.config.GolbalConstants;
import burst.core.config.ResultConstants;
import burst.core.exception.CustomException;
import burst.core.redis.RedisHandler;
import burst.modular.system.entity.OptResource;
import cn.hutool.core.util.StrUtil;

/**
 * 对请求的处理类
 * @author RLJ
 *
 */
public class RequestHandler {

	@Autowired
	private AuthProperties authProperties;
	@Autowired
	private RedisHandler redisHandler;
	
	/**
	 * 请求是否需要权限验证
	 * @return
	 */
	public boolean isAuthOpen() {
		return authProperties.isOpen();
	}
	
	/**
	 * 请求是否需要登录
	 * @param url
	 * @return 
	 * 		true:需要登录
	 *      false: 不需要登录
	 * @throws CustomException 
	 */
	@SuppressWarnings("unchecked")
	public boolean isNeedLogin(String url) throws CustomException {
		if(StrUtil.isEmpty(url)) {
			throw new CustomException(ResultConstants.SYS_ERROR, "请求的地址为null");
		}
		//如果为登录地址则不需要登录
		if(url.endsWith(authProperties.getLoginUrl())) {
			return false;
		}
		//获取所有资源
		Map<String,OptResource> optResources = (Map<String, OptResource>)redisHandler.getObj(GolbalConstants.ALL_OPT_RESOURCE);
		if(!optResources.containsKey(url)) {
			throw new CustomException(ResultConstants.SYS_ERROR, "请求Url不存在，请联系管理员");
		}
		//返回是否需要登录
		OptResource optResource = optResources.get(url);
		return optResource.isLogin();
	}
	
	
	
	
}
