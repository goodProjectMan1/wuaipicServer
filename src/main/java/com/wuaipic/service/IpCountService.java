package com.wuaipic.service;

import com.wuaipic.result.ResultEntity;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: wuaipic
 * @Auther: HGG
 * @Date: 2019-04-14 23:56
 * @Description:
 */
public interface IpCountService {
    ResultEntity accessIpCount(HttpServletRequest request);
}
