package org.example.yingxin.cn.homyit.service;

import org.example.yingxin.cn.homyit.pojo.Guanliyuan;
import org.example.yingxin.cn.homyit.pojo.Result;
import org.springframework.transaction.annotation.Transactional;


public interface GuanliyuanService {

    Guanliyuan Login(String name, String password);

    Result Logout(String jwt);
}
