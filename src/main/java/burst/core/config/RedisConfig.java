package burst.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;


@Configuration
public class RedisConfig {
	/**
	 * 设置redisTemplate的序列化方式为fastJson的序列化方式
	 * @param connectionFactory
	 * @return
	 */
	@Bean("jsonRedisTemplate")
	public RedisTemplate<Object, Object> FastJsonReidsTemplateConfig(RedisConnectionFactory connectionFactory) {
		RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(connectionFactory);
		redisTemplate.setDefaultSerializer(new GenericFastJsonRedisSerializer());
		return redisTemplate;
	}
	
	/**
	 * 设置redisTemplate的key序列化方式为string类型的序列化方式
	 * @param connectionFactory
	 * @return
	 */
	@Bean("jsonRedisTemplate")
	public RedisTemplate<Object, Object> reidsTemplateConfig(RedisConnectionFactory connectionFactory) {
		RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(connectionFactory);
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		return redisTemplate;
	}
	
}
