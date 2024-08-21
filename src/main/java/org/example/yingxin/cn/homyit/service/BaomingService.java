package org.example.yingxin.cn.homyit.service;

import org.example.yingxin.cn.homyit.pojo.Result;
import org.example.yingxin.cn.homyit.pojo.Xinsheng;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.internet.AddressException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.CompletableFuture;

public interface BaomingService {
  Integer sendEmail(String youxiang, String name) throws UnsupportedEncodingException, AddressException;

    Integer addxinsheng(Xinsheng xinsheng);


  Xinsheng selectxuehao(Xinsheng xinsheng);
}
