package xiaoxiong.blog.web.convert;


import org.springframework.stereotype.Component;
import xiaoxiong.blog.convert.Convert;
import xiaoxiong.blog.web.entity.photos.Photo;
import xiaoxiong.blog.web.dto.photos.PhotoDto;

/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/6/11
 */
@Component("photoConvert")
public class PhotoConvert extends Convert<PhotoDto, Photo> {
}
