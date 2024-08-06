package org.example.yingxin.cn.homyit.config;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
    public class UploadConfig {
        public static String path;

        public static String reUrl;

        @Value("${upload.path}")
        public void setPath(String path) {
            UploadConfig.path = path;
        }

        @Value("${upload.reUrl}")
        public void setReUrl(String reUrl) {
            UploadConfig.reUrl = reUrl;
        }


}
