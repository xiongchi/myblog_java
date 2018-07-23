package xiaoxiong.blog.web.convert;

import org.springframework.stereotype.Component;
import xiaoxiong.blog.web.dto.articles.ArticleTypeDto;
import xiaoxiong.blog.web.entity.articles.ArticleType;

/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/7/19
 */
@Component("articleTypeConvert")
public class ArticleTypeConvert extends Convert<ArticleTypeDto, ArticleType>  {
}
