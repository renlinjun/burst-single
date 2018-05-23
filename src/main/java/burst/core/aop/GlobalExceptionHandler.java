package burst.core.aop;

import java.sql.SQLException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import burst.core.config.ResultConstants;
import burst.core.model.ResponseData;

@RestController
@ControllerAdvice
public class GlobalExceptionHandler {
	
	/**
	 * 全局异常拦截器
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public ResponseData exceptionHandler() {
		System.out.println("执行拦截器");
		return new ResponseData(ResultConstants.EXCEPTION_CODE, "系统异常");
	}
	
	/**
	 * 数据库操作异常
	 * @return
	 */
	@ExceptionHandler(SQLException.class)
	public ResponseData sqlExceptionHandler() {
		return new ResponseData(ResultConstants.EXCEPTION_CODE, "数据操作异常");
	}
}
