package burst.core.config;

import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;

import burst.core.conver.RequestDataMessageConverter;

/**
 * 请求数据类型转换converter
 * @author RLJ
 *
 */
@Configuration
public class HttpMessageConverConfig {
	
	@Bean
	public HttpMessageConverters customConverters() {
	    HttpMessageConverter<?> requestMessageConverter = new RequestDataMessageConverter();
	    HttpMessageConverter<?> stringMessageConverter = new StringHttpMessageConverter();
	    return new HttpMessageConverters(requestMessageConverter,stringMessageConverter);
	}
	
}
