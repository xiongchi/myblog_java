package xiaoxiong.blog.web.repository.user;


import org.springframework.data.jpa.repository.JpaRepository;
import xiaoxiong.blog.web.entity.user.Admin;

/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/6/26
 */
public interface AdminRepository  extends JpaRepository<Admin, Integer> {

    Admin findAdminByAdminName(String name);
}
