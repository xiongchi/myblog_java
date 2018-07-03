package xiaoxiong.blog.web.services.impl.user;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xiaoxiong.blog.web.annotations.MethodLogAnno;
import xiaoxiong.blog.web.dto.user.UserDto;
import xiaoxiong.blog.web.entity.user.User;
import xiaoxiong.blog.web.repository.user.UserRepository;
import xiaoxiong.blog.web.services.user.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @MethodLogAnno("service---用户信息byId")
    public UserDto getUserById(int userId) {
        User user = userRepository.findUserByUserId(userId);
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        return userDto;
    }
}
