package com.wuaipic.mapper;

import com.wuaipic.model.IpCountEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
@Mapper
@Repository
public interface IpCountEntityMapper {
    int deleteByPrimaryKey(String ipId);

    int insert(IpCountEntity record);

    int insertSelective(IpCountEntity record);

    IpCountEntity selectByPrimaryKey(String ipId);

    int updateByPrimaryKeySelective(IpCountEntity record);

    int updateByPrimaryKey(IpCountEntity record);

    int countAccess();
}