package xiaoxiong.blog.web.repository.photos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import xiaoxiong.blog.web.entity.photos.Photo;
import xiaoxiong.blog.web.entity.photos.Photo;

/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/6/11
 */
public interface PhotoRepository extends JpaRepository<Photo, Integer> {

    Page<Photo> findPhotosByAlbumId(Integer albumId, Pageable pageable);
}
