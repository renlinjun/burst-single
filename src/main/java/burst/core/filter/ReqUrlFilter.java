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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;

import burst.core.config.AuthProperties;
import burst.core.config.ResultConstants;
import burst.core.model.ResponseData;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;

/**
 * 对url进行过滤
 * @author RLJ
 *
 */
@WebFilter(value="/*")
@Order(-1)
public class ReqUrlFilter implements Filter {

	private Logger log = LoggerFactory.getLogger(ReqUrlFilter.class);
	
	@Autowired
	private AuthProperties authProperties;
	
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = ((HttpServletRequest)request);
		
		String reqUrl = httpRequest.getRequestURI();
		//判断请求的url是否为null
		if(StrUtil.isEmpty(reqUrl)) {
			log.error("请求的URL地址为null");
			response.setCharacterEncoding("UTF-8");    
			response.setContentType("application/json; charset=utf-8");
			ResponseData result = new ResponseData(ResultConstants.SYS_ERROR,"系统错误");
			response.getWriter().write(JSONUtil.parse(result).toString());
			response.getWriter().flush();  
	        response.getWriter().close();
		}
		//判断是否为登录操作
		if(authProperties.getLoginUrl().endsWith(authProperties.getLoginUrl())) {
			//chain.doFilter(request, response);
			return;
		}
		
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
