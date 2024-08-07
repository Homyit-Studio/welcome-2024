package org.example.yingxin.cn.homyit.mapper;


import org.apache.ibatis.annotations.*;
import org.example.yingxin.cn.homyit.pojo.Xinsheng;

import java.util.List;

@Mapper
public interface XinshengMapper {


    List<Xinsheng> select(@Param("id") Integer id, @Param("name")String name, @Param("xuehao")String xuehao, @Param("banji")String banji,
                          @Param("fangxiang") String fangxiang, @Param("page") Integer page, @Param("pagesize") Integer pagesize);
    @Select("SELECT *from tb_xinsheng")
    List<Xinsheng> selectall();



    @Delete("DELETE from tb_xinsheng where  id=#{id}")
    Integer delete( @Param("id") Integer id);


    @Insert("INSERT into tb_xinsheng  (id,name,xuehao,banji,youxiang,fangxiang,jieshao) value (#{id},#{name} ,#{xuehao},#{banji},#{youxiang},#{fangxiang},#{jieshao})")
    Integer insert(@Param("id") Integer id, @Param("name") String name, @Param("xuehao") String xuehao, @Param("banji") String banji,
                @Param("youxiang") String youxiang, @Param("fangxiang") String fangixang  ,@Param("jieshao") String jieshao);


//    @Update("update tb_xinsheng set id=#{nid} where id=#{oid} and name=#{oname} ")
//    void updateid(@Param("nid") Integer nid, @Param("oid") Integer oid, @Param("oname") String oname);
//    @Update("update tb_xinsheng set name=#{nname} where id=#{oid} and name=#{oname} ")
//    void updateName(@Param("nname") String nname, @Param("oid") Integer oid,@Param("oname") String oname);
//    @Update("update tb_xinsheng set  xuehao=#{nxuehao} where id=#{oid} and name=#{oname} ")
//    void updatexuehao(@Param("nxuehao") String nxuehao, @Param("oid") Integer oid,@Param("oname") String oname);
//    @Update("update tb_xinsheng set  banji=#{nbanji} where  id=#{oid} and name=#{oname}")
//    void   updatebanji(@Param("nbanji") String nbanji, @Param("oid") Integer oid,@Param("oname") String oname);
//    @Update("update tb_xinsheng set youxiang=#{nyouxiang} where id=#{oid} and name=#{oname} ")
//    void updateyouxiang(@Param("nyouxiang") String nyouxiang, @Param("oid") Integer oid,@Param("oname") String oname);
//    @Update("update tb_xinsheng set fangxiang=#{nfangxiang} where id=#{oid} and name=#{oname} ")
//    void updatefangxiang(@Param("nfangxiang") String nfangxiang, @Param("oid") Integer oid,@Param("oname") String oname);

    @Update("update tb_xinsheng set name=#{nname},xuehao=#{nxuehao},banji=#{nbanji} , youxiang=#{nyouxiang} ,fangxiang=#{nfangxiang} " +
            "where id=#{id} ")
   Integer update(@Param("nname") String nnname,@Param("nxuehao") String nxuehao,@Param("nbanji") String nbanji,
                @Param("nyouxiang") String nyouxiang,@Param("nfangxiang") String nfangxiang,@Param("id") Integer id);

}
