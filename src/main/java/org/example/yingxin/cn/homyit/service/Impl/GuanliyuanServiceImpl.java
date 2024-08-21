package org.example.yingxin.cn.homyit.service.Impl;

import org.example.yingxin.cn.homyit.enums.CodeEnum;
import org.example.yingxin.cn.homyit.mapper.BlacklistMapper;
import org.example.yingxin.cn.homyit.mapper.guanliyuanDao;
import org.example.yingxin.cn.homyit.pojo.Guanliyuan;

import org.example.yingxin.cn.homyit.pojo.Result;
import org.example.yingxin.cn.homyit.service.GuanliyuanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuanliyuanServiceImpl implements GuanliyuanService {
    @Autowired
    private guanliyuanDao guanliyuandao;
    @Autowired
    private BlacklistMapper blacklistMapper;
    @Override
    public Guanliyuan Login(String name, String password){
        Guanliyuan guanliyuan = guanliyuandao.getGuanliyuan(name,password);
        return guanliyuan;
    }
    @Override
    public Result Logout(String jwt){
        blacklistMapper.insertblacklist(jwt);
        return Result.success(CodeEnum.LOGOUT,"");
    }
}
