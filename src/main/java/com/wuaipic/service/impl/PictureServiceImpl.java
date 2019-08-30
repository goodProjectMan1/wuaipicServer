package com.wuaipic.service.impl;

import com.wuaipic.mapper.PictureEntityMapper;
import com.wuaipic.model.PictureEntity;
import com.wuaipic.result.ResultEntity;
import com.wuaipic.service.PictureService;
import com.wuaipic.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PictureServiceImpl implements PictureService {
    @Autowired
    private PictureEntityMapper pictureEntityMapper;
    @Override
    public ResultEntity insertPicture(PictureEntity pictureEntity) {
        pictureEntity.setCreateTime(new Date());
        pictureEntity.setPicId(UUIDUtil.getOneUUID());
        pictureEntity.setPicStatus("1");
        int i = pictureEntityMapper.insert(pictureEntity);
        ResultEntity resultEntity = ResultEntity.createBySuccessDataAndMessage(i,"上传成功！");
        return resultEntity;
    }
}
