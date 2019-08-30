package com.wuaipic.controller;

import com.wuaipic.result.ResultEntity;
import com.wuaipic.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class FileController {
        @CrossOrigin
        @RequestMapping(value = "file",method = RequestMethod.POST,headers = "Accept=application/json")
        public ResultEntity Fileupload(MultipartFile file,HttpServletRequest request){
            Map map = new HashMap();
            Map map1 = FileUtil.FileUpload(file);
            map.put("src","http://localhost:8080/"+map1.get("newName"));
            map.put("title",map1.get("sourceName"));
            ResultEntity resultEntity =ResultEntity.createBySuccessData(map);
            return resultEntity;

    }

}
