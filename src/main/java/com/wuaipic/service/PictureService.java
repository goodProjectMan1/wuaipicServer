package com.wuaipic.service;

import com.wuaipic.model.PictureEntity;
import com.wuaipic.result.ResultEntity;

public interface PictureService {
    ResultEntity  insertPicture(PictureEntity pictureEntity);
}
