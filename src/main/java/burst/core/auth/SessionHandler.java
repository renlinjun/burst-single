package burst.core.auth;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.hutool.core.util.StrUtil;

/**
 * 对session的操作类
 * @author RLJ
 *
 */
@Component
public class SessionHandler {
	
	@Autowired
	private JwtToken jwtToken;
	/**
	 * 检查token是否有效
	 * @param request
	 * @return
	 */
	public boolean checkSession(HttpServletRequest request) {
		//获取验证权限请求头的Authorization,从"Authorization"中获取token
		boolean isTokenApprove = false;
		String token = request.getHeader("Authorization");
		//如果token未null
		if(StrUtil.isEmpty(token)) {
			return false;
		}
		isTokenApprove = jwtToken.verifyToken(token);
		//如果token合法则将token放入request请求中
		if(isTokenApprove) {
			setTokenToRequest(request,token);
		}
		return isTokenApprove;
	}
	
	//将token存入放入请求信息中
	private void setTokenToRequest(HttpServletRequest request,String token) {
		request.setAttribute("token", token);
	}


}
