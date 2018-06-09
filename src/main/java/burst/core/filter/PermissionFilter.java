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

import org.springframework.core.annotation.Order;

@WebFilter(urlPatterns="/*")
@Order(value=3)
public class PermissionFilter  implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		
		HttpServletRequest httpRequest = ((HttpServletRequest)request);
		String reqUrl = httpRequest.getRequestURI();
		System.out.println("============"+reqUrl);
		filterChain.doFilter(request,response);
		return;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
