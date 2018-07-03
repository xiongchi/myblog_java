package xiaoxiong.blog.security.core.constants;

/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/6/24
 */
public interface SecurityConstants {

    /**
     * 需要身份跳转时 默认跳转的url
     */
    String DEFAULT_UNAUTHENTICATION_URL = "/authentication/require";

    /**
     * 默认用户名密码登录 跳转url
     */
    String DEFAULT_LOGIN_PROCESSING_URL_FORM = "/authentication/form";

}
