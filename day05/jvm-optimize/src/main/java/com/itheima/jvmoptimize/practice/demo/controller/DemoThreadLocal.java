package com.itheima.jvmoptimize.practice.demo.controller;

import com.itheima.jvmoptimize.practice.demo.service.TbArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * -Xmx1g -Xms1g
 * -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=D:/jvm/dump/heapdemo.hprof
 */
@RestController
@RequestMapping("/threadlocal")
public class DemoThreadLocal {

    @GetMapping
    public ResponseEntity test() {
        error();
        return ResponseEntity.ok().build();
    }

    private void error() {
        throw new RuntimeException("出错了");
    }

}
