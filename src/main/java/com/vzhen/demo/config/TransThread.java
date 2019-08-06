package com.vzhen.demo.config;

import com.vzhen.demo.service.MessagelogsService;
import com.vzhen.demo.util.LogUtil;

import java.text.ParseException;
import java.util.Arrays;

/**
 * @param
 * @author chenhj
 * @version 1.0.0
 * @CreateTime 2019/1/3
 * @description 为转移数据封装的线程
 * @return
 */
public class TransThread extends Thread{
    MessagelogsService msgService;
    LogUtil log = new LogUtil(getClass());
    public TransThread(MessagelogsService msgService) {
        this.msgService = msgService;
        super.setDaemon(true);
        Thread.currentThread().setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                log.error("uncaughtException被捕获:"+ Arrays.toString(e.getStackTrace()));
            }
        });
    }

    @Override
    public void run() {
        try {
            log.warn("当前业务线程id:"+Thread.currentThread().getId());
            msgService.genIndex();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
