package com.wuaipic.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class FileUtil {
    public static Map<String,String> FileUpload(MultipartFile file){
//        String path="/usr/local/apache2/htdocs/aimImages/";
        String path="D://hello//";
        Map map = new HashMap();
        String fileName = file.getOriginalFilename();//获取到上传文件的名字
        map.put("sourceName",fileName);
        String suffix = fileName.substring(fileName.lastIndexOf('.'));//获取文件后缀
        String newfileName = UUIDUtil.getOneUUID()+suffix;//随机生成文件名
        map.put("newName",newfileName);
        System.out.println(newfileName);
        File dir = new File(path,newfileName);//在目录中创建文件目录
        if(!dir.getParentFile().exists()){
            dir.getParentFile().mkdirs();//创建文件
        }
        try {
            file.transferTo(dir);//转换文件
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}
