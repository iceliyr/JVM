package com.itheima.jvmoptimize.practice.oom.pojo;

import java.io.Serializable;

/**
 * (TbArticle)实体类
 *
 * @author makejava
 * @since 2023-10-06 23:55:59
 */
public class TbArticle implements Serializable {
    private static final long serialVersionUID = -48799947125707294L;

    private Long id;

    private String title;

    private String content;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}

