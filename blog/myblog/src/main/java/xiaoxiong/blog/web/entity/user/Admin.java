package xiaoxiong.blog.web.entity.user;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/6/26
 */

@Entity
@Table(name = "admin")
public class Admin implements Serializable {
    //用户id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
