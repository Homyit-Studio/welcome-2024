package org.example.yingxin.cn.homyit.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.yingxin.cn.homyit.pojo.Ditu;
import org.springframework.stereotype.Service;

import java.util.List;
@Mapper
public interface dituMapper {
    @Select("SELECT *from tb_ditu")
    List<Ditu> dituList();
}
