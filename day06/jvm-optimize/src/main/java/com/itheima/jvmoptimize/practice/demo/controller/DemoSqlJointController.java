package com.itheima.jvmoptimize.practice.demo.controller;

import com.itheima.jvmoptimize.practice.demo.pojo.TbArticle;
import com.itheima.jvmoptimize.practice.demo.service.TbArticleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * -Xmx1g -Xms1g
 * -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=D:/jvm/dump/heapdemo.hprof
 */
@RestController
@RequestMapping("/sqljoint")
public class DemoSqlJointController {

    /**
     * 服务对象
     */
    @Resource
    private TbArticleService articleService;

    /**
     * 判断批量id存在多少个
     *
     */
    @GetMapping
    public ResponseEntity countIfAbsent(int size) {
        //随机生成批量id
        List<Integer> ids = new Random().ints(0, 1000000).
                limit(size).boxed().collect(Collectors.toList());

        return ResponseEntity.ok(this.articleService.countIfAbsent(ids));
    }

}
