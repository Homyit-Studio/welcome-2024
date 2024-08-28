package org.example.yingxin.cn.homyit.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.yingxin.cn.homyit.pojo.Ditu;
import org.springframework.stereotype.Service;

import java.util.List;
@Mapper
public interface dituMapper {
    @Select("SELECT *from tb_ditu")
    List<Ditu> dituList();
    @Update("update  tb_ditu set value=#{value} where name=#{name} ")
    Integer updateDitu(@Param("value") Integer value, @Param("name") String name);
    @Select("select *from tb_ditu where name=#{name}")
    Ditu seletditu(@Param("name") String name);
}
