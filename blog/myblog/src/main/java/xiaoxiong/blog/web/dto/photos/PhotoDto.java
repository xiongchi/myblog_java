package xiaoxiong.blog.web.dto.photos;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/6/11
 */
public class PhotoDto implements Serializable {

    public PhotoDto() {
    }

    public PhotoDto(Integer photoId, String photoName, Date photoTime, String photoDesc, String photoImg, Integer albumId) {
        this.photoId = photoId;
        this.photoName = photoName;
        this.photoTime = photoTime;
        this.photoDesc = photoDesc;
        this.photoImg = photoImg;
        this.albumId = albumId;
    }

    private Integer photoId;

    private String photoName;

    private Date photoTime;

    private String photoDesc;

    private String photoImg;

    private Integer albumId;

    public Integer getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public Date getPhotoTime() {
        return photoTime;
    }

    public void setPhotoTime(Date photoTime) {
        this.photoTime = photoTime;
    }

    public String getPhotoDesc() {
        return photoDesc;
    }

    public void setPhotoDesc(String photoDesc) {
        this.photoDesc = photoDesc;
    }

    public String getPhotoImg() {
        return photoImg;
    }

    public void setPhotoImg(String photoImg) {
        this.photoImg = photoImg;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }
}
