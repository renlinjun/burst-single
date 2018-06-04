package burst.modular.system.entity.DTO;

/**
 * 账户数据传输模型
 * @author RLJ
 *
 */
public class AccountDTO {
	/**账户名*/
	private String accountName;
	/** 旧密码 */
	private String oldPassword;
	/** 新密码 */
	private String newPassword;
	/** 确认密码 */
	private String reNewPassword;
	
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getReNewPassword() {
		return reNewPassword;
	}
	public void setReNewPassword(String reNewPassword) {
		this.reNewPassword = reNewPassword;
	}

}
