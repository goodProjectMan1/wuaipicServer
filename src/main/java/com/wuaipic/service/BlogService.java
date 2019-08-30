package com.wuaipic.service;

import com.wuaipic.model.BlogEntity;
import com.wuaipic.result.ResultEntity;

public interface BlogService {
    ResultEntity insertBlog(BlogEntity blogEntity);
    ResultEntity selectOneBlog(String blogId);

    ResultEntity selectAllBlog();

    ResultEntity updateBlog(BlogEntity blogEntity);
}
