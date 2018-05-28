package burst.core.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisUtil {
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	public Object get(String key) {
		return null;
	}
	
	

}
