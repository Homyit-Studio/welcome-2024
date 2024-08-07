package org.example.yingxin.cn.homyit.controller;

import org.example.yingxin.cn.homyit.enums.CodeEnum;
import org.example.yingxin.cn.homyit.pojo.RegexPatterns;
import org.example.yingxin.cn.homyit.pojo.Result;
import org.example.yingxin.cn.homyit.pojo.Xinsheng;
import org.example.yingxin.cn.homyit.service.BaomingService;
import org.example.yingxin.cn.homyit.service.XinshengService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.mail.internet.AddressException;
import java.io.UnsupportedEncodingException;


@Controller
public class BaomingConteoller {
    @Autowired
    private BaomingService baomingService;
    @Autowired
    private XinshengService xinshengService;
    @PostMapping("/baoming")
    @ResponseBody
    public Result baoming(@RequestBody Xinsheng  xinsheng)throws AddressException, UnsupportedEncodingException {
        if(xinsheng.getName()==null || xinsheng.getName().equals("")){
            return Result.error(CodeEnum.INSERT_NAME_NULL);
        }
        if(xinsheng.getXuehao()==null || xinsheng.getXuehao().equals("")){
            return Result.error(CodeEnum.INSERT_XUEHAO_NULL);
        }
        if(xinsheng.getBanji()==null || xinsheng.getBanji().equals("")){
            return Result.error(CodeEnum.INSERT_BANJI_NULL);
        }
        if(xinsheng.getFangxiang()==null || xinsheng.getFangxiang().equals("")){
            return Result.error(CodeEnum.INSERT_FANGXIANG_NULL);
        }
        if(xinsheng.getYouxiang()==null || xinsheng.getYouxiang().equals("")){
            return Result.error(CodeEnum.INSERT_YOUXIAN_NULL);
        }

        if(xinsheng.getYouxiang()==null||"".equals(xinsheng.getYouxiang())){
            return Result.error(CodeEnum.INSERT_YOUXIAN_NULL);
        }
        if (!xinsheng.getYouxiang().matches(RegexPatterns.EmailRegex)){
            return Result.error(CodeEnum.EMAIL_ERROR);

        }
     if(baomingService.addxinsheng(xinsheng)!=0&&baomingService.sendEmail(xinsheng.getYouxiang(),xinsheng.getName())==1){

            return Result.success(CodeEnum.BAOMING_SUCCESSS);

     }else {
         return Result.error(CodeEnum.BAOMING_ERROR);
     }

    }
}
