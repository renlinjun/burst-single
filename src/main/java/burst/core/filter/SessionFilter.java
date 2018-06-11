package burst.core.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;

import burst.core.auth.JwtToken;
import burst.core.config.AuthProperties;
import burst.core.config.ResultConstants;
import burst.core.model.ResponseData;
import cn.hutool.json.JSONUtil;

/**
 * 登录过滤器，判断是否有token并且token是否合法
 * @author RLJ
 *
 */
@WebFilter(urlPatterns="/*")
@Order(value=1)
public class SessionFilter implements Filter {

	@Autowired
	private AuthProperties authProperties;
	
	@Autowired
	private JwtToken jwtToken;
	
	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		
		HttpServletRequest httpRequest = ((HttpServletRequest)request);
		//如果为不开启权限验证，则直接跳过该过滤器
		if(!authProperties.isOpen()) {
			filterChain.doFilter(request, response);
			return;
		}
		
		//如果直接调用用户登录，则不进行权限验证
		if(httpRequest.getRequestURI().endsWith(authProperties.getLoginUrl())) {
			filterChain.doFilter(request, response);
			return;
		} 
		
		
		//获取验证权限请求头的Authorization,从"Authorization"中获取token
		boolean isTokenApprove = false;
		String token = httpRequest.getHeader("Authorization");
		isTokenApprove = jwtToken.verifyToken(token);
		//将token放入request请求中
		setTokenToRequest(httpRequest,token);
		//如果token验证通过，则执行下一个过滤器，否则返回信息
		if(isTokenApprove) {
			filterChain.doFilter(request, response);
			return;
		}else {
			response.setCharacterEncoding("UTF-8");    
			response.setContentType("application/json; charset=utf-8");
			
			ResponseData result = new ResponseData(ResultConstants.NO_LOGIN);
			response.getWriter().write(JSONUtil.parse(result).toString());
			response.getWriter().flush();  
	        response.getWriter().close();
		}
		
	}
	
	//将token存入放入请求信息中
	private void setTokenToRequest(HttpServletRequest request,String token) {
		request.setAttribute("token", token);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
	}

}
