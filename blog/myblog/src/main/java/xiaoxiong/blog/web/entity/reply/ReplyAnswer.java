package xiaoxiong.blog.web.entity.reply;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/7/4
 */
@Entity
@Table(name = "reply_answer")
public class ReplyAnswer {

    //回复id
    @Id
    private String answerId;
    //回复内容
    private String answerContent;
    //回复时间
    private Date answerTime;
    //回复人
    private Integer userId;
    //评论id
    private String replyId;

    public String getAnswerId() {
        return answerId;
    }

    public void setAnswerId(String answerId) {
        this.answerId = answerId;
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    public Date getAnswerTime() {
        return answerTime;
    }

    public void setAnswerTime(Date answerTime) {
        this.answerTime = answerTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getReplyId() {
        return replyId;
    }

    public void setReplyId(String replyId) {
        this.replyId = replyId;
    }
}
