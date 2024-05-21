package com.itheima.jvmoptimize.practice.oom.service.impl;

import com.itheima.jvmoptimize.practice.oom.pojo.ArticleDto;
import com.itheima.jvmoptimize.practice.oom.service.ArticleService;
import com.itheima.jvmoptimize.practice.oom.utils.AliyunUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import static com.itheima.jvmoptimize.practice.oom.config.ThreadPoolTaskConfig.BUFFER_QUEUE;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private AliyunUtil aliyunUtil;

    @Override
    public void saveArticle(ArticleDto article) {
        BUFFER_QUEUE.add(article);
        int size = BUFFER_QUEUE.size();
        if( size > 0 && size % 10000 == 0){
            System.out.println(size);
        }
    }

    @Override
    @Async("asyncTaskExecutor")
    public void asyncSaveArticle(ArticleDto article) {
        aliyunUtil.verify(article.getTitle() + "。" + article.getContent());
    }
}
