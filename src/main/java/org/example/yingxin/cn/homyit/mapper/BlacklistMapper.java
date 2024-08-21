package org.example.yingxin.cn.homyit.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.yingxin.cn.homyit.pojo.Jwt;
@Mapper
public interface BlacklistMapper {
    @Insert("insert into tb_blacklist (jwt) values (#{jwt})")
    Integer insertblacklist(String jwt);
    @Select("select * from tb_blacklist where jwt=#{jwt}  ")
    Jwt selectblacklist(String jwt);
}
