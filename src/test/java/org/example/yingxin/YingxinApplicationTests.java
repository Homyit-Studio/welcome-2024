package org.example.yingxin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeUtility;
import java.io.UnsupportedEncodingException;

@SpringBootTest
class YingxinApplicationTests {
    @Autowired
    private JavaMailSender mailSender;

    @Test
    void contextLoads() throws UnsupportedEncodingException, AddressException {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("13363768351@163.com");
        message.setFrom(new InternetAddress(MimeUtility.encodeText("宏奕工作室")+"<homyit_123@qq.com>").toString());
        message.setSubject("宏奕招新");
        message.setText("lzh"+"同学，你好，恭喜你成功报名宏奕工作室。我们很高兴有你的加入，并期待你在未来的活动中展现出色的表现。希望你在宏奕工作室的学习与成长过程中，能够充分发挥自己的才能和潜力。再次祝贺你成为宏奕工作室的一员，让我们一起努力，共创美好未来！");
        mailSender.send(message);
    }

}
