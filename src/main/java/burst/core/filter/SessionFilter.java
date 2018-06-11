package burst.core.filter;

import java.io.IOException;

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

import burst.core.auth.RequestHandler;
import burst.core.auth.SessionHandler;
import burst.core.config.ResultConstants;
import burst.core.exception.CustomException;
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
	private RequestHandler requestHandler;
	
	@Autowired
	private SessionHandler sessionHandler;
	
	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		
		HttpServletRequest httpRequest = ((HttpServletRequest)request);
		//如果为不开启权限验证，则直接跳过该过滤器
		if(!requestHandler.isAuthOpen()) {
			filterChain.doFilter(httpRequest, response);
			return;
		}
		
		String ReqUrl = httpRequest.getRequestURI();
		try {
			if(requestHandler.isNeedLogin(ReqUrl)) {
				//检查token
				if(!sessionHandler.checkSession(httpRequest)) { //如果token验证失败
					response.setCharacterEncoding("UTF-8");    
					response.setContentType("application/json; charset=utf-8");
					
					ResponseData result = new ResponseData(ResultConstants.NO_LOGIN);
					response.getWriter().write(JSONUtil.parse(result).toString());
					response.getWriter().flush();  
			        response.getWriter().close();
				}else {
					//检查签名
					if(!requestHandler.checkSign(ReqUrl)) { //如果签名失败
						response.setCharacterEncoding("UTF-8");    
						response.setContentType("application/json; charset=utf-8");
						//返回签名错误
						ResponseData result = new ResponseData(ResultConstants.DATA_CHECK_ERROR,"签名错误");
						response.getWriter().write(JSONUtil.parse(result).toString());
						response.getWriter().flush();  
				        response.getWriter().close();
					}else {
						filterChain.doFilter(httpRequest, response);
						return;
					}
				}
			}
		} catch (CustomException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
	}

}
