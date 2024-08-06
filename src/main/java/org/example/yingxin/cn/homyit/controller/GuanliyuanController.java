package org.example.yingxin.cn.homyit.controller;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.example.yingxin.cn.homyit.Until.JwtUntil;
import org.example.yingxin.cn.homyit.enums.CodeEnum;
import org.example.yingxin.cn.homyit.pojo.Guanliyuan;
import org.example.yingxin.cn.homyit.pojo.Result;

import org.example.yingxin.cn.homyit.pojo.Xinsheng;
import org.example.yingxin.cn.homyit.service.GuanliyuanService;
import org.example.yingxin.cn.homyit.service.XinshengService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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
                System.out.println("guanliyuan = " + guanliyuan);
                return Result.error(LOGIN_ERR);
            }
        }
        return Result.error(LOGIN_USEorNAME_NULL);
    }

    @Autowired
    private XinshengService xinshengService;

    @GetMapping("/selectall/{page}")
    @ResponseBody
    public List<Xinsheng> selecrall(@PathVariable Integer page, @RequestBody Xinsheng xinsheng) {
        Integer pagesize = 10;
        List<Xinsheng> selectall = xinshengService.select(xinsheng, page, pagesize);
        return selectall;
    }

    @PostMapping("/delect")
    @ResponseBody
    public Result delect(@RequestBody Xinsheng xinsheng) {
        xinshengService.delect(xinsheng);
        return Result.success(CodeEnum.DELECT_SUCCESS);
    }

    @GetMapping("/insert")
    @ResponseBody
    public Result updata(@RequestBody Xinsheng xinsheng) {
        xinshengService.insert(xinsheng);
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
        return Result.success(CodeEnum.INSERT_SUCCESS);
    }

    @PostMapping("/update")
    @ResponseBody
    public Result update(@RequestBody Xinsheng xinsheng) {
        xinshengService.update(xinsheng);
        return Result.success(CodeEnum.UPDATE_SUCCESS);
    }

}
