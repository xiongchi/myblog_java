package xiaoxiong.blog.web.annotations;

import java.lang.annotation.*;

/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/6/24
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ControlAnno {
    String value();
}
