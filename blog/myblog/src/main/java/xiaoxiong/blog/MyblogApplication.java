package xiaoxiong.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import xiaoxiong.blog.web.properties.BlogProperties;

@SpringBootApplication(scanBasePackages = "xiaoxiong.blog")
@EnableConfigurationProperties(BlogProperties.class)
public class MyblogApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyblogApplication.class, args);
	}
}
