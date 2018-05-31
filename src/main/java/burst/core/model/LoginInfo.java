package burst.core.model;

import java.io.Serializable;
import java.util.List;

import burst.modular.system.entity.Dept;
/**
 * 登录信息
 * @author RLJ
 *
 */
public class LoginInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//账户名
	private String accountId;
	//人员ID
	private String userId;
	//人员姓名
	private String userName;
	//所属部门
	private List<Dept> depts;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public List<Dept> getDepts() {
		return depts;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setDepts(List<Dept> depts) {
		this.depts = depts;
	} 

}
