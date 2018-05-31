package burst.core.auth;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import burst.core.config.AuthProperties;
import burst.core.redis.RedisHandler;
import cn.hutool.core.date.DateUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtToken {
	
	@Autowired
	private AuthProperties authProperties;
	
	@Autowired
	private RedisHandler redisHandler;
	
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
		//如果后期需要修改为一个人只能在一个地方登录则需要将键值对调换以后再实现
		redisHandler.put(token, userId);
		return token;
	}
	
	
	/**
	 * 验证token,判断token在redis中是否超时，token是否合法
	 * @param token
	 * @return 
	 * 		验证结果，通过返回true，否则返回false
	 */
	public boolean verifyToken(String token) {
		
		String secret = authProperties.getSecret();
		
		try {
			//判断redis中是否有值，如果有则证明token在redis中未过期
			if(!redisHandler.hasKey(token)) {
				return false;
			}
				
			//验证token是否合法
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
