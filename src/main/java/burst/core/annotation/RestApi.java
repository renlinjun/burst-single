package burst.core.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
@RequestMapping
public @interface RestApi {
	//操作名称
	String name() default "";
	@AliasFor(annotation=RequestMapping.class)
	String[] path() default {};
	@AliasFor(annotation=RequestMapping.class)
	RequestMethod[] method() default {};
	//操作代码
	String code() default "";
	//是否需要登录
	boolean useLogin() default true;
	//是否需要签名验证
	boolean isSign() default true;
	//是否需要权限验证
	boolean needPermission() default true;;
	
}
