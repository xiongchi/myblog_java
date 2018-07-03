package xiaoxiong.blog.security.browser.support;

/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/6/27
 */
public class SimpleResponse {

    private Integer code;

    private String content;

    public SimpleResponse(Integer code, String content) {
        this.code = code;
        this.content = content;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
