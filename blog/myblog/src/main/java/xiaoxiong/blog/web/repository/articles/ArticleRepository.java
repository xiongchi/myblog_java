package xiaoxiong.blog.web.repository.articles;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import xiaoxiong.blog.web.entity.articles.Article;
import xiaoxiong.blog.web.entity.articles.Article;

import java.util.Date;
import java.util.List;


public interface ArticleRepository extends JpaRepository<Article, Integer> {

    Page<Article> findAllByArticleTypeid(Integer articleTypeid, Pageable pageable);

    Page<Article> findAllByArticleTimeBetween(Date start, Date end, Pageable pageable);

    Page<Article> findArticlesByArticleTimeBetween(Date start, Date end, Pageable pageable);

    @Query(value = "SELECT a.* from article_recom t left join article a on t.article_id = a.article_id " ,nativeQuery = true)
    List<Article> findRecommdArticles();

}
