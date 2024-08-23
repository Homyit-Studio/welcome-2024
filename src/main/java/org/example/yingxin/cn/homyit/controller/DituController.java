package org.example.yingxin.cn.homyit.controller;

import org.example.yingxin.cn.homyit.enums.CodeEnum;
import org.example.yingxin.cn.homyit.mapper.dituMapper;
import org.example.yingxin.cn.homyit.pojo.Ditu;
import org.example.yingxin.cn.homyit.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class    DituController {
    @Autowired
    private dituMapper ditumapper;
    @PostMapping("/data")
    @ResponseBody
    public Result data() {
        return Result.success(CodeEnum.GETDATA_SUCCESS,ditumapper.dituList());
    }
    @PostMapping("/guanliyuan/editmap")
    @ResponseBody
    public Result editmap(@RequestBody Ditu ditu) {
        if(ditu.getName()==null||ditu.getValue()==null){
            return Result.error(CodeEnum.UPDATADITU_NULL);
        }
       if(ditumapper.updateDitu(ditu.getValue(), ditu.getName())==0){
           return Result.error(CodeEnum.UPDATADITU_ERROR);
       }else {
           return Result.success(CodeEnum.UPDATADITU_SUCCESS);
       }
    }
    @GetMapping("/guanliyuan/getmap")
    @ResponseBody
    public Result getmap() {
        return Result.success(CodeEnum.GETDATA_SUCCESS,ditumapper.dituList());
    }
}
