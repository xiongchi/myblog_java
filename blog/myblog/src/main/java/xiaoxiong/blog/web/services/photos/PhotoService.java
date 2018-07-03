package xiaoxiong.blog.web.services.photos;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import xiaoxiong.blog.web.exceptions.ParamErrorException;
import xiaoxiong.blog.web.dto.photos.AlbumDto;
import xiaoxiong.blog.web.dto.photos.PhotoDto;
import xiaoxiong.blog.web.exceptions.ParamErrorException;

import java.util.List;

/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/6/11
 */
public interface PhotoService {

    Page<AlbumDto> findAllAlbum(Pageable pageable);

    Page<PhotoDto> findPhotosByAlbumId(Integer albumId, Pageable pageable);

    void savePhotos(List<PhotoDto> photoDtos) throws ParamErrorException;

    void saveAlbum(AlbumDto aDto);
}
