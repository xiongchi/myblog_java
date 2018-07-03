package xiaoxiong.blog.web.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialUser;
import org.springframework.stereotype.Component;
import xiaoxiong.blog.web.dto.user.AdminDto;
import xiaoxiong.blog.web.exceptions.AuthenticationException;
import xiaoxiong.blog.web.services.user.IAdminService;

/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/6/24
 */
@Component
public class MyUserDetailsServices implements UserDetailsService {

    @Autowired
    private IAdminService adminService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        AdminDto adminDto = adminService.getAdminByName(s);
        if(adminDto == null){
            throw new AuthenticationException("用户名找不到");
        }
        //加密
        String password = adminDto.getAdminPassword();
        return new SocialUser(s, password,
                true, true, true, true,
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
