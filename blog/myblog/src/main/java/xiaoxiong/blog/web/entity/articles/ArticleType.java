package xiaoxiong.blog.web.entity.articles;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "articletype")
public class ArticleType implements Serializable {
    //文章类型id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Override
    public String toString() {
        return "ArticleType{" +
                "articleTypeid=" + articleTypeid +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
