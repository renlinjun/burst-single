package burst;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class App {
  //测试test提交
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
