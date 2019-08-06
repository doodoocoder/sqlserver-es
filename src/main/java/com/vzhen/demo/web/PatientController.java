/**
 * org.vz.product.data.collect.web
 *
 * @since : jdk 1.8
 */
package com.vzhen.demo.web;


import com.vzhen.demo.base.BaseController;
import com.vzhen.demo.config.IndexSingleThread;
import com.vzhen.demo.config.IndexThread;
import com.vzhen.demo.config.TransThread;
import com.vzhen.demo.config.VzApplicationListener;
import com.vzhen.demo.domain.NewMessagelogsDoc;
import com.vzhen.demo.domain.Resp;
import com.vzhen.demo.domain.TbBaJbxx;
import com.vzhen.demo.elastic.NewMessagelogsRepository;
import com.vzhen.demo.elastic.TbBaJbxxRepository;
import com.vzhen.demo.service.MessagelogsService;
import com.vzhen.demo.service.NewMessagelogsService;
import com.vzhen.demo.service.PatientService;
import com.vzhen.demo.service.TbBaJbxxService;
import com.vzhen.demo.util.StringUtil;
import org.apache.http.client.utils.DateUtils;
import org.beetl.sql.core.engine.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * @author chenhj
 * @version 1.0.0
 * @CreateTime 2017年7月25日 上午12:29:47
 * @description 测试usercontoller
 */
@Controller
@RequestMapping("/vz")
public class PatientController extends BaseController {
    @Autowired
    PatientService patientService;
    @Autowired
    TbBaJbxxService tbBaJbxxService;
    @Autowired
    MessagelogsService msgService;

    @Autowired
    NewMessagelogsService logService;

    @Autowired
    TbBaJbxxRepository pr;

    @Autowired
    NewMessagelogsRepository repository;

    @RequestMapping(value = "/add")
    @ResponseBody
    public String add(TbBaJbxx p) {
        tbBaJbxxService.insert(p);
        String json = StringUtil.toJsonString(new Resp());
        return json;

    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public String update(TbBaJbxx p) {
        tbBaJbxxService.update(p);
        String json = StringUtil.toJsonString(new Resp());
        return json;

    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public String delete(TbBaJbxx p) {
        tbBaJbxxService.delete(p);
        String json = StringUtil.toJsonString(new Resp());
        return json;

    }

    @RequestMapping(value = "/page")
    @ResponseBody
    public String page(long pageNo, long pageSize) {
        PageQuery<TbBaJbxx> query = new PageQuery<TbBaJbxx>(pageNo, pageSize);
        query = tbBaJbxxService.pageQuery(query);
        List<TbBaJbxx> list = query.getList();
        Resp resp = new Resp();
        resp.setCount(query.getTotalRow());
        resp.setData(list);
        String json = StringUtil.toJsonString(resp);
        return json;

    }

    @RequestMapping(value = "/match")
    @ResponseBody
    public String match(TbBaJbxx p) {
        PageQuery<TbBaJbxx> query = new PageQuery<TbBaJbxx>(1, 10);
        query = tbBaJbxxService.matchQuery(query, p);
        List<TbBaJbxx> list = query.getList();
        Resp resp = new Resp();
        resp.setCount(query.getTotalRow());
        resp.setData(list);
        String json = StringUtil.toJsonString(resp);
        return json;

    }

    @RequestMapping(value = "/detail")
    @ResponseBody
    public String detail(TbBaJbxx p) {
        TbBaJbxx t = tbBaJbxxService.detail(p);
        return StringUtil.toJsonString(t);
    }

    @RequestMapping(value = "/gen")
    @ResponseBody
    public String genIndex(String id) throws ParseException {//建立索引后，从mysql中导入所有数据到es并生成索引
        if (id == null) {
            tbBaJbxxService.genIndex();
        } else {
            TbBaJbxx p = new TbBaJbxx();
            p.setBajbxxid(id);
            TbBaJbxx tbBaJbxx = tbBaJbxxService.detail(p);

            String esId = StringUtil.esId(null);
            tbBaJbxx.setIndex(esId);
            long extract = new Date().getTime();
            tbBaJbxx.setExtractTime(extract);
            pr.save(tbBaJbxx);

        }

        String json = StringUtil.toJsonString(new Resp());
        return json;
    }

    @RequestMapping(value = "/genx")
    @ResponseBody
    public String genxIndex() {//建立索引后，从sqlserver中导入所有数据到es并生成索引
        /*int count = 5;
        ExecutorService pool = Executors.newFixedThreadPool(count,new MyThreadFactory(msgService));
        for(int i=0;i<count;i++){
            pool.execute(new TransThread(msgService));
        }*/
        new TransThread(msgService).start();
        logger.info("已启动线程");
        String json = StringUtil.toJsonString(new Resp());
        return json;
    }

    @RequestMapping(value = "/genIndex")
    @ResponseBody
    public String genIndex() {

        new IndexThread(logService).start();
        String json = StringUtil.toJsonString(new Resp());
        return json;
    }
    @RequestMapping(value = "/genIndexSingle")
    @ResponseBody
    public String genIndexSingle() {

        new IndexSingleThread(logService).start();
        String json = StringUtil.toJsonString(new Resp());
        return json;
    }

    /**
     * 为测试Es写入性能
     * @return
     */
    @RequestMapping(value = "/test")
    @ResponseBody
    public String testOne() {
        NewMessagelogsDoc doc = new NewMessagelogsDoc();
       Resp resp =  new Resp();

        //判断是发送还是接收
        boolean flg = VzApplicationListener.log.getSendorreceive();
        if (flg) {//接收 receive

        } else {//发送 send
            String index = StringUtil.esId(new Date());

            doc.setIndex(index);

            doc.setMsgid(VzApplicationListener.log.getReceivemsgid());

            doc.setContent(VzApplicationListener.log.getSendcontent());

            doc.setStartdate(DateUtils.formatDate(VzApplicationListener.log.getSendtime(), "yyyy-MM-dd HH:mm:ss"));

            doc.setEnddate(DateUtils.formatDate(VzApplicationListener.log.getSendtime(), "yyyy-MM-dd HH:mm:ss"));

            doc.setSendorreceive(flg);

            doc.setStatus(200);

            doc.setReceivestatus(0);

            doc.setUserid(VzApplicationListener.log.getUserid());

            doc.setCreatedate(DateUtils.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss"));

            try{
                repository.save(doc);
            }catch (Throwable e){
                logger.error("写入错误",e);
                resp.setCode("500");
                resp.setMsg("fail");
            }




        }

        String json = StringUtil.toJsonString(resp);
        return json;
    }

}
