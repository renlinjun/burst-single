package burst.oper;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import burst.core.model.RequestData;

@RestController
@RequestMapping(value="/api")
public class TestRest {

	@RequestMapping(value="/reqData",method=RequestMethod.POST)
	public void test(@RequestBody RequestData requestData) {
		System.out.println(requestData);
	}
}
