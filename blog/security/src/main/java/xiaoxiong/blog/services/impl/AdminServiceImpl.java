package xiaoxiong.blog.services.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import xiaoxiong.blog.entity.Admin;
import xiaoxiong.blog.exceptions.AuthenticationException;
import xiaoxiong.blog.exceptions.UserException;
import xiaoxiong.blog.repository.BlogAdminRepository;
import xiaoxiong.blog.request.AdminRequest;
import xiaoxiong.blog.response.AdminResponse;
import xiaoxiong.blog.services.IAdminService;
import xiaoxiong.blog.utils.MD5Util;
import xiaoxiong.blog.utils.RandomUtil;

/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/9/3
 */
@Service("adminService")
public class AdminServiceImpl implements IAdminService {

    @Autowired
    private BlogAdminRepository blogAdminRepository;

    @Override
    public AdminResponse registerService(AdminRequest adminRequest) {

        if (adminExist(adminRequest.getAdminName())) throw new UserException("用户名存在");

        String password = adminRequest.getAdminPassword();
        String passwordAgain = adminRequest.getPasswordAgain();
        if (!password.equals(passwordAgain)) {
            throw new AuthenticationException("两次密码不一致");
        }
        // 增加盐值后 加密存入数据库
        String salt = RandomUtil.getSalt();
        String dbPassword = MD5Util.md5Password(password, salt);
        Admin admin = new Admin(adminRequest.getAdminName(), dbPassword, salt);
        Admin save = blogAdminRepository.save(admin);

        AdminResponse adminResponse = new AdminResponse();
        BeanUtils.copyProperties(save, adminResponse);
        return adminResponse;
    }

    public Boolean adminExist(String adminName) {
        Admin admin = blogAdminRepository.findAdminByAdminName(adminName);
        if (admin != null) {
            return true;
        } else {
            return false;
        }
    }
}
