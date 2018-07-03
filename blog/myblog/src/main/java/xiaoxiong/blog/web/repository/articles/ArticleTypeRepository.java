package xiaoxiong.blog.web.repository.articles;


import org.springframework.data.jpa.repository.JpaRepository;
import xiaoxiong.blog.web.entity.articles.ArticleType;

public interface ArticleTypeRepository extends JpaRepository<ArticleType, Integer> {
}
