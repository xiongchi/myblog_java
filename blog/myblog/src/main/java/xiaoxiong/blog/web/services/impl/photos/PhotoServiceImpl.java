package xiaoxiong.blog.web.services.impl.photos;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xiaoxiong.blog.web.convert.AlbumConvert;
import xiaoxiong.blog.web.convert.PhotoConvert;
import xiaoxiong.blog.web.dto.photos.AlbumDto;
import xiaoxiong.blog.web.dto.photos.PhotoDto;
import xiaoxiong.blog.web.entity.photos.Album;
import xiaoxiong.blog.web.entity.photos.Photo;
import xiaoxiong.blog.web.exceptions.ParamErrorException;
import xiaoxiong.blog.web.repository.photos.AlbumRepository;
import xiaoxiong.blog.web.repository.photos.PhotoRepository;
import xiaoxiong.blog.web.services.photos.PhotoService;

import java.util.List;

/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/6/11
 */
@Service("photoService")
public class PhotoServiceImpl implements PhotoService {

    private static Logger log = LoggerFactory.getLogger(PhotoServiceImpl.class);


    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private PhotoRepository photoRepository;

    @Autowired
    private PhotoConvert photoConvert;

    @Autowired
    private AlbumConvert albumConvert;

    @Override
    public Page<AlbumDto> findAllAlbum(Pageable pageable) {
        Page<Album> albums = albumRepository.findAll(pageable);
        log.info("查询所有相册{}", JSONObject.toJSONString(albums));
        Page<AlbumDto> albumDtos = albumConvert.toDtoPage(albums, pageable);
        return albumDtos;
    }

    @Override
    public Page<PhotoDto> findPhotosByAlbumId(Integer albumId, Pageable pageable){
        Page<Photo> photos = photoRepository.findPhotosByAlbumId(albumId, pageable);
        Page<PhotoDto> photoDtos = photoConvert.toDtoPage(photos, pageable);
        log.info("查询{}相册中所有相片{}", albumId, JSONObject.toJSONString(photos));
        return photoDtos;
    }

    @Override
    @Transactional
    public void savePhotos(List<PhotoDto> photoDtos) throws ParamErrorException {
        if(photoDtos == null || photoDtos.size() == 0) {
            log.debug("存入参数为空");
            throw new ParamErrorException("照片参数为空");
        }
        log.info("存入照片{}", JSONObject.toJSONString(photoDtos));
        List<Photo> photos = photoConvert.toEntityList(photoDtos);
        for (Photo p : photos) {
            photoRepository.save(p);
        }
    }

    @Override
    public void saveAlbum(AlbumDto aDto) {
        Album album = albumConvert.toEntity(aDto);
        log.info("存入相册{}", JSONObject.toJSONString(aDto));
        albumRepository.save(album);
    }

}
