package burst.core.config;

/**
 * 返回的结果枚举
 * @author RLJ
 *
 */
public enum ResultConstants {
	
	//成功
	SUCCESS_CODE(0,"操作成功"),
	//未登录或登录超时
	NO_LOGIN(1,"用户未登录或登录超时");
	
	private ResultConstants(int code,String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	private int code;
	private String msg;
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}

}
