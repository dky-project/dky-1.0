package com.dky.business.repository.repository;

import com.dky.common.bean.Article;
import com.dky.common.response.view.ArticleView;

import java.util.List;

@MyBatisRepository
public interface ArticleMapper {

    List<Article> queryArticleList();

    Article getArticleById(Long id);

    List<ArticleView> queryByPage(Article article);

    int count(Article article);
}