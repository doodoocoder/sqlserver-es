package com.vzhen.demo.config;

import com.vzhen.demo.service.MessagelogsService;

import java.util.concurrent.ThreadFactory;

/**
 * @param
 * @author chenhj
 * @version 1.0.0
 * @CreateTime 2019/1/4
 * @description TODO
 * @return
 */
public class MyThreadFactory implements ThreadFactory {
    MessagelogsService msgService;
    public MyThreadFactory(MessagelogsService msgService) {
        this.msgService = msgService;
    }

    @Override
    public Thread newThread(Runnable r) {

        return new TransThread(msgService);
    }
}
