package burst.modular.auth.impl;

import burst.core.model.ResponseData;

public interface ILoginService {
	
	public ResponseData checkUser(String userId,String password);

}
