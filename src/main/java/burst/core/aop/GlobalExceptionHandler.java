package burst.core.aop;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import burst.core.config.ResultConstants;
import burst.core.exception.CustomException;
import burst.core.model.ResponseData;

/**
 * @author renlinjun
 */
@RestController
@ControllerAdvice
public class GlobalExceptionHandler {
	
	private Logger logger = LoggerFactory.getLogger("全局异常拦截器日志");
	
	/**
	 * 全局异常拦截器
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public ResponseData exceptionHandler(HttpServletRequest request,  
            Exception exception) {
		
		exception.printStackTrace();
		return new ResponseData(ResultConstants.EXCEPTION_CODE, "系统异常");
	}
	
	/**
	 * 数据库操作异常
	 * @return
	 */
	@ExceptionHandler(SQLException.class)
	public ResponseData sqlExceptionHandler(HttpServletRequest request,  
            Exception exception) {
		logger.error("数据库异常：",exception);
		exception.printStackTrace();
		return new ResponseData(ResultConstants.EXCEPTION_CODE, "数据操作异常");
	}
	
	@ExceptionHandler(CustomException.class)
	public ResponseData customExceptionHandler(HttpServletRequest request, CustomException exception) {
		exception.printStackTrace();
		//记录异常发生位置
		logger.error(exception.getMsg(), exception.getClass(),exception);
		return new ResponseData(exception.getCode(), exception.getMsg());
	}
}
