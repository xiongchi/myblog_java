package xiaoxiong.blog.web.dto.articles;

/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/7/19
 */
public class ArticleTypeDto {

    //文章类型id
    private Integer articleTypeid;
    //文章类型名
    private String typeName;

    public Integer getArticleTypeid() {
        return articleTypeid;
    }

    public void setArticleTypeid(Integer articleTypeid) {
        this.articleTypeid = articleTypeid;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
