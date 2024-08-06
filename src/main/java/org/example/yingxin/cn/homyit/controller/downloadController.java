package org.example.yingxin.cn.homyit.controller;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.example.yingxin.cn.homyit.mapper.XinshengMapper;
import org.example.yingxin.cn.homyit.pojo.Xinsheng;
import org.example.yingxin.cn.homyit.service.DownloadExcelService;
import org.example.yingxin.cn.homyit.service.XinshengService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

@Controller
public class downloadController {
    @Autowired
    private XinshengMapper xinshengMapper;
    @Autowired
    private DownloadExcelService downloadExcelService;
    @GetMapping("/guanliyuan/download")
    public void downloadExcel(HttpServletResponse response) throws IOException {
        //从数据库中获取表数据
        List<Xinsheng> list = xinshengMapper.selectall();
        //下载
        HSSFWorkbook wb = downloadExcelService.download(list);
        OutputStream output = response.getOutputStream();
// 文件名中文形式
        String fileName = "报名信息"+".xls";//
        try {
            fileName = URLEncoder.encode(fileName, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setHeader("Content-disposition", "attachment;filename="+fileName+";"+"filename*=utf-8''"+fileName);

        wb.write(output);
        output.close();

    }
}
