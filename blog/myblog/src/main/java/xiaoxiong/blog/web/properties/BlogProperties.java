package xiaoxiong.blog.web.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/6/24
 */
@ConfigurationProperties(prefix = "xiaoxiong.blog")
public class BlogProperties {

    private PhotoProperties photo = new PhotoProperties();

    public PhotoProperties getPhoto() {
        return photo;
    }

    public void setPhoto(PhotoProperties photo) {
        this.photo = photo;
    }
}
