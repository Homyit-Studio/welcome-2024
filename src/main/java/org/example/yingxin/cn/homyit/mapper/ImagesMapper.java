package org.example.yingxin.cn.homyit.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.yingxin.cn.homyit.pojo.Image;

import java.util.List;

@Mapper
public interface ImagesMapper {
    @Insert("insert into tb_images (imagename,url) values (#{imagename},#{url})")
    void insertimage(@Param("imagename") String imagename, @Param("url") String url);
//    @Select("SELECT url from tb_images where imagename=#{imagename}")
//    String selectimage(@Param("imagename") String imagename);
    @Select("SELECT * from tb_images")
    List<Image> selectallimages();
}
