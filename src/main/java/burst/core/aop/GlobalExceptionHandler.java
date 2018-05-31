package burst.core.aop;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import burst.core.config.ResultConstants;
import burst.core.model.ResponseData;

/**
 * @author renlinjun
 */
@RestController
@ControllerAdvice
public class GlobalExceptionHandler {
	
	/**
	 * 全局异常拦截器
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public ResponseData exceptionHandler(HttpServletRequest request,  
            Exception exception) {
		exception.printStackTrace();
		System.out.println("执行拦截器");
		return new ResponseData(ResultConstants.EXCEPTION_CODE, "系统异常");
	}
	
	/**
	 * 数据库操作异常
	 * @return
	 */
	@ExceptionHandler(SQLException.class)
	public ResponseData sqlExceptionHandler(HttpServletRequest request,  
            Exception exception) {
		exception.printStackTrace();
		return new ResponseData(ResultConstants.EXCEPTION_CODE, "数据操作异常");
	}
}
