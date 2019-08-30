package com.wuaipic.service.impl;

import com.wuaipic.mapper.IpCountEntityMapper;
import com.wuaipic.model.IpCountEntity;
import com.wuaipic.result.ResultEntity;
import com.wuaipic.service.IpCountService;
import com.wuaipic.utils.IPUtils;
import com.wuaipic.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @program: wuaipic
 * @Auther: HGG
 * @Date: 2019-04-14 23:58
 * @Description:
 */
@Service
public class IpCountServiceImpl implements IpCountService {
    @Autowired
    private IpCountEntityMapper ipCountEntityMapper;

    public ResultEntity accessIpCount(HttpServletRequest request) {
        IpCountEntity ipCountEntry = new IpCountEntity();
        String str = IPUtils.getClientIp(request);
        ipCountEntry.setIpId(UUIDUtil.getOneUUID());
        ipCountEntry.setAccessIp(str);
        ipCountEntry.setCreateTime(new Date());
        int i = 0;
        i = ipCountEntityMapper.insert(ipCountEntry);
        if(i==1){
            int a = ipCountEntityMapper.countAccess();
            return ResultEntity.createBySuccessDataAndMessage(1,String.valueOf(a));
        }

        return ResultEntity.createByErrorMessage("失败");
    }

}



