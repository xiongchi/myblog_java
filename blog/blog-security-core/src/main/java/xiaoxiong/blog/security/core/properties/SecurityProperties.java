package xiaoxiong.blog.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/6/29
 */
@ConfigurationProperties(prefix = "xiaoxiong.security")
public class SecurityProperties {

    private BrowserProperties browser = new BrowserProperties();


    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }
}
