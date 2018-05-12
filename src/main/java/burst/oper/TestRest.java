package burst.oper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import burst.core.auth.JwtToken;
import burst.core.model.RequestData;

@RestController
@RequestMapping(value="/api")
public class TestRest {

	@Autowired
	private JwtToken jwtToken;
	
	@RequestMapping(value="/reqData",method=RequestMethod.POST)
	public String test(@RequestBody RequestData requestData) {
		return jwtToken.createToken();
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@RequestBody RequestData requestData) {
		return jwtToken.createToken();
	}
	
	@RequestMapping(value="/getData",method=RequestMethod.POST)
	public Object getData(@RequestBody RequestData requestData) {
		String token = requestData.getData().get("token").toString();
		return jwtToken.verifyToken(token);
	}
	
	
}
