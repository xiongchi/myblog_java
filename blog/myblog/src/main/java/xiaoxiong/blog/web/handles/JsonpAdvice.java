package xiaoxiong.blog.web.handles;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

/**
 * 处理jsonp get请求的跨域问题
 * 还可以通过CORS(跨域资源共享)处理
 */
@ControllerAdvice(basePackages = "xiaoxiong.blog.web.controller")
public class JsonpAdvice extends AbstractJsonpResponseBodyAdvice {
    public JsonpAdvice() {
        super("callback","jsonp");
    }
}
