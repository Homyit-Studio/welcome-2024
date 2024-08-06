package org.example.yingxin.cn.homyit.service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {
    void upload(MultipartFile file, String fileName, String path) throws IOException;
}
