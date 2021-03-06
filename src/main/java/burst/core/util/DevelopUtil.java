package burst.core.util;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
	@SuppressWarnings("restriction")
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

	
	public static void getMD5Str(String sourceStr) throws NoSuchAlgorithmException {
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};         
            byte[] btInput = sourceStr.getBytes();  
            // 获得MD5摘要算法的 MessageDigest 对象  
            MessageDigest mdInst = MessageDigest.getInstance("MD5");  
            // 使用指定的字节更新摘要
            mdInst.update(btInput);  
            // 获得密文  
            byte[] md = mdInst.digest();  
            // 把密文转换成十六进制的字符串形式  
            int j = md.length;  
            char str[] = new char[j * 2];  
            int k = 0;  
            for (int i = 0; i < j; i++) {  
                byte byte0 = md[i];  
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];  
                str[k++] = hexDigits[byte0 & 0xf];  
            }
            System.out.println(str);
		
	}
	
	public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
		DevelopUtil.getMD5Str("123456");
	}

}
