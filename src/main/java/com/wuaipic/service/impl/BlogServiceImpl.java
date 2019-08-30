package com.wuaipic.service.impl;

import com.wuaipic.mapper.BlogEntityMapper;
import com.wuaipic.model.BlogEntity;
import com.wuaipic.result.ResultEntity;
import com.wuaipic.service.BlogService;
import com.wuaipic.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogEntityMapper blogEntityMapper;
    @Override
    public ResultEntity insertBlog(BlogEntity blogEntity) {
        blogEntity.setBlogId(UUIDUtil.getOneUUID());
        blogEntity.setCreateTime(new Date());
        blogEntity.setBlogStatus("1");
        ResultEntity resultEntity = ResultEntity.createBySuccessDataAndMessage(blogEntityMapper.insert(blogEntity),"保存成功！");
        return resultEntity;
    }

    @Override
    public ResultEntity selectOneBlog(String blogId) {
        ResultEntity resultEntity = ResultEntity.createBySuccessData(blogEntityMapper.selectByPrimaryKey(blogId));
        return resultEntity;
    }

    @Override
    public ResultEntity selectAllBlog() {
        ResultEntity resultEntity = ResultEntity.createBySuccessData(blogEntityMapper.selectAllBlog());
        return resultEntity;
    }

    @Override
    public ResultEntity updateBlog(BlogEntity blogEntity) {
        blogEntity.setUpdateTime(new Date());
        ResultEntity resultEntity = ResultEntity.createBySuccessData(blogEntityMapper.updateByPrimaryKeySelective(blogEntity));
        return resultEntity;
    }
}
