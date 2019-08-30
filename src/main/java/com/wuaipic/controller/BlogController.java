package com.wuaipic.controller;

import com.wuaipic.model.BlogEntity;
import com.wuaipic.result.ResultEntity;
import com.wuaipic.service.BlogService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@RestController
public class BlogController {

    @Autowired
    private BlogService blogService;
    @RequestMapping(value = "insertBlog",method = RequestMethod.POST,headers = "Accept=application/json")
    public ResultEntity insertBlog(@RequestBody BlogEntity blogEntity){
        return blogService.insertBlog(blogEntity);
    }

    @RequestMapping(value = "selectOneBlog",method = RequestMethod.GET,headers = "Accept=application/json")
    public ResultEntity selectOneBlog(@RequestBody String blogId){
        return blogService.selectOneBlog(blogId);
    }

    @CrossOrigin
    @RequestMapping(value = "selectAllBlog",method = RequestMethod.GET,headers = "Accept=application/json")
    public ResultEntity selectAllBlog(){
        return blogService.selectAllBlog();
    }

    @RequestMapping(value = "updateBlog",method = RequestMethod.POST,headers = "Accept=application/json")
    public ResultEntity updateBlog(@RequestBody BlogEntity blogEntity){
        return blogService.updateBlog(blogEntity);
    }
}

