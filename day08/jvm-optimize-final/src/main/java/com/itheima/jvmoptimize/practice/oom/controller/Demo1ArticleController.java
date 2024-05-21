package com.itheima.jvmoptimize.practice.oom.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.jvmoptimize.practice.oom.pojo.ArticleDto;
import com.itheima.jvmoptimize.practice.oom.service.ArticleService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * -XX:+HeapDumpOnOutOfMemoryError
 */
@RestController
@RequestMapping("/article")
public class Demo1ArticleController {
//    volatile int count = 0;
//    @PostConstruct
//    public void init(){
//
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        while (true){
//            executorService.submit(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(++count);
//                    try {
//                        Thread.sleep(1000 * 1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
//        }
//
//    }

    @Autowired
    private ArticleService articleService;

    @PostMapping("/demo1/{id}")
    public void article1(@PathVariable("id") long id, @RequestBody ArticleDto article){
        article.setId(id);
        articleService.asyncSaveArticle(article);
    }

    @PostMapping("/demo2/{id}")
    public void article2(@PathVariable("id") long id, @RequestBody ArticleDto article){
        article.setId(id);
        articleService.saveArticle(article);
    }

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/demo3/{id}")
    public void article3(@PathVariable("id") long id, @RequestBody ArticleDto article) throws JsonProcessingException {
        article.setId(id);
        rabbitTemplate.convertAndSend("jvm-test",null,  objectMapper.writeValueAsString(article));
    }
}
