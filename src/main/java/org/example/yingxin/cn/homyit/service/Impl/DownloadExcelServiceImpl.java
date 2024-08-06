package org.example.yingxin.cn.homyit.service.Impl;

import org.apache.poi.hssf.usermodel.*;
import org.example.yingxin.cn.homyit.pojo.Xinsheng;
import org.example.yingxin.cn.homyit.service.DownloadExcelService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
@Service
public class DownloadExcelServiceImpl implements DownloadExcelService {


    @Override
    public HSSFWorkbook download(List<Xinsheng> list) {
        String[] excelHeader = {"id", "姓名", "学号", "方向", "班级", "邮箱", "介绍"};
        HSSFWorkbook wb = new HSSFWorkbook();
        //创建HSSFSheet对象
        HSSFSheet sheet = wb.createSheet("报名信息表");
        HSSFRow row = sheet.createRow((int) 0);
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

        for (int i = 0; i < excelHeader.length; i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(excelHeader[i]);
            cell.setCellStyle(style);
            sheet.autoSizeColumn(i);
            //设置指定列的列宽，256 * 50这种写法是因为width参数单位是单个字符的256分之一
            sheet.setColumnWidth(cell.getColumnIndex(), 100 * 50);
        }

        for (int i = 0; i < list.size(); i++) {
            row = sheet.createRow(i + 1);
            Xinsheng xinsheng = list.get(i);
            row.createCell(0).setCellValue(xinsheng.getId());
            row.createCell(1).setCellValue(xinsheng.getName());
            row.createCell(2).setCellValue(xinsheng.getXuehao());
            row.createCell(3).setCellValue(xinsheng.getFangxiang());
            row.createCell(4).setCellValue(xinsheng.getBanji());
            row.createCell(5).setCellValue(xinsheng.getYouxiang());
            row.createCell(6).setCellValue(xinsheng.getJieshao());

        }
        return wb;
    }




}
