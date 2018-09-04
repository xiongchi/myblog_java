package xiaoxiong.blog.web.convert;


import org.springframework.stereotype.Component;
import xiaoxiong.blog.convert.Convert;
import xiaoxiong.blog.web.dto.user.AdminDto;
import xiaoxiong.blog.web.entity.user.Admin;

/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/6/26
 */
@Component("adminConvert")
public class AdminConvert extends Convert<AdminDto, Admin> {
}
