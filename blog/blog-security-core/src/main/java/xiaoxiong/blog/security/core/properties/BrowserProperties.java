package xiaoxiong.blog.security.core.properties;

import org.springframework.util.StringUtils;

/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/6/29
 */
public class BrowserProperties {

    /**
     * 默认登录界面
     */
    private String signUpUrl = "/sign.html";

    public String getSignUpUrl() {
        return signUpUrl;
    }

    public void setSignUpUrl(String signUpUrl) {
        if(!StringUtils.isEmpty(signUpUrl))
        this.signUpUrl = signUpUrl;
    }
}
