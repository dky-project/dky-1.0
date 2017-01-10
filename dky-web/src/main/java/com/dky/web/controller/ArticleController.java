package com.dky.web.controller;

import com.dky.business.repository.biz.ArticleService;
import com.dky.common.bean.Article;
import com.dky.common.param.ArticleQueryParam;
import com.dky.common.response.PageList;
import com.dky.common.response.ReturnT;
import com.dky.common.response.view.ArticleView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 文章
 * Created by wonpera on 2017/1/7.
 */
@RestController
@RequestMapping("article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "page",name = "查询文章分页")
    public ReturnT<PageList<ArticleView>> page(ArticleQueryParam param){
        return articleService.findBageById(param);
    }

    @RequestMapping(value = "list",name = "查询文章列表")
    public ReturnT<List<Article>> list(){
        return articleService.queryArticleList();
    }


    @RequestMapping(value = "getById",name = "文章详细信息")
    public ReturnT<Article> getById(@RequestParam(value = "id",required = false) Long id){
        if(id == null){
            return new ReturnT<>().failureData("文章id不能为空");
        }
        return articleService.getArticleById(id);
    }
}
