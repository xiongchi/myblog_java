package xiaoxiong.blog.web.services.impl.articles;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import xiaoxiong.blog.MyblogApplication;
import xiaoxiong.blog.web.dto.articles.ArticleTypeDto;
import xiaoxiong.blog.web.services.articles.IArticleService;

import java.util.List;

/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/7/19
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyblogApplication.class)
@WebAppConfiguration
public class ArticleServiceImplTest {

    @Autowired
    private IArticleService articleService;

    @Test
    public void saveArticle() {
    }

    @Test
    public void findOne() {
    }

    @Test
    public void findAll() {
    }

    @Test
    public void findRecomArticles() {
    }

    @Test
    public void findTypeAll() {
    }

    @Test
    public void findCTimeAll() {
    }

    @Test
    public void findMdTimeAll() {
    }

    @Test
    public void findAllType() {
        List<ArticleTypeDto> allType = articleService.findAllType();
        System.out.println(JSON.toJSONString(allType));
    }
}