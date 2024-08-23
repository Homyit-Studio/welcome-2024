package org.example.yingxin.cn.homyit.service;

import org.example.yingxin.cn.homyit.pojo.Xinsheng;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface XinshengService {




    List<Xinsheng>select(Xinsheng xinsheng, Integer page, Integer pagesize);

  Integer delect(Xinsheng xinsheng);

   Integer insert(Xinsheng xinsheng);

    Integer update(Xinsheng xinsheng);

    List<Xinsheng>selectall();
}
