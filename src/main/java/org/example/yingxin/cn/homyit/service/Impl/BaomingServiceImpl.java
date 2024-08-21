package org.example.yingxin.cn.homyit.service.Impl;

import org.example.yingxin.cn.homyit.mapper.XinshengMapper;
import org.example.yingxin.cn.homyit.pojo.Xinsheng;
import org.example.yingxin.cn.homyit.service.BaomingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeUtility;
import java.io.UnsupportedEncodingException;

@Service
public class BaomingServiceImpl implements BaomingService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private XinshengMapper xinshengMapper;

        @Async
        @Override
        public Integer sendEmail(String youxiang, String name) throws AddressException, UnsupportedEncodingException {

            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(youxiang);
            message.setFrom(new InternetAddress(MimeUtility.encodeText("宏奕工作室")+"<homyit_123@qq.com>").toString());
            message.setSubject("宏奕招新");
            message.setText(name+"同学，你好！我非常高兴地通知你，你的报名已经成功，你现在是我们工作室的一名候选成员。这一步虽然是你加入我们这个团队的初步阶段，但它是非常重要的一步，意味着你已经迈出了加入我们共同努力和成长的旅程的第一脚步。\n" +
                    "\n" +
                    "报名成功是一个令人振奋的开始，它展现了你对于加入我们工作室并投身于我们正在进行的各种创新和技术项目的热情和决心。我们工作室致力于提供一个充满挑战和机遇的环境，让每一位成员都能够在技术和创新的道路上不断进步和发展。\n" +
                    "\n" +
                    "在接下来的时间里，我们将进一步了解你的兴趣和培养你的技能，同时，你也将有机会更加深入地了解我们工作室的文化。我们期待着你能够积极地融入我们的团队，与我们一起创造出令人激动的成果。\n" +
                    "\n" +
                    "请准备好开始这段旅程，我们将为你提供所需的支持和指导，帮助你尽快地适应并发挥你的潜力。我们相信，通过我们的共同努力和创新，能够实现更多的可能性，创造出更大的价值。");
            try {
                javaMailSender.send(message);
                return 1;
            } catch (MailSendException e) {
                xinshengMapper.deleteyouxiang(name,youxiang);
                return 0;
            }

        }


        @Override
        public Integer addxinsheng(Xinsheng xinsheng) {

            return xinshengMapper.insert(xinsheng.getId(),xinsheng.getName() ,xinsheng.getXuehao(),xinsheng.getBanji(),
                    xinsheng.getYouxiang(),xinsheng.getFangxiang(),xinsheng.getJieshao());

        }
        @Override
        public Xinsheng selectxuehao(Xinsheng xinsheng){
           return xinshengMapper.selectxuehao(xinsheng.getXuehao());
        }

}



