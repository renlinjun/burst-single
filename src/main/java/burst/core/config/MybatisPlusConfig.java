package burst.core.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("burst.modular.*.mapper*")
public class MybatisPlusConfig {
}
