/**
 * org.vz.product.data.collect.config
 *
 * @since : jdk 1.8
 */
package com.vzhen.demo.config;

import com.vzhen.demo.domain.NewMessagelogs;
import com.vzhen.demo.service.NewMessagelogsService;
import com.vzhen.demo.util.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author chenhuaijin
 * @CreateTime 2018年1月24日 上午11:22:44
 * @version 1.0.0
 * @description 监听spring上下文关闭与应用程序启动完成对zookeeper相关操作，为kettle引擎热备做准备
 */
@SuppressWarnings("rawtypes")
@Component
public class VzApplicationListener implements ApplicationListener {
    public  static NewMessagelogs log;
    LogUtil logUtil = new LogUtil(getClass());
    @Autowired
    NewMessagelogsService logService;
    @Override
    public void onApplicationEvent(ApplicationEvent event) {

        if (event instanceof ApplicationReadyEvent) {
            log = logService.queryOne();
            logUtil.info("初始化数据成功！"+log);

        }
    }


}



