package com.vzhen.demo.service.impl;

import com.vzhen.demo.dao.NewMessagelogsDao;
import com.vzhen.demo.domain.BatchStuff;
import com.vzhen.demo.domain.NewMessagelogs;
import com.vzhen.demo.domain.NewMessagelogsDoc;
import com.vzhen.demo.elastic.NewMessagelogsRepository;
import com.vzhen.demo.service.NewMessagelogsService;
import com.vzhen.demo.util.LogUtil;
import com.vzhen.demo.util.StringUtil;
import org.apache.http.client.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @param
 * @author chenhj
 * @version 1.0.0
 * @CreateTime 2019/2/14
 * @description TODO
 * @return
 */
@Service
public class NewMessagelogsServiceImpl implements NewMessagelogsService {
    @Autowired
    NewMessagelogsDao dao;

    @Autowired
    NewMessagelogsRepository repository;

    LogUtil logUtil = new LogUtil(getClass());

    @Override
    public List<NewMessagelogs> getAllPrimaryKey() {
        List<NewMessagelogs> list = dao.getSQLManager().select("newmessagelogs.getAllPrimaryKey", NewMessagelogs.class);
        return list;
    }

    @Override
    public void inSertEs(List<NewMessagelogs> list) {
        int len = list.size();
        BatchStuff batchStuff = new BatchStuff();
        List<NewMessagelogsDoc> es;
        List<String> temp;
        for (int i = 0; i < 5000; i++) {


            if (i * 500 < len) {

                temp = new ArrayList<>(510);
                for (int j = i * 500; j < (i + 1) * 500; j++) {
                    temp.add(list.get(j).getId());
                }
                batchStuff.setIds(temp);
                List<NewMessagelogs> ret = dao.getSQLManager().
                        select("newmessagelogs.getBatchEntity", NewMessagelogs.class, batchStuff);
                es = new ArrayList<>(510);
                NewMessagelogsDoc doc;
                String index;
                for (NewMessagelogs log : ret) {
                    doc = new NewMessagelogsDoc();

                    //判断是发送还是接收
                    boolean flg = log.getSendorreceive();
                    index = StringUtil.esId(new Date());
                    doc.setIndex(index);
                    doc.setMsgid(log.getReceivemsgid());
                    doc.setConsumetime(0);
                    doc.setUserid(log.getUserid());
                    doc.setCreatedate(DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
                    doc.setSendorreceive(flg);
                    doc.setStatus(200);

                    if (flg) {//接收 receive
                        doc.setContent(log.getReceivecontent());

                        doc.setStartdate(DateUtils.formatDate(log.getReceivetime(), "yyyy-MM-dd HH:mm:ss"));

                        doc.setEnddate(DateUtils.formatDate(log.getReceivetime(), "yyyy-MM-dd HH:mm:ss"));

                        doc.setReceivestatus(0);

                    } else {//发送 send

                        doc.setContent(log.getSendcontent());

                        doc.setStartdate(DateUtils.formatDate(log.getSendtime(), "yyyy-MM-dd HH:mm:ss"));

                        doc.setEnddate(DateUtils.formatDate(log.getSendtime(), "yyyy-MM-dd HH:mm:ss"));

                        doc.setSendstatus(0);


                    }
                    es.add(doc);
                }
                repository.saveAll(es);
            }
        }

    }

    @Override
    public void batchEs() {
        List<NewMessagelogs> ret = dao.getSQLManager().
                select("newmessagelogs.getBatch", NewMessagelogs.class);

        List<NewMessagelogsDoc> es = new ArrayList<>(510);
        NewMessagelogsDoc doc;
        String index;
        boolean hasValue = true;
        if (ret.size() == 0) {
            hasValue = false;
            logUtil.info("未查询出数据,可能的原因：数据已经导入完毕。");
            return;
        }
        for (NewMessagelogs log : ret) {
            doc = new NewMessagelogsDoc();
            //判断是发送还是接收
            boolean flg = log.getSendorreceive();
            index = StringUtil.esId(new Date());
            doc.setIndex(index);
            doc.setMsgid(log.getReceivemsgid());
            doc.setConsumetime(0);
            doc.setUserid(log.getUserid());
            doc.setCreatedate(DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
            doc.setSendorreceive(flg);
            doc.setStatus(200);
            if (flg) {//接收 receive
                doc.setContent(log.getReceivecontent());
                doc.setStartdate(DateUtils.formatDate(log.getReceivetime(), "yyyy-MM-dd HH:mm:ss"));
                doc.setEnddate(DateUtils.formatDate(log.getReceivetime(), "yyyy-MM-dd HH:mm:ss"));
                doc.setReceivestatus(0);
                doc.setEventname(log.getReceiveeventname());

            } else {//发送 send
                doc.setContent(log.getSendcontent());
                doc.setStartdate(DateUtils.formatDate(log.getSendtime(), "yyyy-MM-dd HH:mm:ss"));
                doc.setEnddate(DateUtils.formatDate(log.getSendtime(), "yyyy-MM-dd HH:mm:ss"));
                doc.setSendstatus(0);
                doc.setEventname(log.getSendeventname());
            }
            es.add(doc);
        }
        repository.saveAll(es);
        //修改字段isReply
        dao.getSQLManager().updateBatch("newmessagelogs.updateBatchById", ret);


    }

    @Override
    public void oneyByOneEs() {
        List<NewMessagelogs> ret = dao.getSQLManager().
                select("newmessagelogs.getBatch", NewMessagelogs.class);


        NewMessagelogsDoc doc;
        String index;
        for (NewMessagelogs log : ret) {
            doc = new NewMessagelogsDoc();

            //判断是发送还是接收
            boolean flg = log.getSendorreceive();
            index = StringUtil.esId(new Date());
            doc.setIndex(index);
            doc.setMsgid(log.getReceivemsgid());
            doc.setConsumetime(0);
            doc.setUserid(log.getUserid());
            doc.setCreatedate(DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
            doc.setSendorreceive(flg);
            doc.setStatus(200);


            if (flg) {//接收 receive
                doc.setContent(log.getReceivecontent());

                doc.setStartdate(DateUtils.formatDate(log.getReceivetime(), "yyyy-MM-dd HH:mm:ss"));

                doc.setEnddate(DateUtils.formatDate(log.getReceivetime(), "yyyy-MM-dd HH:mm:ss"));

                doc.setReceivestatus(0);

                doc.setEventname(log.getReceiveeventname());

            } else {//发送 send

                doc.setContent(log.getSendcontent());

                doc.setStartdate(DateUtils.formatDate(log.getSendtime(), "yyyy-MM-dd HH:mm:ss"));

                doc.setEnddate(DateUtils.formatDate(log.getSendtime(), "yyyy-MM-dd HH:mm:ss"));

                doc.setSendstatus(0);

                doc.setEventname(log.getSendeventname());


            }
            try {

                repository.save(doc);


            } catch (Throwable e) {
                logUtil.error("插入ES出错：[msgid]" + doc.getMsgid() + new Date(), e);
                return;
            }
            try {
                //修改字段isReply
                dao.getSQLManager().update("newmessagelogs.updateBatchById", log);
            } catch (Throwable e) {
                logUtil.error("更新出错：[msgid]" + doc.getMsgid() + new Date(), e);
                return;
            }
            logUtil.info("导入Es并更新数据成功:[msgid]" + doc.getMsgid());

        }
    }

    @Override
    public NewMessagelogs queryOne() {
        List<NewMessagelogs> list = dao.getSQLManager().select("newmessagelogs.listAll", NewMessagelogs.class);

        NewMessagelogs log = list.get(0);
        return log;
    }
}

