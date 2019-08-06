package com.vzhen.demo.service.impl;

import com.vzhen.demo.dao.MessagelogsDao;
import com.vzhen.demo.domain.Messagelogs;
import com.vzhen.demo.elastic.MessagelogsRepository;
import com.vzhen.demo.service.MessagelogsService;
import com.vzhen.demo.util.LogUtil;
import com.vzhen.demo.util.StringUtil;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @param
 * @author chenhj
 * @version 1.0.0
 * @CreateTime 2018/10/25
 * @description TbBaJbxxservice实现,在增加，修改加上es索引
 * @return
 */
@Service
public class MessagelogsServiceImpl implements MessagelogsService {
    @Autowired
    MessagelogsDao msgDao;

    @Autowired
    MessagelogsRepository pr;

    LogUtil log =new LogUtil(getClass());


    @Override
    public void genIndex() throws ParseException, InterruptedException {

        List<Messagelogs> list = msgDao.getSQLManager().select("messagelogs.listAll",Messagelogs.class);
        String esId = "";
        long extract = 0;
       Date init = DateUtils.parseDate
               ("2018-10-03 15:02:03" ,"yyyy-MM-dd HH:mm:ss");
       Date in = null;
        Random random = new Random();
        int tip = 0;
       // pr.saveAll(list);批量遇到单个字段数据长于32766，报错，终止，没报错的可以写入
        for(Messagelogs msg:list){



            esId = StringUtil.esId(null);
            extract = new Date().getTime();
            msg.setIndex(esId);
            msg.setCreatedate(new Date());

            msg.setExtractTime(extract);
            try{
                pr.save(msg);
                log.warn("******入库:"+msg.getReceivemsgid()+new Date());
            }catch (Exception e){
                e.printStackTrace();
                log.error("***异常信息："+ Arrays.toString(e.getStackTrace()));
                log.error("遇到错误。。。。"+msg.getReceivemsgid()+"**thread is :"+Thread.currentThread().getId());
            }


            Thread.sleep(1*1000);//休息1s
        }
    }


}
