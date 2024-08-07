package org.example.yingxin.cn.homyit.service.Impl;

import com.github.pagehelper.autoconfigure.PageHelperAutoConfiguration;
import org.example.yingxin.cn.homyit.mapper.XinshengMapper;
import org.example.yingxin.cn.homyit.pojo.Xinsheng;
import org.example.yingxin.cn.homyit.service.XinshengService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class XinshengServiceImpl implements XinshengService {
    @Autowired
    private XinshengMapper xingxinshengMapper;
    @Autowired
    private PageHelperAutoConfiguration pageHelperAutoConfiguration;

    @Override
    public List<Xinsheng>select(Xinsheng xinsheng, Integer page, Integer pagesize){

        String name=xinsheng.getName();
        Integer id = xinsheng.getId();
        String banji = xinsheng.getBanji();
        String xuehao = xinsheng.getXuehao();
        String fangxiang=xinsheng.getFangxiang();
        return xingxinshengMapper.select(id,name,xuehao,banji,fangxiang,page,pagesize);
    }
    @Override
    public Integer delect(Xinsheng xinsheng){
        return xingxinshengMapper.delete(xinsheng.getId());

    }
    @Override
    public Integer insert(Xinsheng xinsheng){
       return  xingxinshengMapper.insert(xinsheng.getId(),xinsheng.getName() ,xinsheng.getXuehao(),xinsheng.getBanji(),
                xinsheng.getYouxiang(),xinsheng.getFangxiang(),xinsheng.getJieshao());
    }
    @Override
    public Integer update(Xinsheng xinsheng){
      return   xingxinshengMapper.update(xinsheng.getName(),xinsheng.getXuehao(),xinsheng.getBanji(),
                xinsheng.getYouxiang(),xinsheng.getFangxiang(),xinsheng.getId());

    }
}
