package org.example.yingxin.cn.homyit.mapper;


import org.example.yingxin.cn.homyit.pojo.Guanliyuan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface guanliyuanDao {
    @Select("SELECT *from tb_guanliyuan where name=#{name} and password=#{password}")
    Guanliyuan getGuanliyuan(@Param("name") String name, @Param("password") String password);

}
