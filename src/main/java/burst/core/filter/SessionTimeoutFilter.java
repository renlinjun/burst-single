package burst.core.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 校验token是否过期
 * @author RLJ
 *
 */
public class SessionTimeoutFilter  implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = ((HttpServletRequest)request);
		
		
	}

	@Override
	public void destroy() {
		
	}

}
