package burst.core.context;

import javax.servlet.http.HttpServletRequest;

/**
 * request操作类
 * @author REN
 *
 */
public class RequestHolder {
	/**
	 * 从request中获取String属性值
	 * @param name
	 * @return
	 */
	public static String getString(String name) {
		HttpServletRequest request = ContextHolder.getRequest();
		Object obj = request.getAttribute(name);
		if(obj==null) {
			return "";
		}
		return obj.toString();
	}

}
