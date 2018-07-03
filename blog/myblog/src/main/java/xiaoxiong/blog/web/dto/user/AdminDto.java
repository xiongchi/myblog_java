package xiaoxiong.blog.web.dto.user;

import java.io.Serializable;

/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/6/26
 */
public class AdminDto implements Serializable {

    //用户id
    private Integer adminId;
    private String adminName;
    private String adminPassword;
    private Integer userId;

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
