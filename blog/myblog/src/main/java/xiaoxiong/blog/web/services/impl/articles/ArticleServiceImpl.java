package xiaoxiong.blog.web.services.impl.articles;


import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import xiaoxiong.blog.web.convert.ArticleConvert;
import xiaoxiong.blog.web.convert.ArticleTypeConvert;
import xiaoxiong.blog.web.dto.articles.ArticleDto;
import xiaoxiong.blog.web.dto.articles.ArticleTypeDto;
import xiaoxiong.blog.web.entity.articles.Article;
import xiaoxiong.blog.web.entity.articles.ArticleType;
import xiaoxiong.blog.web.repository.articles.ArticleRepository;
import xiaoxiong.blog.web.repository.articles.ArticleTypeRepository;
import xiaoxiong.blog.web.services.inf.articles.IArticleService;
import xiaoxiong.blog.exceptions.DataNotFindException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("articleService")
public class ArticleServiceImpl implements IArticleService {

    private static Logger log = LoggerFactory.getLogger(ArticleServiceImpl.class);

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ArticleTypeRepository typeRepository;

    @Autowired
    private ArticleConvert articleConvert;

    @Autowired
    private ArticleTypeConvert articleTypeConvert;

    @Override
    public void saveArticle(ArticleDto dto) {
        Article article = new Article();
        BeanUtils.copyProperties(dto, article);
        articleRepository.save(article);
    }

    /**
     * 查找单个文章信息
     * @param articleId
     * @return
     */
    @Override
    public ArticleDto findOne(int articleId) {
        Article article = articleRepository.findOne(articleId);
        ArticleDto dto = getArticleDto(article);
        return dto;
    }

    @Override
    public Page<ArticleDto> findAll(Pageable pageable) {
        Page<Article> page = articleRepository.findAll(pageable);
        //获取所有文章类型id
        List<Article> articles = page.getContent();
        List<ArticleDto> articleDtos = new ArrayList<>();
        for(Article article : articles){
            ArticleDto dto = getArticleDto(article);
            articleDtos.add(dto);
        }
        //构建新的Page
        Page<ArticleDto> articleDtoPage = new PageImpl<ArticleDto>(articleDtos,pageable,page.getTotalElements());
//        List<ArticleType> types = articles.stream().map(e -> typeRepository.findOne(e.getArticleTypeid()))
//                .collect(Collectors.toList());
        return articleDtoPage;
    }

    /**
     * 查询所有推荐文章
     * @return
     */
    @Override
    public List<ArticleDto> findRecomArticles() {
        List<Article> articles = articleRepository.findRecommdArticles();
        log.info("db---推荐文章" + JSONObject.toJSONString(articles));
        List<ArticleDto> articleDtos = articleConvert.toDaoList(articles);
        return articleDtos;
    }

    /**
     * 获取文章类型 封装dto
     * @param article
     * @return
     */
    private ArticleDto getArticleDto(Article article) {
        if(article == null){
            throw new DataNotFindException("文章信息找不到");
        }
        ArticleDto dto = new ArticleDto();
        BeanUtils.copyProperties(article, dto);
        //没有类别 不查找
        if(article.getArticleTypeid() != null) {
            ArticleType type = typeRepository.findOne(article.getArticleTypeid());
            BeanUtils.copyProperties(type, dto);
        }
        return dto;
    }

    @Override
    public Page<Article> findTypeAll(Integer articleTypeid, Pageable pageable) {
        return articleRepository.findAllByArticleTypeid(articleTypeid, pageable);
    }

    @Override
    public Page<Article> findCTimeAll(Date start, Date end, Pageable pageable) {
        return articleRepository.findAllByArticleTimeBetween(start, end, pageable);
    }

    @Override
    public Page<Article> findMdTimeAll(Date start, Date end, Pageable pageable) {
        return articleRepository.findArticlesByArticleTimeBetween(start, end, pageable);
    }

    @Override
    public List<ArticleTypeDto> findAllType() {
        List<ArticleType> types = typeRepository.findAll();
        List<ArticleTypeDto> typeDtos = articleTypeConvert.toDaoList(types);
        return typeDtos;
    }
}
