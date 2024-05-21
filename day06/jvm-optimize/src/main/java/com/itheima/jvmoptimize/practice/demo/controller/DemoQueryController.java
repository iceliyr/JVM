package com.itheima.jvmoptimize.practice.demo.controller;

import com.itheima.jvmoptimize.practice.demo.pojo.TbArticle;
import com.itheima.jvmoptimize.practice.demo.service.TbArticleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * -Xmx1g -Xms1g
 * -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=D:/jvm/dump/heapdemo.hprof
 */
@RestController
@RequestMapping("/hugequery")
public class DemoQueryController {

    /**
     * 服务对象
     */
    @Resource
    private TbArticleService articleService;

    /**
     * 分页查询
     *
     * @param tbArticle     筛选条件
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<TbArticle>> queryByPage(TbArticle tbArticle, int page,int size) {
//        size = Math.min(100,size);
        return ResponseEntity.ok(this.articleService.queryByPage(tbArticle, PageRequest.of(page,size)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<TbArticle> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.articleService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param tbArticle 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<TbArticle> add(TbArticle tbArticle) {
        return ResponseEntity.ok(this.articleService.insert(tbArticle));
    }

    /**
     * 编辑数据
     *
     * @param tbArticle 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<TbArticle> edit(TbArticle tbArticle) {
        return ResponseEntity.ok(this.articleService.update(tbArticle));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.articleService.deleteById(id));
    }

}
