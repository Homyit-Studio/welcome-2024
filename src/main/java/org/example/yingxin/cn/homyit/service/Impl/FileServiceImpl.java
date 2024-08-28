package org.example.yingxin.cn.homyit.service.Impl;

import org.example.yingxin.cn.homyit.Until.FileUtils;
import org.example.yingxin.cn.homyit.config.UploadConfig;
import org.example.yingxin.cn.homyit.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileServiceImpl implements FileService {


        @Override
        public void upload(MultipartFile file, String fileName, String path) throws IOException {
            System.out.println("UploadConfig.path + path:"+ UploadConfig.path + path);
            //创建目录
            FileUtils.mkdir(UploadConfig.path + path);

            String newPath = UploadConfig.path + path + fileName;

            FileUtils.write(newPath, file.getInputStream());

        }
        @Override
        public void deleteFile(String savePath, String fileName) {
            String filePath = savePath + fileName;
            System.out.println(filePath);
            File file = new File(filePath);
            if (file.exists()) {
                if (file.delete()) {
                    System.out.println("文件删除成功：" + fileName);
                } else {
                    System.out.println("无法删除文件：" + fileName);
                }
            } else {
                System.out.println("文件不存在：" + fileName);
            }
        }
    }

