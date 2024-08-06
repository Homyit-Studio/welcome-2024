package org.example.yingxin.cn.homyit.controller;

import org.example.yingxin.cn.homyit.mapper.ImagesMapper;
import org.example.yingxin.cn.homyit.pojo.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class GetImageController {
    @Autowired
    private ImagesMapper imagesMapper;
//    @PostMapping("/")
//    @ResponseBody
//    public String GetImage(@PathVariable String imagename) {
//
//    }
    @GetMapping("/getallimages")
    @ResponseBody
    public List<Image> getAllImages() {
        return imagesMapper.selectallimages();
    }
}
