package org.example.yingxin.cn.homyit.service.Impl;

import org.example.yingxin.cn.homyit.Until.FileUtils;
import org.example.yingxin.cn.homyit.config.UploadConfig;
import org.example.yingxin.cn.homyit.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
    }

