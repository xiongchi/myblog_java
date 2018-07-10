package xiaoxiong.blog.security.core.validate.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xiaoxiong.blog.security.core.properties.SecurityProperties;

/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/7/10
 */

@Configuration
public class ValidateCodeConfig {

    @Autowired
    private SecurityProperties securityProperties;

    /**
     * 可以重写图片验证码生成逻辑
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(name = "imageCodeGenerator")
    public ValidateCodeGenerator imageCodeGenerator(){
        ImageCodeGenerator codeGenerator = new ImageCodeGenerator();
        codeGenerator.setSecurityProperties(securityProperties);
        return codeGenerator;
    }

}
