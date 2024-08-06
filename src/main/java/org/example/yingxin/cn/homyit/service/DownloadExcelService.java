package org.example.yingxin.cn.homyit.service;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.example.yingxin.cn.homyit.pojo.Xinsheng;

import java.util.List;

public interface DownloadExcelService {


    HSSFWorkbook download(List<Xinsheng> list);

}
