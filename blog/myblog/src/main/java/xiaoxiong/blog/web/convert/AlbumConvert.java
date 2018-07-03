package xiaoxiong.blog.web.convert;


import org.springframework.stereotype.Component;
import xiaoxiong.blog.web.dto.photos.AlbumDto;
import xiaoxiong.blog.web.entity.photos.Album;

/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/6/12
 */
@Component("albumConvert")
public class AlbumConvert extends Convert<AlbumDto, Album> {
}
