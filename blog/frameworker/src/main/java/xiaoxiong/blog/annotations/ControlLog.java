package xiaoxiong.blog.annotations;

import java.lang.annotation.*;

/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/6/24
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ControlLog {
    String value();
}
