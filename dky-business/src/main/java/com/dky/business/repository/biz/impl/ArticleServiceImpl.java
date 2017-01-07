package com.dky.business.repository.biz.impl;

import com.dky.business.repository.biz.ArticleService;
import com.dky.business.repository.repository.ArticleMapper;
import com.dky.common.bean.Article;
import com.dky.common.param.ArticleQueryParam;
import com.dky.common.response.PageList;
import com.dky.common.response.ReturnT;
import com.dky.common.response.view.ArticleView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wonpera on 2017/1/7.
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper mapper;

    @Override
    public ReturnT<List<Article>> queryArticleList() {
        return new ReturnT<>().sucessData(mapper.queryArticleList());
    }

    @Override
    public ReturnT<Article> getArticleById(Long id) {
        return new ReturnT<>().sucessData(mapper.getArticleById(id));
    }

    @Override
    public ReturnT<PageList<ArticleView>> findBageById(ArticleQueryParam param) {
        return new ReturnT<>().sucessData(findPage(param));
    }

    private PageList<ArticleView> findPage(ArticleQueryParam param) {
        Article article = new Article();
        BeanUtils.copyProperties(param,article);
        return new PageList<ArticleView>(mapper.queryByPage(article), mapper.count(article), param.getPageNo(), param.getPageSize());
    }
}
