package burst.modular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import burst.core.auth.JwtToken;
import burst.core.model.RequestData;
import burst.core.redis.RedisHandler;

@RestController
@RequestMapping(value="/api")
public class TestRest {

	@Autowired
	private JwtToken jwtToken;
	
	@Autowired
	private RedisHandler handler;
	
	@RequestMapping(value="/reqData",method=RequestMethod.POST)
	public String test(@RequestBody RequestData requestData) {
		return jwtToken.createToken("ren");
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@RequestBody RequestData requestData) {
		return jwtToken.createToken("ren");
	}
	
	@RequestMapping(value="/getData",method=RequestMethod.POST)
	public Object getData(@RequestBody RequestData requestData) {
		String token = requestData.getData().get("token").toString();
		return jwtToken.verifyToken(token);
	}
	
	@RequestMapping(value="/put",method=RequestMethod.POST)
	public void putToRedis() {
		//handler.put("test1", "a");
		System.out.println("redis.......");
		JSONObject json = new JSONObject();
		json.put("json", 22);
		handler.put("test2", json);
		System.out.println(handler.hasKey("test2"));
	}
	
	
}
