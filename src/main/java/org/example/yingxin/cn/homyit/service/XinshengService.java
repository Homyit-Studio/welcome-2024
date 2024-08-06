package org.example.yingxin.cn.homyit.service;

import org.example.yingxin.cn.homyit.pojo.Xinsheng;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface XinshengService {




    List<Xinsheng>select(Xinsheng xinsheng, Integer page, Integer pagesize);

    void delect(Xinsheng xinsheng);

    void insert(Xinsheng xinsheng);

    void update(Xinsheng xinsheng);
}
