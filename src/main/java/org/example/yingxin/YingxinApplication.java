package org.example.yingxin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
@MapperScan("org.example.yingxin.cn.homyit.mapper")
@ServletComponentScan
@SpringBootApplication
public class YingxinApplication {

    public static void main(String[] args) {

        SpringApplication.run(YingxinApplication.class, args);
    }

}
