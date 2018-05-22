package burst.core.aop;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import burst.core.config.ResultConstants;
import burst.core.model.ResponseData;

@RestController
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseData exceptionHandler() {
		System.out.println("执行拦截器");
		return new ResponseData(ResultConstants.EXCEPTION_CODE, "系统错误");
	}
}
