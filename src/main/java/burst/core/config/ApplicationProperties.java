package burst.core.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 应用相关信息配置类
 * @author REN
 *
 */
@Component
@ConfigurationProperties(prefix="app")
public class ApplicationProperties {
	
	//应用名称
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
