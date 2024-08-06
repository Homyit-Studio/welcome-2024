package org.example.yingxin.cn.homyit.controller;

import org.example.yingxin.cn.homyit.enums.CodeEnum;
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

        baomingService.sendEmailAsync(xinsheng.getYouxiang(),xinsheng.getName());
        baomingService.addXinshengAsync(xinsheng);
        return Result.success(CodeEnum.BAOMING_SUCCESSS);
    }
}
