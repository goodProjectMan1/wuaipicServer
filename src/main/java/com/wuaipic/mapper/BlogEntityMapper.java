package com.wuaipic.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wuaipic.model.BlogEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BlogEntityMapper {
    int deleteByPrimaryKey(String blogId);

    int insert(BlogEntity record);

    int insertSelective(BlogEntity record);

    BlogEntity selectByPrimaryKey(String blogId);

    int updateByPrimaryKeySelective(BlogEntity record);

    int updateByPrimaryKeyWithBLOBs(BlogEntity record);

    int updateByPrimaryKey(BlogEntity record);

    List<BlogEntity> selectAllBlog();

    IPage<BlogEntity> selectAllBlogPage(Page page);
}