package burst.core.model;

import com.alibaba.fastjson.JSONObject;

import burst.core.config.ResultConstants;

/**
 * 统一数据返回格式
 * @author RLJ 2018-05-10
 * 
 *
 */
public class ResponseData {
	private int code;
	private String msg;
	private JSONObject data;
	
	public ResponseData(int code,String msg,JSONObject data) {
		this.data = data;
		this.code = code;
		this.msg = msg;
	}
	public ResponseData(int code,String msg) {
		this(code,msg,null);
	}
	
	public ResponseData(ResultConstants result,JSONObject data) {
		this.data = data;
		this.code = result.getCode();
		this.msg = result.getMsg();
	}
	
	public ResponseData(ResultConstants result) {
		this(result,null);
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public JSONObject getData() {
		return data;
	}
	public void setData(JSONObject data) {
		this.data = data;
	}
	

}
