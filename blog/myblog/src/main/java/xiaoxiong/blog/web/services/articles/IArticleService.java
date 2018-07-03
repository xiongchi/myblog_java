package xiaoxiong.blog.web.services.articles;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import xiaoxiong.blog.web.dto.ArticleDto;
import xiaoxiong.blog.web.entity.articles.Article;
import xiaoxiong.blog.web.dto.ArticleDto;
import xiaoxiong.blog.web.entity.articles.Article;

import java.util.Date;
import java.util.List;

public interface IArticleService {

    void saveArticle(ArticleDto dto);
    ArticleDto findOne(int articleId);
    Page<ArticleDto> findAll(Pageable pageable);

    List<ArticleDto> findRecomArticles();
    //查找不同类型
    Page<Article> findTypeAll(Integer articleTypeid, Pageable pageable);
    //查找创建时间内的文章
    Page<Article> findCTimeAll(Date start, Date end, Pageable pageable);
    //查找修改时间内的文章
    Page<Article> findMdTimeAll(Date start, Date end, Pageable pageable);

}
