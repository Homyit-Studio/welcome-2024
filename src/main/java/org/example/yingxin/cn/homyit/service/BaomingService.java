package org.example.yingxin.cn.homyit.service;

import org.example.yingxin.cn.homyit.pojo.Xinsheng;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.internet.AddressException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.CompletableFuture;

public interface BaomingService {
    void sendEmail(String youxiang, String name) throws UnsupportedEncodingException, AddressException;

    void addxinsheng(Xinsheng xinsheng);

    CompletableFuture<Void> sendEmailAsync(String youxiang, String name);

    CompletableFuture<Void> addXinshengAsync(Xinsheng xinsheng);
}
