package burst.core.config;

import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 权限校验配置类
 * @author RLJ
 *
 */
@Component
@ConfigurationProperties(prefix="auth")
public class AuthProperties {
	//密钥，用来加密生成TOKEN和解密TOKEN,必须有
	@NotNull
	private String secret;
	//token颁发者
	private String issuer = "burst";
	//验证用户名密码的登录地址
	private String loginUrl="/login";
	//是否开启全局权限验证，默认为true
	private boolean open=true;

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getIssuer() {
		return issuer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	public String getLoginUrl() {
		return loginUrl;
	}

	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

}
