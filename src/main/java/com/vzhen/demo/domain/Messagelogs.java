package com.vzhen.demo.domain;

import com.alibaba.fastjson.annotation.JSONField;
import org.beetl.sql.core.annotatoin.Table;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 * @param
 * @author chenhj
 * @version 1.0.0
 * @CreateTime 2019/1/3
 * @description mesaagelogs的映射,es区分大小写
 * @return
 */
@Document(indexName = "logs_info", type = "messagelogs",  replicas = 0)
@Table(name = "MessageLogs")
public class Messagelogs {
    @Id
    private String index;
    @Field
    @JSONField(serialize=false)
    private long extractTime;
    @Field(type=FieldType.Text)
    private String receivemsgid;
    @Field(type=FieldType.Text)
    private String receivesenderid;
    @Field(type=FieldType.Text)
    private String receivecontent;
    @Field(type=FieldType.Text)
    private String receiveeventname;
    @Field(type=FieldType.Text)
    private String sendeventname;
    @Field(type=FieldType.Text)
    private String sendcontent;
    @Field(type=FieldType.Text)
    private String userid;
    @Field( type = FieldType.Date,
    format = DateFormat.custom,pattern = "yyyy-MM-dd HH:mm:ss||yyyy-MM-dd||epoch_millis")
    private Date createdate;

    private String createtime;

    public Date getCreatedate() {
        return createdate;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public long getExtractTime() {
        return extractTime;
    }

    public void setExtractTime(long extractTime) {
        this.extractTime = extractTime;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getReceivemsgid() {
        return receivemsgid;
    }

    public void setReceivemsgid(String receivemsgid) {
        this.receivemsgid = receivemsgid;
    }

    public String getReceivesenderid() {
        return receivesenderid;
    }

    public void setReceivesenderid(String receivesenderid) {
        this.receivesenderid = receivesenderid;
    }

    public String getReceivecontent() {
        return receivecontent;
    }

    public void setReceivecontent(String receivecontent) {
        this.receivecontent = receivecontent;
    }

    public String getReceiveeventname() {
        return receiveeventname;
    }

    public void setReceiveeventname(String receiveeventname) {
        this.receiveeventname = receiveeventname;
    }

    public String getSendeventname() {
        return sendeventname;
    }

    public void setSendeventname(String sendeventname) {
        this.sendeventname = sendeventname;
    }

    public String getSendcontent() {
        return sendcontent;
    }

    public void setSendcontent(String sendcontent) {
        this.sendcontent = sendcontent;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "Messagelogs{" +
                "index='" + index + '\'' +
                ", extractTime=" + extractTime +
                ", receivemsgid='" + receivemsgid + '\'' +
                ", receivesenderid='" + receivesenderid + '\'' +
                ", receivecontent='" + receivecontent + '\'' +
                ", receiveeventname='" + receiveeventname + '\'' +
                ", sendeventname='" + sendeventname + '\'' +
                ", sendcontent='" + sendcontent + '\'' +
                ", userid='" + userid + '\'' +
                '}';
    }
}
