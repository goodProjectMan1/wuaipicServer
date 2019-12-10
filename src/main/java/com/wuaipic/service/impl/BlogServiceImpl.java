package com.wuaipic.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wuaipic.mapper.BlogEntityMapper;
import com.wuaipic.model.BlogEntity;
import com.wuaipic.service.BlogService;
import com.wuaipic.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogEntityMapper blogEntityMapper;
    @Override
    public int insertBlog(BlogEntity blogEntity) {
        blogEntity.setBlogId(UUIDUtil.getOneUUID());
        blogEntity.setCreateTime(new Date());
        blogEntity.setBlogStatus("1");
        int res = blogEntityMapper.insert(blogEntity);
        return res;
    }

    @Override
    public BlogEntity selectOneBlog(String blogId) {
        BlogEntity blogEntity = blogEntityMapper.selectByPrimaryKey(blogId);
        return blogEntity;
    }

    @Override
    public List<BlogEntity> selectAllBlog() {
        List<BlogEntity> list = blogEntityMapper.selectAllBlog();
        return list;
    }

    @Override
    public Map<String,Object> selectAllBlogPage(Page page) {
        IPage<BlogEntity> resPage = blogEntityMapper.selectAllBlogPage(page);
        Map map = new HashMap();
        map.put("data",resPage.getRecords());
        map.put("total",resPage.getTotal());
        return map;
    }

    @Override
    public int updateBlog(BlogEntity blogEntity) {
        blogEntity.setUpdateTime(new Date());
        int res = blogEntityMapper.updateByPrimaryKeySelective(blogEntity);
        return res;
    }
}
