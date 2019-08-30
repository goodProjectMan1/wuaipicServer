package com.wuaipic.controller;

import com.wuaipic.model.PictureEntity;
import com.wuaipic.result.ResultEntity;
import com.wuaipic.service.PictureService;
import com.wuaipic.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class PictureController {

    @Autowired
    private PictureService pictureService;
        @CrossOrigin
        @RequestMapping(value = "insertPicture",method = RequestMethod.POST,headers = "Accept=application/json")
        public ResultEntity insertPicture(@RequestBody PictureEntity pictureEntity){
            ResultEntity resultEntity =ResultEntity.createBySuccessData(pictureService.insertPicture(pictureEntity));
            return resultEntity;

    }

}
