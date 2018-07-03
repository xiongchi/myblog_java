package xiaoxiong.blog.web.repository.user;


import org.springframework.data.jpa.repository.JpaRepository;
import xiaoxiong.blog.web.entity.user.User;

public interface UserRepository extends JpaRepository<User, String> {

    User findUserByUserId(int userId);
}
