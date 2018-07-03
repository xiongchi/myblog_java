package xiaoxiong.blog.security.core;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import xiaoxiong.blog.security.core.properties.SecurityProperties;

/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/6/29
 */
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityCoreConfig {
}
