package burst.config.conver;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import burst.core.model.RequestData;

public class RequestDataMessageConverter implements HttpMessageConverter<RequestData> {

	@Override
	public boolean canRead(Class clazz, MediaType mediaType) {
		if(!clazz.equals(RequestData.class)) {
			System.out.println("类型匹配");
			return false;
		}
		if(!mediaType.getType().contentEquals("application/json")) {
			return false;
		}
		return true;
	}

	@Override
	public boolean canWrite(Class clazz, MediaType arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List getSupportedMediaTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RequestData read(Class clazz, HttpInputMessage arg1) throws IOException, HttpMessageNotReadableException {
		
		return null;
	}

	@Override
	public void write(RequestData requestData, MediaType contentType, HttpOutputMessage outputMessage)
			throws IOException, HttpMessageNotWritableException {
		// TODO Auto-generated method stub
		
	}

	

}
