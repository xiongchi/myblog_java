package xiaoxiong.blog.request;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/9/3
 */
public class AdminRequest {

    @NotNull(message = "用户名不能为空")
    private String adminName;

    @NotEmpty
    @Size(min = 6, message = "密码最少6位")
    private String adminPassword;

    @NotEmpty
    @Size(min = 6)
    private String passwordAgain;

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getPasswordAgain() {
        return passwordAgain;
    }

    public void setPasswordAgain(String passwordAgain) {
        this.passwordAgain = passwordAgain;
    }
}
