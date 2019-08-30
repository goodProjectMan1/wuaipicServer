package com.wuaipic.mapper;

import com.wuaipic.model.PictureEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface PictureEntityMapper {
    int deleteByPrimaryKey(String picId);

    int insert(PictureEntity record);

    int insertSelective(PictureEntity record);

    PictureEntity selectByPrimaryKey(String picId);

    int updateByPrimaryKeySelective(PictureEntity record);

    int updateByPrimaryKey(PictureEntity record);
}