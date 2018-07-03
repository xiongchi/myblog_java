package xiaoxiong.blog.web.services.impl.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xiaoxiong.blog.web.annotations.MethodLogAnno;
import xiaoxiong.blog.web.annotations.MethodLogAnno;
import xiaoxiong.blog.web.convert.AdminConvert;
import xiaoxiong.blog.web.dto.user.AdminDto;
import xiaoxiong.blog.web.entity.user.Admin;
import xiaoxiong.blog.web.repository.user.AdminRepository;
import xiaoxiong.blog.web.services.user.IAdminService;

/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/6/26
 */
@Component("adminServiceImpl")
public class AdminServiceImpl implements IAdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private AdminConvert adminConvert;

    @Override
    @MethodLogAnno("service---用户登录")
    public AdminDto getAdminByName(String adminName) {
        Admin a = adminRepository.findAdminByAdminName(adminName);
        AdminDto aDto = adminConvert.toDto(a);
        return aDto;
    }

    @Override
    @MethodLogAnno("service---用户存储")
    public void saveAdmin(AdminDto dto) {
        Admin a = adminConvert.toEntity(dto);
        adminRepository.save(a);
    }
}
