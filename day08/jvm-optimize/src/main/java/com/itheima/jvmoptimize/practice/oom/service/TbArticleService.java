package com.itheima.jvmoptimize.practice.oom.service;

import com.itheima.jvmoptimize.practice.oom.pojo.TbArticle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (TbArticle)表服务接口
 *
 * @author makejava
 * @since 2023-10-06 23:55:59
 */
public interface TbArticleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbArticle queryById(Long id);

    /**
     * 分页查询
     *
     * @param tbArticle     筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<TbArticle> queryByPage(TbArticle tbArticle, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param tbArticle 实例对象
     * @return 实例对象
     */
    TbArticle insert(TbArticle tbArticle);

    /**
     * 修改数据
     *
     * @param tbArticle 实例对象
     * @return 实例对象
     */
    TbArticle update(TbArticle tbArticle);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    Long countIfAbsent(List<Integer> ids);
}
