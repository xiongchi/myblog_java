package xiaoxiong.blog.response;

import java.util.Date;

/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/9/3
 */
public class AdminResponse {

    private String userId;

    private String adminIcon;

    private String adminName;

    private Date createTime;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAdminIcon() {
        return adminIcon;
    }

    public void setAdminIcon(String adminIcon) {
        this.adminIcon = adminIcon;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
