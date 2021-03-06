package xiaoxiong.blog.web.entity.reply;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/7/2
 */
@Entity
@Table(name = "reply")
public class Reply {
    //评论id
    @Id
    private String replyId;
    //评论内容
    private String replyContent;
    //评论时间
    @Temporal(TemporalType.TIMESTAMP)
    private Date replyTime;
    //用户id
    private Integer userId;
    //赞
    private Integer replyZan;
    //文章id
    private Integer articleId;

    public String getReplyId() {
        return replyId;
    }

    public void setReplyId(String replyId) {
        this.replyId = replyId;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getReplyZan() {
        return replyZan;
    }

    public void setReplyZan(Integer replyZan) {
        this.replyZan = replyZan;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }
}
