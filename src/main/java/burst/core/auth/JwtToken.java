package burst.core.auth;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import burst.core.config.AuthProperties;

@Component
public class JwtToken {
	
	@Autowired
	private AuthProperties authProperties;
	
	public String createToken() throws IllegalArgumentException, UnsupportedEncodingException {
		String secret = authProperties.getSecret();
		Algorithm algorithm = Algorithm.HMAC256(secret);
		String token = JWT.create()
		        .withIssuer(authProperties.getIssuer())//token发行者
		        .withAudience("sedin")
		        .sign(algorithm);
		return token;
	}
	
	
	/*public boolean verifyToken(String token) {
		JWTVerifier verifier = JWT.require(Algorithm.HMAC256(authProperties.getSecret())).build();
		DecodedJWT decodeJwt = null ;
		
		decodeJwt =  verifier.verify(token);
		decodeJwt.getClaims();
		
	}*/

}
