package com.itheima.jvmoptimize.practice.oom.service;

import com.itheima.jvmoptimize.practice.oom.pojo.ArticleDto;

public interface ArticleService {
    void saveArticle(ArticleDto article);
    void asyncSaveArticle(ArticleDto article);
}
