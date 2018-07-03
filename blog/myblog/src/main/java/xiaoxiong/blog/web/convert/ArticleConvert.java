package xiaoxiong.blog.web.convert;


import org.springframework.stereotype.Component;
import xiaoxiong.blog.web.dto.ArticleDto;
import xiaoxiong.blog.web.entity.articles.Article;

/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/6/21
 */
@Component("articleConvert")
public class ArticleConvert extends Convert<ArticleDto, Article> {
}
