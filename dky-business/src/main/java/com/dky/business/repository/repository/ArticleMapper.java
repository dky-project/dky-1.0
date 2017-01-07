package com.dky.business.repository.repository;

import com.dky.common.bean.Article;

import java.util.List;

@MyBatisRepository
public interface ArticleMapper {

    List<Article> queryArticleList();

    Article getArticleById(Long id);
}