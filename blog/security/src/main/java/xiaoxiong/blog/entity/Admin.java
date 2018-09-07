package xiaoxiong.blog.entity;

import xiaoxiong.blog.utils.RandomUtil;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author: XiongChi
 * @Description: 用户名密码表
 * @Date: 2018/8/24
 */
@Entity
@Table(name = "admin")
public class Admin {

    // 用户id
    @Id
    private String userId;

    private String adminName;

    private String adminPassword;
    // 盐值
    private String adminSalt;

    private String adminIcon;


    private Date createTime;

    public Admin() {
    }

    public Admin(String adminName, String adminPassword, String adminSalt) {
        this.userId = RandomUtil.uuid().substring(0, 18);
        this.adminName = adminName;
        this.adminPassword = adminPassword;
        this.adminSalt = adminSalt;
        this.createTime = new Date();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getAdminSalt() {
        return adminSalt;
    }

    public void setAdminSalt(String adminSalt) {
        this.adminSalt = adminSalt;
    }


    public String getAdminIcon() {
        return adminIcon;
    }

    public void setAdminIcon(String adminIcon) {
        this.adminIcon = adminIcon;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
