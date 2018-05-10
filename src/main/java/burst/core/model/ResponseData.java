package burst.core.model;

import com.alibaba.fastjson.JSONObject;

/**
 * 统一数据返回格式
 * @author RLJ 2018-05-10
 * 
 *
 */
public class ResponseData {
	private String code;
	private String msg;
	private JSONObject data;
	
	public ResponseData(JSONObject data) {
		this.data = data;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
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
