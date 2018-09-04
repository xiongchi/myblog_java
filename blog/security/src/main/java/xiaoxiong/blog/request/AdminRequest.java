package xiaoxiong.blog.request;

/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/9/3
 */
public class AdminRequest {

    private String adminName;

    private String adminPassword;

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
