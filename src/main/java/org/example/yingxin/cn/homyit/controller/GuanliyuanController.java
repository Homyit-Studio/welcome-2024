package org.example.yingxin.cn.homyit.controller;

import org.example.yingxin.cn.homyit.Until.JwtUntil;
import org.example.yingxin.cn.homyit.enums.CodeEnum;
import org.example.yingxin.cn.homyit.pojo.Guanliyuan;
import org.example.yingxin.cn.homyit.pojo.Result;

import org.example.yingxin.cn.homyit.pojo.Select;
import org.example.yingxin.cn.homyit.pojo.Xinsheng;
import org.example.yingxin.cn.homyit.service.GuanliyuanService;
import org.example.yingxin.cn.homyit.service.XinshengService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.example.yingxin.cn.homyit.enums.CodeEnum.*;

@Controller
@RequestMapping("/guanliyuan")
public class GuanliyuanController {
    @Autowired
    private GuanliyuanService guanliyuanservice;


    @PostMapping("/login")
    @ResponseBody
    public Result Login(@RequestBody Guanliyuan guanliyuan) throws IOException, ServletException {
        if (guanliyuan != null && guanliyuan.getName() != null && guanliyuan.getPassword() != null) {
            if (guanliyuanservice.Login(guanliyuan.getName(), guanliyuan.getPassword()) != null) {
                Map<String, Object> claims = new HashMap<>();
                claims.put("id", guanliyuanservice.Login(guanliyuan.getName(), guanliyuan.getPassword()).getId());
                claims.put("name", guanliyuanservice.Login(guanliyuan.getName(), guanliyuan.getPassword()).getName());
                claims.put("password", guanliyuanservice.Login(guanliyuan.getName(), guanliyuan.getPassword()).getPassword());
                String jwt = JwtUntil.generateJwt(claims);
                return Result.success(jwt);
            } else {

                return Result.error(LOGIN_ERR);
            }
        }
        return Result.error(LOGIN_USEorNAME_NULL);
    }
    @PostMapping("/logout")
    @ResponseBody
    public Result Logout(HttpServletRequest request) throws IOException, ServletException {
        String jwt = request.getHeader("token");
        Result logout= guanliyuanservice.Logout(jwt);
        return logout;

    }
    @Autowired
    private XinshengService xinshengService;

    @PostMapping("/selectall")
    @ResponseBody
    public Result selecrall( @RequestBody Select select) {
        Integer pagesize = 10;
        Integer page = (select.getPage()-1)*10;
        if(select.getPage()==0){
            List<Xinsheng> selectall = xinshengService.selectall();
            return Result.success(SELECT_SUCCESS, selectall);
        }else{
        Xinsheng xinsheng = new Xinsheng(select.getId(),select.getName(),select.getXuehao(),select.getBanji(),null,select.getFangxiang(),null);
        List<Xinsheng> selects = xinshengService.select(xinsheng, page, pagesize);
        return Result.success(SELECT_SUCCESS, selects);
        }
    }

    @PostMapping("/delect")
    @ResponseBody
    public Result delect(@RequestBody Xinsheng xinsheng) {
        if(xinshengService.delect(xinsheng)!=0) {
            return Result.success(CodeEnum.DELECT_SUCCESS);
        }else {
            return Result.error(CodeEnum.DELECT_ERROR);
        }
    }

    @PostMapping("/insert")
    @ResponseBody
    public Result insert(@RequestBody Xinsheng xinsheng) {

        if (xinsheng.getName() == null || xinsheng.getName().equals("")) {
            return Result.error(CodeEnum.INSERT_NAME_NULL);
        }
        if (xinsheng.getXuehao() == null || xinsheng.getXuehao().equals("")) {
            return Result.error(CodeEnum.INSERT_XUEHAO_NULL);
        }
        if (xinsheng.getBanji() == null || xinsheng.getBanji().equals("")) {
            return Result.error(CodeEnum.INSERT_BANJI_NULL);
        }
        if (xinsheng.getFangxiang() == null || xinsheng.getFangxiang().equals("")) {
            return Result.error(CodeEnum.INSERT_FANGXIANG_NULL);
        }
        if (xinsheng.getYouxiang() == null || xinsheng.getYouxiang().equals("")) {
            return Result.error(CodeEnum.INSERT_YOUXIAN_NULL);
        }
        if(xinshengService.insert(xinsheng)!=0) {
            return Result.success(CodeEnum.INSERT_SUCCESS);
        }else {
            return Result.error(CodeEnum.INSERT_ERROR);
        }
    }

    @PostMapping("/update")
    @ResponseBody
    public Result update(@RequestBody Xinsheng xinsheng) {
        if(xinshengService.update(xinsheng)!=0){
        return Result.success(CodeEnum.UPDATE_SUCCESS);
        }
        else {
            return Result.error(CodeEnum.UPDATE_ERROR);
        }
    }


}
