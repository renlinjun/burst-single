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
	private String accountName;
	//人员ID
	private String userId;
	//人员编号
	private String userCode;
	//人员姓名
	private String userName;
	//所属部门
	private List<Dept> depts;
	
	

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
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
	
	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setDepts(List<Dept> depts) {
		this.depts = depts;
	} 

}
