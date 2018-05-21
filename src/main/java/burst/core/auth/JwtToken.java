package burst.core.auth;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import burst.core.config.AuthProperties;
import cn.hutool.core.date.DateUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtToken {
	
	@Autowired
	private AuthProperties authProperties;
	
	/**
	 * 生成token,将用户id放入token中
	 * @return
	 */ 
	public String createToken(String userId) {
		String secret = authProperties.getSecret();
		String issuer = authProperties.getIssuer();
		
		Date nowTime = DateUtil.date(Calendar.getInstance());
		
		Map<String,Object> claim = new HashMap<String,Object>();
		claim.put("userId", "ren");
		String token = Jwts.builder()
			.signWith(SignatureAlgorithm.HS256, secret) //设置加密算法和秘钥
			.addClaims(claim) //设置数据
			.setIssuer(issuer) //签发者
			.setIssuedAt(nowTime) //签发时间
//			.setExpiration(DateUtil.offsetSecond(nowTime, 30)) //过期时间
			.setExpiration(DateUtil.offsetHour(nowTime, 24)) //过期时间
			.compact();
		
		return token;
	}
	
	/**
	 * 验证token
	 * @param token
	 * @return 
	 * 		验证结果，通过返回true，否则返回false
	 */
	public boolean verifyToken(String token) {
		String secret = authProperties.getSecret();
		try {
		Claims claim = Jwts.parser()
			.setSigningKey(secret)
			.parseClaimsJws(token)
			.getBody();
			//从token中获取用户ID
			System.out.println(claim.get("userId"));
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
