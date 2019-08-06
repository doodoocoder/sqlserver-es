package com.vzhen.demo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @param
 * @author chenhj
 * @version 1.0.0
 * @CreateTime 2019/2/14
 * @description ES中对应的document
 * @return
 */

@Document(indexName = "logs_info_test", type = "messagelogs_test",  replicas = 2)
public class NewMessagelogsDoc {
    @Id
    private String index;
    @Field(type = FieldType.Keyword)
    private String msgid;
    @Field(type = FieldType.Text)
    private String content;
    private String startdate;
    private String enddate;
    @Field(type = FieldType.Integer)
    private int consumetime;
    @Field(type = FieldType.Keyword)
    private String eventname;

    @Field(type = FieldType.Boolean)
    private boolean sendorreceive;
    @Field(type = FieldType.Integer)
    private int status;
    @Field(type = FieldType.Integer)
    private  int sendstatus;
    @Field(type = FieldType.Integer)
    private int receivestatus;
    @Field(type = FieldType.Keyword)
    private String userid;
    @Field(type = FieldType.Text)
    private String errormsg;
    private String createdate;

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getMsgid() {
        return msgid;
    }

    public void setMsgid(String msgid) {
        this.msgid = msgid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    public int getConsumetime() {
        return consumetime;
    }

    public void setConsumetime(int consumetime) {
        this.consumetime = consumetime;
    }

    public boolean isSendorreceive() {
        return sendorreceive;
    }

    public void setSendorreceive(boolean sendorreceive) {
        this.sendorreceive = sendorreceive;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getSendstatus() {
        return sendstatus;
    }

    public void setSendstatus(int sendstatus) {
        this.sendstatus = sendstatus;
    }

    public int getReceivestatus() {
        return receivestatus;
    }

    public void setReceivestatus(int receivestatus) {
        this.receivestatus = receivestatus;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getErrormsg() {
        return errormsg;
    }

    public void setErrormsg(String errormsg) {
        this.errormsg = errormsg;
    }

    public String getCreatedate() {
        return createdate;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }
}
