package com.vzhen.demo.config;

import com.vzhen.demo.service.NewMessagelogsService;
import com.vzhen.demo.util.LogUtil;

import java.util.Arrays;

/**
 * @param
 * @author chenhj
 * @version 1.0.0
 * @CreateTime 2019/1/3
 * @description 为转移数据封装的线程
 * @return
 */
public class IndexSingleThread extends Thread {
    NewMessagelogsService msgService;
    LogUtil log = new LogUtil(getClass());

    public IndexSingleThread(NewMessagelogsService msgService) {
        this.msgService = msgService;
        super.setDaemon(true);
        Thread.currentThread().setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                log.error("uncaughtException被捕获:" + Arrays.toString(e.getStackTrace()));
            }
        });
    }

    @Override
    public void run() {
        log.warn("当前业务线程id:" + Thread.currentThread().getId());
        for(;;){

            try {
                msgService.oneyByOneEs();
                Thread.currentThread().sleep(60000);//5s 一次
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
