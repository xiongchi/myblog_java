package xiaoxiong.blog.web.services.inf.user;


import xiaoxiong.blog.web.dto.user.AdminDto;

/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/6/26
 */
public interface IAdminService {
    AdminDto getAdminByName(String adminName);

    void saveAdmin(AdminDto dto);

}
