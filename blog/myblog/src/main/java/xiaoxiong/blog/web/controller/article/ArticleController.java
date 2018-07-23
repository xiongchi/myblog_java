package xiaoxiong.blog.web.controller.article;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import xiaoxiong.blog.web.dto.articles.ArticleDto;
import xiaoxiong.blog.web.dto.articles.ArticleTypeDto;
import xiaoxiong.blog.web.result.ResultMsg;
import xiaoxiong.blog.web.services.articles.IArticleService;
import xiaoxiong.blog.web.utils.ResultUtil;

import java.util.List;


@RestController
@RequestMapping("article")
public class ArticleController {

    @Autowired
    private IArticleService iArticleService;

    /**
     * id 查找文章
     * @param articeId
     * @return
     */
    @GetMapping("find/{id}")
    @CrossOrigin
    @JsonView(ArticleDto.ArticleContent.class)
    public ResultMsg findArticle(@PathVariable(name = "id") int articeId){
        ArticleDto article = iArticleService.findOne(articeId);
        return ResultUtil.success(article);
    }

    /**
     * 查找所有文章
     * @param pageable
     * @return
     */
    @GetMapping("all")
    @JsonView(ArticleDto.ArticleBrief.class)
    public ResultMsg  allArticle(@PageableDefault(value = 5,
            sort = {"articleTime"}, direction = Sort.Direction.ASC) Pageable pageable){
        Page<ArticleDto> articles = iArticleService.findAll(pageable);
        return ResultUtil.success(articles);
    }

    @PostMapping("/save")
    @CrossOrigin
    public ResultMsg saveArticle(ArticleDto article){
        iArticleService.saveArticle(article);
        return ResultUtil.success(article);
    }

    @GetMapping("/allTypes")
    public ResultMsg getAllTypes(){
        List<ArticleTypeDto> allType = iArticleService.findAllType();
        return ResultUtil.success(allType);
    }
}
