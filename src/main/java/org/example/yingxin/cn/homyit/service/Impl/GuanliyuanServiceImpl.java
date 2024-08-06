package org.example.yingxin.cn.homyit.service.Impl;

import org.example.yingxin.cn.homyit.mapper.guanliyuanDao;
import org.example.yingxin.cn.homyit.pojo.Guanliyuan;

import org.example.yingxin.cn.homyit.service.GuanliyuanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuanliyuanServiceImpl implements GuanliyuanService {
    @Autowired
    private guanliyuanDao guanliyuandao;
    @Override
    public Guanliyuan Login(String name, String password){
        Guanliyuan guanliyuan = guanliyuandao.getGuanliyuan(name,password);
        return guanliyuan;
    }

}
