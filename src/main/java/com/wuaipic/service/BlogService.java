package com.wuaipic.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wuaipic.model.BlogEntity;

import java.util.List;
import java.util.Map;

public interface BlogService {
    int insertBlog(BlogEntity blogEntity);
    BlogEntity selectOneBlog(String blogId);

    List<BlogEntity> selectAllBlog();

    Map<String,Object> selectAllBlogPage(Page page);


    int updateBlog(BlogEntity blogEntity);

    Map<String,String> deleteBlogByBlogId(String blogId);
}
