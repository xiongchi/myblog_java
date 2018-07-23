package xiaoxiong.blog.web.dto.photos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/6/11
 */
public class AlbumDto implements Serializable {

    private Integer albumId;

    private String albumName;

    private String albumType;

    private Date albumTime;

    private String albumPassword;

    private List<PhotoDto> photosList;

    public AlbumDto() {
    }

    public AlbumDto(Integer albumId, String albumName, String albumType) {
        this.albumId = albumId;
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

    public List<PhotoDto> getPhotosList() {
        return photosList;
    }

    public void setPhotosList(List<PhotoDto> photosList) {
        this.photosList = photosList;
    }

    public Date getAlbumTime() {
        return albumTime;
    }

    public void setAlbumTime(Date albumTime) {
        this.albumTime = albumTime;
    }

    public String getAlbumPassword() {
        return albumPassword;
    }

    public void setAlbumPassword(String albumPassword) {
        this.albumPassword = albumPassword;
    }
}
