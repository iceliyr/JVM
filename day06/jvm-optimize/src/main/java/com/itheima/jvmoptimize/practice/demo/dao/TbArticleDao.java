package com.itheima.jvmoptimize.practice.demo.dao;

import com.itheima.jvmoptimize.practice.demo.pojo.TbArticle;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (TbArticle)表数据库访问层
 *
 * @author makejava
 * @since 2023-10-06 23:55:58
 */
@Mapper
public interface TbArticleDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbArticle queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param tbArticle  查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<TbArticle> queryAllByLimit(@Param("article") TbArticle tbArticle, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param tbArticle 查询条件
     * @return 总行数
     */
    long count(TbArticle tbArticle);

    /**
     * 新增数据
     *
     * @param tbArticle 实例对象
     * @return 影响行数
     */
    int insert(TbArticle tbArticle);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbArticle> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TbArticle> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TbArticle> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TbArticle> entities);

    /**
     * 修改数据
     *
     * @param tbArticle 实例对象
     * @return 影响行数
     */
    int update(TbArticle tbArticle);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    Long countIfAbsent(@Param("ids") List<Integer> ids);
}

