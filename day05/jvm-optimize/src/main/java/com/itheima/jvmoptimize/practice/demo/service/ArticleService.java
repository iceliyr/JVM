package com.itheima.jvmoptimize.practice.demo.service;

import com.itheima.jvmoptimize.practice.demo.pojo.ArticleDto;

public interface ArticleService {
    void saveArticle(ArticleDto article);
    void asyncSaveArticle(ArticleDto article);
}
