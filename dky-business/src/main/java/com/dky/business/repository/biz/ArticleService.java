package com.dky.business.repository.biz;

import com.dky.common.bean.Article;
import com.dky.common.param.ArticleQueryParam;
import com.dky.common.response.PageList;
import com.dky.common.response.ReturnT;
import com.dky.common.response.view.ArticleView;

import java.util.List;

/**
 * Created by wonpera on 2017/1/7.
 */
public interface ArticleService {

    ReturnT<List<Article>> queryArticleList();

    ReturnT<Article> getArticleById(Long id);

    ReturnT<PageList<ArticleView>> findBageById(ArticleQueryParam param);
}
