package xiaoxiong.blog.web.services.impl.articles;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import xiaoxiong.blog.MyblogApplication;
import xiaoxiong.blog.web.dto.user.AdminDto;
import xiaoxiong.blog.web.services.impl.user.AdminServiceImpl;

/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/6/26
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyblogApplication.class)
@WebAppConfiguration
public class AdminServiceImplTest {

    @Autowired
    private AdminServiceImpl adminService;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Test
    public void getAdminByName() {
        AdminDto adminByName = adminService.getAdminByName("xiongchi");
        System.out.println(adminByName);
    }

    @Test
    public void  saveAdmin() {
        AdminDto adminDto = new AdminDto();
        adminDto.setAdminName("adc");
//        adminDto.setAdminPassword(passwordEncoder.encode("1111"));
        adminDto.setUserId(1);
        adminService.saveAdmin(adminDto);
    }
}