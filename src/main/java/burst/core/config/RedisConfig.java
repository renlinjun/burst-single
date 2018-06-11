package burst.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;


@Configuration
public class RedisConfig {
	/**
	 * 配置redisTemplat
	 * 返回序列化方式为fastJson的redisTemplate
	 * @param connectionFactory
	 * @return
	 */
	@Bean("jsonRedisTemplate")
	public RedisTemplate<String, Object> FastJsonRedisTemplateConfig(RedisConnectionFactory connectionFactory) {
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(connectionFactory);
		redisTemplate.setDefaultSerializer(new GenericFastJsonRedisSerializer());
		return redisTemplate;
	}
	
	/*@Bean(name="redisTemplate")
	public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
		return new RedisTemplate<Object, Object>();
	}*/
	
	/**
	 * 配置redisTemplate
	 * 返回key的序列化方式为string类型的序列化方式
	 * value的序列化方式为java serializer方式序列化
	 * @param connectionFactory
	 * @return
	 */
/*	@Bean("redisTemplate")
	public RedisTemplate<Object, Object> reidsTemplateConfig(RedisConnectionFactory connectionFactory) {
		RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(connectionFactory);
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		return redisTemplate;
	}
	*/
	/**
	 * 配置StringRedisTemplate
	 * @param connectionFactory
	 * @return
	 */
	@Bean("stringRedisTemplate")
	public StringRedisTemplate stringRedisTemplateConfig(RedisConnectionFactory connectionFactory) {
		return new StringRedisTemplate(connectionFactory);
	}
	
}
