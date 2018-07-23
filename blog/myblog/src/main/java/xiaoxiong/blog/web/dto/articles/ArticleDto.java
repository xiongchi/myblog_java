package xiaoxiong.blog.web.dto.articles;


import com.fasterxml.jackson.annotation.JsonView;

import java.io.Serializable;
import java.util.Date;

public class ArticleDto implements Serializable {

    /**
     * 基础数据
     */
    public interface ArticleBase{}

    /**
     * 简介数据
     */
    public interface ArticleBrief extends ArticleBase{}

    /**
     * 内容数据
     */
    public interface ArticleContent extends ArticleBase{}

    //文章id
    @JsonView({ArticleBase.class})
    private Integer articleId;
    //标题
    @JsonView(ArticleBase.class)
    private String articleTitle;
    //文章作者
    @JsonView(ArticleBase.class)
    private String articleAuthor;
    //文章简介
    @JsonView(ArticleBrief.class)
    private String articleBrief;
    //文章类型名
    @JsonView(ArticleBase.class)
    private String typeName;
    //创建时间
    @JsonView(ArticleBase.class)
    private Date articleTime;
    //文章内容
    @JsonView(ArticleContent.class)
    private String articleContent;


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

    public String getArticleBrief() {
        return articleBrief;
    }

    public void setArticleBrief(String articleBrief) {
        this.articleBrief = articleBrief;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Date getArticleTime() {
        return articleTime;
    }

    public void setArticleTime(Date articleTime) {
        this.articleTime = articleTime;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    @Override
    public String toString() {
        return "ArticleDto{" +
                "articleId='" + articleId + '\'' +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleAuthor='" + articleAuthor + '\'' +
                ", articleBrief='" + articleBrief + '\'' +
                ", typeName='" + typeName + '\'' +
                ", articleTime=" + articleTime +
                ", articleContent='" + articleContent + '\'' +
                '}';
    }
}
