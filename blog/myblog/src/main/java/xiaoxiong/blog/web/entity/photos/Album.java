package xiaoxiong.blog.web.entity.photos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/6/11
 */
@Entity
@Table(name = "album")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class Album implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer albumId;

    private String albumName;

    private String albumType;

    private Date albumTime;

    public Album() {}

    public Album(String albumName, String albumType) {
        this.albumName = albumName;
        this.albumType = albumType;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumType() {
        return albumType;
    }

    public void setAlbumType(String albumType) {
        this.albumType = albumType;
    }

    public Date getAlbumTime() {
        return albumTime;
    }

    public void setAlbumTime(Date albumTime) {
        this.albumTime = albumTime;
    }
}
