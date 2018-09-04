package xiaoxiong.blog.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xiaoxiong.blog.exceptions.AuthenticationException;
import xiaoxiong.blog.repository.AdminRepository;
import xiaoxiong.blog.request.AdminRequest;
import xiaoxiong.blog.response.AdminResponse;
import xiaoxiong.blog.services.IAdminService;

/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/9/3
 */
@Service("adminService")
public class AdminServiceImpl implements IAdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public AdminResponse registerService(AdminRequest adminRequest) {

        String password = adminRequest.getAdminPassword();
        String passwordAgain = adminRequest.getPasswordAgain();
        if(!password.equals(passwordAgain)){
            throw new AuthenticationException("两次密码不一致");
        }

        return null;
    }
}
