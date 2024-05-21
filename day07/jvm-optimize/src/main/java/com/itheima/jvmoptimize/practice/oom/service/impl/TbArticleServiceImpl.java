package com.itheima.jvmoptimize.practice.oom.service.impl;

import com.itheima.jvmoptimize.practice.oom.dao.TbArticleDao;
import com.itheima.jvmoptimize.practice.oom.pojo.TbArticle;
import com.itheima.jvmoptimize.practice.oom.service.TbArticleService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TbArticle)表服务实现类
 *
 * @author makejava
 * @since 2023-10-06 23:55:59
 */
@Service("articleService")
public class TbArticleServiceImpl implements TbArticleService {
    @Resource
    private TbArticleDao articleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbArticle queryById(Long id) {
        return this.articleDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param tbArticle     筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<TbArticle> queryByPage(TbArticle tbArticle, PageRequest pageRequest) {
        //long total = this.articleDao.count(tbArticle);
        return new PageImpl<>(this.articleDao.queryAllByLimit(tbArticle, pageRequest), pageRequest, 0);
    }

    /**
     * 新增数据
     *
     * @param tbArticle 实例对象
     * @return 实例对象
     */
    @Override
    public TbArticle insert(TbArticle tbArticle) {
        this.articleDao.insert(tbArticle);
        return tbArticle;
    }

    /**
     * 修改数据
     *
     * @param tbArticle 实例对象
     * @return 实例对象
     */
    @Override
    public TbArticle update(TbArticle tbArticle) {
        this.articleDao.update(tbArticle);
        return this.queryById(tbArticle.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.articleDao.deleteById(id) > 0;
    }

    @Override
    public Long countIfAbsent(List<Integer> ids) {
        return articleDao.countIfAbsent(ids);
    }
}
