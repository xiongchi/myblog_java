package xiaoxiong.blog.security.browser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;
import xiaoxiong.blog.security.browser.authentication.AuthFailureHandler;
import xiaoxiong.blog.security.browser.authentication.AuthSuccessHandler;
import xiaoxiong.blog.security.core.constants.SecurityConstants;
import xiaoxiong.blog.security.core.properties.SecurityProperties;



/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/6/24
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private OncePerRequestFilter myCorsFilter;

    /**
     * 自定义成功处理器
     */
    private AuthSuccessHandler authSuccessHandler = new AuthSuccessHandler();

    /**
     * 自定义失败处理器
     */
    private AuthFailureHandler authFailureHandler = new AuthFailureHandler();

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(myCorsFilter,UsernamePasswordAuthenticationFilter.class).formLogin()
                .loginPage(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
                .loginProcessingUrl(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM)
                .successHandler(authSuccessHandler)
                .failureHandler(authFailureHandler)
                .and()
//                //不用验证的url
                .authorizeRequests()
                .antMatchers(
                        SecurityConstants.DEFAULT_UNAUTHENTICATION_URL,
                        SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM,
                        securityProperties.getBrowser().getSignUpUrl()
                )
                .permitAll()
                //验证所有请求
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }




}
