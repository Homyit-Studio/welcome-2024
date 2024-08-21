package org.example.yingxin.cn.homyit.controller;

import org.example.yingxin.cn.homyit.Until.FileUtils;
import org.example.yingxin.cn.homyit.config.UploadConfig;
import org.example.yingxin.cn.homyit.enums.CodeEnum;
import org.example.yingxin.cn.homyit.mapper.ImagesMapper;
import org.example.yingxin.cn.homyit.pojo.Image;
import org.example.yingxin.cn.homyit.pojo.Result;
import org.example.yingxin.cn.homyit.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/guanliyuan")
public class FileController {

    private static final List<String> images = Arrays.asList("jpg", "png", "svn", "webp");
    private static final List<String> videos = Arrays.asList("mp4", "webm", "ogg");

    @Autowired
    private FileService fileService;
    @Autowired
    private ImagesMapper imagesMapper;

    @PostMapping("/upload")
    @ResponseBody
    public Result upload(@RequestParam("file") MultipartFile file) throws IOException, InterruptedException {

        String imageName = file.getOriginalFilename();
        String fileExt = FileUtils.getExtName(Objects.requireNonNull(imageName));

        String module = "";

        String fileName = System.currentTimeMillis() + "." + fileExt;

        if (images.contains(fileExt)) {
            module = "image";
        } else if (videos.contains(fileExt)) {
            module = "video";
        }
        String savePath = MessageFormat.format("{0}/{1}/",  module, new SimpleDateFormat("yyyy/MM/dd").format(new Date()));
        fileService.upload(file, fileName, savePath);
        String filePath = savePath + fileName;
        String url = UploadConfig.reUrl + "images/"+filePath;
        System.out.println("返回地址:" + url);
        //一次性上传多张的时候最好加上这个
        //Thread.sleep(500);
        imagesMapper.insertimage(imageName, url);
        return Result.success(CodeEnum.UPLOAD_SUCCESS,url);
    }
    @PostMapping("/delectimages")
    @ResponseBody
    public Result delectimages(@RequestBody Image image) throws IOException, InterruptedException {
        Integer deleteimage = imagesMapper.deleteimage(image.getId());
        if (deleteimage > 0) {
             return Result.success(CodeEnum.DELECTIMAGES_SUSSESS);
        }else {
            return Result.error(CodeEnum.DELECTIMAGES_ERROR);
        }

    }
}