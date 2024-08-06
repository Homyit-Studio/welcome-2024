package org.example.yingxin.cn.homyit.service.Impl;

import org.example.yingxin.cn.homyit.mapper.XinshengMapper;
import org.example.yingxin.cn.homyit.pojo.Xinsheng;
import org.example.yingxin.cn.homyit.service.BaomingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeUtility;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.CompletableFuture;

@Service
public class BaomingServiceImpl implements BaomingService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private XinshengMapper xinshengMapper;
    @Override
    public void sendEmail(String youxiang, String name) throws AddressException, UnsupportedEncodingException {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(youxiang);
        message.setFrom(new InternetAddress(MimeUtility.encodeText("宏奕工作室")+"<homyit_123@qq.com>").toString());
        message.setSubject("宏奕招新");
        message.setText(name+"同学，你好，恭喜你成功报名宏奕工作室。我们很高兴有你的加入，并期待你在未来的活动中展现出色的表现。希望你在宏奕工作室的学习与成长过程中，能够充分发挥自己的才能和潜力。再次祝贺你成为宏奕工作室的一员，让我们一起努力，共创美好未来！");
        javaMailSender.send(message);
    }
    @Override
    public void addxinsheng(Xinsheng xinsheng) {
        xinshengMapper.insert(xinsheng.getId(),xinsheng.getName() ,xinsheng.getXuehao(),xinsheng.getBanji(),
                xinsheng.getYouxiang(),xinsheng.getFangxiang(),xinsheng.getJieshao());
    }
    @Override
    public CompletableFuture<Void> sendEmailAsync(String youxiang, String name) {
        return CompletableFuture.runAsync(() -> {
            try {
                sendEmail(youxiang, name);
            } catch (AddressException | UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public CompletableFuture<Void> addXinshengAsync(Xinsheng xinsheng) {
        return CompletableFuture.runAsync(() -> {
            addxinsheng(xinsheng);
        });
}


}
