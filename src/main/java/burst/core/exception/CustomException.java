package burst.core.exception;

/**
 * 自定义异常抛出类
 * @author REN
 *
 */
public class  CustomException extends Exception {

	private static final long serialVersionUID = 1L;
	//异常代码
	private int code;
	//异常信息
	private String msg;
	//抛出异常的类
	private Class<?> clazz;
	
	public CustomException(int code,String msg) {
		this(code,msg,null);
	}
	
	public CustomException(int code,String msg,Class<?> clazz) {
		super();
		this.code = code;
		this.msg = msg;
		this.clazz = clazz;
	}
	
	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Class<?> getClazz() {
		return clazz;
	}

	public void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	}

}
