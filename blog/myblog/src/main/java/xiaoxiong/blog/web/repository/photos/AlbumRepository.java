package xiaoxiong.blog.web.repository.photos;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import xiaoxiong.blog.web.entity.photos.Album;

/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/6/11
 */
public interface AlbumRepository extends JpaRepository<Album, Integer> {

    @Override
    Page<Album> findAll(Pageable pageable);
}
