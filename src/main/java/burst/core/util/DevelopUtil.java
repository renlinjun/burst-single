package burst.core.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 开发过程整用于生成某些数据或者验证某些结果时的工具类
 * 紧供开发人员使用
 * @author RLJ 2018-05-12
 *
 */
public class DevelopUtil {
	
	/**
	 * 生成BASE64Encode字符串
	 * @param str
	 * @throws IOException
	 */
	public static void getBase64Encode(String str) throws IOException {
		BASE64Encoder encoder = new BASE64Encoder();
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] textByte = str.getBytes("UTF-8");
		//编码
		String encodedText = encoder.encode(textByte);
		System.out.println(encodedText);
		//解码
		System.out.println(new String(decoder.decodeBuffer(encodedText), "UTF-8"));
	}
	
	public static void main(String[] args) throws IOException {
		DevelopUtil.getBase64Encode("sedin");
	}

}
