package xiaoxiong.blog.web.entity.articles;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "article")
//处理hibernate的lazy加载问题
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class Article implements Serializable{
    //文章id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer articleId;
    //标题
    private String articleTitle;
    //文章作者
    private String articleAuthor;
    //文章内容
    private String articleContent;
    //文章简介
    private String articleBrief;
    //文章创建时间
    //精确到分秒
//    @Temporal(TemporalType.TIME)
    @Temporal(TemporalType.TIMESTAMP)
    private Date articleTime;
    //文章修改时间
    @Temporal(TemporalType.TIMESTAMP)
    private Date articleMdtime;
    //文章类型id
    private Integer articleTypeid;

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleAuthor() {
        return articleAuthor;
    }

    public void setArticleAuthor(String articleAuthor) {
        this.articleAuthor = articleAuthor;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public Date getArticleTime() {
        return articleTime;
    }

    public void setArticleTime(Date articleTime) {
        this.articleTime = articleTime;
    }

    public Date getArticleMdtime() {
        return articleMdtime;
    }

    public void setArticleMdtime(Date articleMdtime) {
        this.articleMdtime = articleMdtime;
    }

    public Integer getArticleTypeid() {
        return articleTypeid;
    }

    public String getArticleBrief() {
        return articleBrief;
    }

    public void setArticleBrief(String articleBrief) {
        this.articleBrief = articleBrief;
    }

    public void setArticleTypeid(Integer articleTypeid) {
        this.articleTypeid = articleTypeid;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId='" + articleId + '\'' +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleAuthor='" + articleAuthor + '\'' +
                ", articleContent='" + articleContent + '\'' +
                ", articleBrief='" + articleBrief + '\'' +
                ", articleTime=" + articleTime +
                ", articleMdtime=" + articleMdtime +
                ", articleTypeid=" + articleTypeid +
                '}';
    }
}
