package burst.config.conver;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 请求数据类型转换converter
 * @author RLJ
 *
 */
@Configuration
@EnableWebMvc
public class HttpMessageConverConfig implements WebMvcConfigurer {
	
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(new RequestDataMessageConverter());
	}
	
}
