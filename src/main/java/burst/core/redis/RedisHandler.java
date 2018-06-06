package burst.core.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
/**
 * redis操作类
 * @author RLJ
 *
 */
@Component
public class RedisHandler {
	
	//应用程序相关配置
	/*@Autowired
	private ApplicationProperties appPro;*/
	
	//原生redis
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	//以fastjson的序列化方式存取
	@Autowired
	@Qualifier("jsonRedisTemplate")
	private RedisTemplate<String,Object> jsonRedisTemplate;
	
	public boolean hasKey(String key) {
		return redisTemplate.hasKey(key);
	}
	
	
	/**
	 * 向redis中存入json格式的数据
	 * @param key
	 * @param json
	 */
	public void put(String key,JSONObject json) {
		jsonRedisTemplate.opsForValue().set(key, json);
	}
	
	/**
	 * 向redis中存入json格式的数据
	 * @param key
	 * @param json
	 */
	public void put(String key,Object obj) {
		redisTemplate.opsForValue().set(key, obj);
	}
	
	public Object getObj(String key) {
		if(redisTemplate.hasKey(key)) {
			return redisTemplate.opsForValue().get(key);
		}
		return null;
	}
	
	/**
	 * 从redis中获取json数据
	 * @param key
	 * @return
	 */
	public JSONObject getJSONValue(String key) {
		if(jsonRedisTemplate.hasKey(key)) {
			return (JSONObject)jsonRedisTemplate.opsForValue().get(key);
		}
		return new JSONObject();
	}
	
}
