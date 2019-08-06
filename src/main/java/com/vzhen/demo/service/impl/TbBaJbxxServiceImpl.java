package com.vzhen.demo.service.impl;

import com.vzhen.demo.dao.TbBaJbxxDao;
import com.vzhen.demo.domain.TbBaJbxx;
import com.vzhen.demo.elastic.TbBaJbxxRepository;
import com.vzhen.demo.service.TbBaJbxxService;
import com.vzhen.demo.util.StringUtil;
import org.apache.commons.lang3.time.DateUtils;
import org.beetl.sql.core.engine.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
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
public class TbBaJbxxServiceImpl implements TbBaJbxxService {
    @Autowired
    TbBaJbxxDao tbBaJbxxDao;

    @Autowired
    TbBaJbxxRepository pr;

    @Override
    public void insert(TbBaJbxx tbBaJbxx) {
        String id = StringUtil.uuid();
        tbBaJbxx.setBajbxxid(id);
        tbBaJbxx.setState("1");


        tbBaJbxxDao.getSQLManager().insert(tbBaJbxx);

        String esId = StringUtil.esId(null);
        tbBaJbxx.setIndex(esId);
        long extract = new Date().getTime();
        tbBaJbxx.setExtractTime(extract);
        pr.save(tbBaJbxx);

    }

    @Override
    public PageQuery<TbBaJbxx> matchQuery( PageQuery<TbBaJbxx> query,TbBaJbxx tbBaJbxx) {
        query.setPara("xm",tbBaJbxx.getXm());
        PageQuery<TbBaJbxx> rlt = tbBaJbxxDao.getSQLManager().pageQuery("tbBaJbxx.matchQuery", TbBaJbxx.class,query);
        return rlt;
    }

    @Override
    public PageQuery<TbBaJbxx> pageQuery(PageQuery<TbBaJbxx> query) {
        PageQuery<TbBaJbxx> rlt = tbBaJbxxDao.getSQLManager().pageQuery("tbBaJbxx.pageQuery", TbBaJbxx.class,query);
        return rlt;
    }

    @Override
    public void update(TbBaJbxx tbBaJbxx) {
        tbBaJbxx.setState("1");

        tbBaJbxxDao.getSQLManager().updateById(tbBaJbxx);

        String esId = StringUtil.esId(null);
        tbBaJbxx.setIndex(esId);
        long extract = new Date().getTime();
        tbBaJbxx.setExtractTime(extract);
        pr.save(tbBaJbxx);

    }

    @Override
    public void delete(TbBaJbxx tbBaJbxx) {
        tbBaJbxxDao.getSQLManager().update("tbBaJbxx.delete",tbBaJbxx);

    }

    @Override
    public void genIndex() throws ParseException {

        List<TbBaJbxx> list = tbBaJbxxDao.getSQLManager().select("tbBaJbxx.listAll",TbBaJbxx.class);
        String esId = "";
        long extract = 0;
       Date init = DateUtils.parseDate
               ("2018-10-03 15:02:03" ,"yyyy-MM-dd HH:mm:ss");
       Date in = null;
        Random random = new Random();
        int tip = 0;

        for(TbBaJbxx tbBaJbxx:list){

          //  tip = random.nextInt(12);//随机加时间 天，使extractTime随机

            in = DateUtils.addDays(init,tip);//加时间
            in = DateUtils.addHours(in,tip);//加小时

            esId = StringUtil.esId(in);
            extract = in.getTime();
            tbBaJbxx.setIndex(esId);
            tbBaJbxx.setExtractTime(extract);
            pr.save(tbBaJbxx);
        }
    }

    @Override
    public TbBaJbxx detail(TbBaJbxx p) {
        TbBaJbxx t= tbBaJbxxDao.getSQLManager().single(TbBaJbxx.class,p.getBajbxxid());
        return t;
    }
}
