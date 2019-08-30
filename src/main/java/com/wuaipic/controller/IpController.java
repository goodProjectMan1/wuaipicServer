package com.wuaipic.controller;

import com.wuaipic.result.ResultEntity;
import com.wuaipic.service.IpCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;


/**
 * @program: wuaipic
 * @Auther: HGG
 * @Date: 2019-04-14 23:41
 * @Description:
 */
@RestController
public class IpController {
    @Autowired
    private IpCountService ipCountService;
    @CrossOrigin
    @RequestMapping(value = "access",method = RequestMethod.GET,headers = "Accept=application/json")
    public ResultEntity getAccess(HttpServletRequest request){
        return ipCountService.accessIpCount(request);
    }
}
