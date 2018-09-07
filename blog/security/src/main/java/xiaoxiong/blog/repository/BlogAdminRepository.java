package xiaoxiong.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xiaoxiong.blog.entity.Admin;

/**
 * @Author: XiongChi
 * @Description: 用户操作
 * @Date: 2018/9/3
 */
public interface BlogAdminRepository extends JpaRepository<Admin, String> {

    Admin findAdminByAdminName(String adminName);

}
