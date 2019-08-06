package com.vzhen.oracleesdemo;

import com.vzhen.demo.OracleEsDemoApplication;
import com.vzhen.demo.dao.NewMessagelogsDao;
import com.vzhen.demo.domain.NewMessagelogs;
import com.vzhen.demo.domain.NewMessagelogsDoc;
import com.vzhen.demo.elastic.NewMessagelogsRepository;
import com.vzhen.demo.service.NewMessagelogsService;
import com.vzhen.demo.util.StringUtil;
import org.apache.http.client.utils.DateUtils;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OracleEsDemoApplication.class)
public class OracleEsDemoApplicationTests {
    @Autowired
    NewMessagelogsDao dao;
    @Autowired
    NewMessagelogsRepository repository;
    @Autowired
    NewMessagelogsService newMessagelogsService;

    @Test
    public void queryOne() {
        List<NewMessagelogs> list = dao.getSQLManager().select("newmessagelogs.listAll", NewMessagelogs.class);

        NewMessagelogs log = list.get(0);

        NewMessagelogsDoc doc = new NewMessagelogsDoc();


        //判断是发送还是接收
        boolean flg = log.getSendorreceive();
        if (flg) {//接收 receive

        } else {//发送 send
            String index = StringUtil.esId(new Date());

            doc.setIndex(index);

            doc.setMsgid(log.getReceivemsgid());

            doc.setContent(log.getSendcontent());

            doc.setStartdate(DateUtils.formatDate(log.getSendtime(), "yyyy-MM-dd'T'HH:mm:ss"));

            doc.setEnddate(DateUtils.formatDate(log.getSendtime(), "yyyy-MM-dd'T'HH:mm:ss"));

            doc.setSendorreceive(flg);

            doc.setStatus(200);

            doc.setReceivestatus(0);

            doc.setUserid(log.getUserid());

            doc.setCreatedate(DateUtils.formatDate(new Date(),"yyyy-MM-dd'T'HH:mm:ss"));


            doc.setUserid(log.getUserid());

            repository.save(doc);
        }
    }

    @Test
    public void mys() {
        newMessagelogsService.batchEs();

    }

    @Test
    public void esQuery(){

        QueryBuilder queryBuilder =  QueryBuilders.rangeQuery("createdate").gt("2018-02-15 18:13:20").lt("2019-02-15T18:13:24");


        SearchQuery searchQuery =new NativeSearchQueryBuilder().withQuery(queryBuilder).build();
      //  System.out.println("查询的语句:" + searchQuery.getQuery().toString());
        Page<NewMessagelogsDoc> r =repository.search(searchQuery);
        System.out.println("msgid:"+r.getContent().get(0).getMsgid());
        System.out.println("content:"+r.getContent().get(0).getContent());
        System.out.println(r.getContent().get(0).getCreatedate());




    }
    @Test
    public void dateZone(){
        //System.out.println(DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss+800"));

        /*long t = System.currentTimeMillis();

        SimpleDateFormat sdf_8 = new SimpleDateFormat("yyy-MM-dd HH:mm");
        sdf_8.setTimeZone(TimeZone.getTimeZone("GMT0"));
        System.out.println("GMT0 = " + sdf_8.format(t));*/
        System.out.println(DateUtils.formatDate(new Date(), "yyyy-MM-ddTHH:mm:ss"));
        System.out.println(DateUtils.formatDate(new Date()));

    }

}
