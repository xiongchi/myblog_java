package xiaoxiong.blog.web.controller.photos;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import xiaoxiong.blog.web.exceptions.ParamErrorException;
import xiaoxiong.blog.web.services.photos.PhotoService;
import xiaoxiong.blog.web.dto.photos.AlbumDto;
import xiaoxiong.blog.web.dto.photos.PhotoDto;
import xiaoxiong.blog.web.exceptions.ParamErrorException;
import xiaoxiong.blog.web.properties.BlogProperties;
import xiaoxiong.blog.web.result.ResultMsg;
import xiaoxiong.blog.web.services.photos.PhotoService;
import xiaoxiong.blog.web.utils.ResultUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/6/11
 */
@RestController
@RequestMapping("photo")
public class PhotoController {

    private static Logger log = LoggerFactory.getLogger(PhotoController.class);


    @Autowired
    private PhotoService photoService;

    @Autowired
    private BlogProperties blogProperties;

    @GetMapping("allAlbums")
    public ResultMsg allAlbums(@PageableDefault(value = 6,
            sort = {"albumTime"}, direction = Sort.Direction.ASC) Pageable pageable){
        Page<AlbumDto> allAlbum = photoService.findAllAlbum(pageable);
        return ResultUtil.success(allAlbum);
    }

    @PostMapping("/saveAlbum")
    @CrossOrigin
    public ResultMsg saveAlbum(AlbumDto albumDto){
        photoService.saveAlbum(albumDto);
        return ResultUtil.success(albumDto);
    }


    @GetMapping("photoById/{albumId}")
    public ResultMsg photoById(@PathVariable("albumId") Integer albumId, @PageableDefault(value = 6,
            sort = {"photoTime"}, direction = Sort.Direction.ASC) Pageable pageable){
        Page<PhotoDto> photos = photoService.findPhotosByAlbumId(albumId, pageable);
        return ResultUtil.success(photos);
    }


    @PostMapping("uploadFile")
    @CrossOrigin
    public ResultMsg photoUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws ParamErrorException {
        if (file.isEmpty()) {
            throw new ParamErrorException("文件为空");
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();
        log.info("上传的文件名为：" + fileName);
        // 获取文件的后缀名
//        String filePath =  request.getSession().getServletContext().getRealPath("/");
        String filePath = blogProperties.getPhoto().getPath();
        File dest = new File(filePath + fileName);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            return ResultUtil.success("上传成功");
        } catch (IllegalStateException e) {
            log.error("上传失败");
        } catch (IOException e) {
            log.error("上传失败{}", e);
        }
        return ResultUtil.error();
    }


    //多文件上传
    @PostMapping("multiUpFiles")
    @CrossOrigin
    public ResultMsg handleFileUpload(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request)
                .getFiles("files");
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);
            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    stream = new BufferedOutputStream(new FileOutputStream(
                            new File(blogProperties.getPhoto().getPath() + file.getOriginalFilename())));
                    stream.write(bytes);
                    stream.close();
                } catch (Exception e) {
                    log.error( "You failed to upload " + i + " => "
                            + e.getMessage());
                }
            } else {
                log.error("You failed to upload " + i
                        + " because the file was empty.");
            }
        }
        return ResultUtil.success("上传成功");
    }




}
