package burst.core.config;

/**
 * 返回的结果枚举
 * @author RLJ
 *
 */
public enum ResultConstants {
	
	//成功
	SUCCESS_RESPONSE(0,"操作成功"),
	//未登录或登录超时
	NO_LOGIN(1,"用户未登录或登录超时"),
	//登录成功
	LOGIN_SUCCESS(0,"登录成功");
	
	/**
	 * 成功标志
	 */
	public static int SUCCESS_CODE = 0;
	
	/**
	 * 登录验证失败
	 */
	public static int LOGIN_CHECK_FAIL = 2;
	/**
	 * 添加数据失败
	 */
	public static int OPT_FAIL = 3;
	/**
	 * 全局异常结果代码
	 */
	public static int EXCEPTION_CODE = 4;
	
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
