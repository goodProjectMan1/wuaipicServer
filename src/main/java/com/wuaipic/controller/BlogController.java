package com.wuaipic.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wuaipic.model.BlogEntity;
import com.wuaipic.result.ResultEntity;
import com.wuaipic.service.BlogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 博客接口类
 */
@Api(value = "博客相关接口类", tags = "博客", description = "博客增删改查")
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "请求已完成"),
        @ApiResponse(code = 201, message = "资源成功被创建"),
        @ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
        @ApiResponse(code = 401, message = "未授权客户机访问数据"),
        @ApiResponse(code = 403, message = "服务器接受请求，但是拒绝处理"),
        @ApiResponse(code = 404, message = "服务器找不到给定的资源；文档不存在"),
        @ApiResponse(code = 500, message = "服务器出现异常")}
)

@RestController
public class BlogController {
    private static final Logger _logger = LoggerFactory.getLogger(BlogController.class);
    @Autowired
    private BlogService blogService;

    @ApiOperation(value = "添加博客接口接口", notes = "接收前端的博客信息并进行保存", produces = "application/json")
    @RequestMapping(value = "insertBlog",method = RequestMethod.POST,headers = "Accept=application/json")
    public ResultEntity insertBlog(@RequestBody BlogEntity blogEntity){
        _logger.info("添加博客接口接口");
        return ResultEntity.createBySuccessDataAndMessage(blogService.insertBlog(blogEntity),"成功的插入了");
    }

    @ApiOperation(value = "查询博客详情接口", notes = "根据博客的主键进行博客的查询", produces = "application/json")
    @CrossOrigin
    @RequestMapping(value = "selectOneBlog",method = RequestMethod.GET,headers = "Accept=application/json")
    public ResultEntity selectOneBlog(@RequestParam(value = "blogId") String blogId){
        _logger.info("查询博客详情接口接口");
        return ResultEntity.createBySuccessData(blogService.selectOneBlog(blogId));
    }

    @ApiOperation(value = "查询博客列表接口", notes = "查询博客列表", produces = "application/json")
    @CrossOrigin
    @RequestMapping(value = "selectAllBlog",method = RequestMethod.GET,headers = "Accept=application/json")
    public ResultEntity selectAllBlog(){
        _logger.info("查询博客列表接口接口");
        return ResultEntity.createBySuccessData(blogService.selectAllBlog());
    }

    @ApiOperation(value = "查询博客列表接口带分页", notes = "查询博客列表带分页", produces = "application/json")
    @CrossOrigin
    @RequestMapping(value = "selectAllBlogPage",method = RequestMethod.GET,headers = "Accept=application/json")
    public ResultEntity selectAllBlogPage(@RequestParam("current") Long current,@RequestParam("size") Long size){
        _logger.info("查询博客列表接口接口");
        Page page = new Page();
        page.setCurrent(current);
        page.setSize(size);
        return ResultEntity.createBySuccessData(blogService.selectAllBlogPage(page));
    }



    @ApiOperation(value = "修改博客详情接口接口", notes = "根据博客的主键进行博客的修改", produces = "application/json")
    @RequestMapping(value = "updateBlog",method = RequestMethod.POST,headers = "Accept=application/json")
    public ResultEntity updateBlog(@RequestBody BlogEntity blogEntity){
        _logger.info("修改博客详情接口接口");
        return ResultEntity.createBySuccessData(blogService.updateBlog(blogEntity));
    }
}

