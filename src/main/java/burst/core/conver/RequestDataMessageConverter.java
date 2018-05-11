package burst.core.conver;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import com.alibaba.fastjson.JSONObject;

import burst.core.model.RequestData;

/**
 * 请求数据格式统一处理类
 * @author RLJ
 *
 */
public class RequestDataMessageConverter extends AbstractHttpMessageConverter<RequestData> {


	@Override
	public List<MediaType> getSupportedMediaTypes() {
		List<MediaType> mediaTypes = new ArrayList<MediaType>();
		mediaTypes.add(MediaType.ALL);
		return mediaTypes;
	}

	

	@Override
	protected boolean supports(Class<?> clazz) {
		if(RequestData.class.isAssignableFrom(clazz)) {
			return true;
		}
		return false;
	}

	@Override
	protected RequestData readInternal(Class<? extends RequestData> clazz, HttpInputMessage inputMessage)
			throws IOException, HttpMessageNotReadableException {
		RequestData requestData = new RequestData();
		InputStream is = inputMessage.getBody();	
		byte[] data = new byte[is.available()];
		is.read(data);
		String dataStr = new String(data, "UTF-8");
		JSONObject json = JSONObject.parseObject(dataStr);
		if(json.containsKey("data")) {
			requestData.setData(json.getJSONObject("data"));
		}else {
			requestData.setData(json);
		}
		return requestData;
	}

	/**
	 *向外客户端写该对象数据时会用到该方法
	 */
	@Override
	protected void writeInternal(RequestData requestData, HttpOutputMessage outputMessage)
			throws IOException, HttpMessageNotWritableException {
		// TODO Auto-generated method stub
		System.out.println("writeInternal。。。。。。");
		
		
	}

	

}
