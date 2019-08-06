package com.vzhen.demo.domain;

import org.beetl.sql.core.annotatoin.AssignID;
import org.beetl.sql.core.annotatoin.Table;

import java.util.Date;

/**
 * @param
 * @author chenhj
 * @version 1.0.0
 * @CreateTime 2019/2/14
 * @description 与sqlserver的表对应的实体
 * @return
 */
@Table(name = "MessageLogs")
public class NewMessagelogs {
    @AssignID
    private String id;

    private String receiveeventname;

    private String receivemsgid;

    private Date receivetime;

    private String receivecontent;


    private Integer receivestatus;

    private String sendeventname;

    private String sendcontent;

    private Date sendtime;

    private Integer sendstatus;

    private Boolean sendorreceive;

    private String userid;

    private  Date createtime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReceivemsgid() {
        return receivemsgid;
    }

    public void setReceivemsgid(String receivemsgid) {
        this.receivemsgid = receivemsgid;
    }

    public Date getReceivetime() {
        return receivetime;
    }

    public void setReceivetime(Date receivetime) {
        this.receivetime = receivetime;
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

    public Integer getReceivestatus() {
        return receivestatus;
    }

    public void setReceivestatus(Integer receivestatus) {
        this.receivestatus = receivestatus;
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

    public Date getSendtime() {
        return sendtime;
    }

    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }

    public Integer getSendstatus() {
        return sendstatus;
    }

    public void setSendstatus(Integer sendstatus) {
        this.sendstatus = sendstatus;
    }

    public Boolean getSendorreceive() {
        return sendorreceive;
    }

    public void setSendorreceive(Boolean sendorreceive) {
        this.sendorreceive = sendorreceive;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "NewMessagelogs{" +
                "id='" + id + '\'' +
                ", receiveeventname='" + receiveeventname + '\'' +
                ", receivemsgid='" + receivemsgid + '\'' +
                ", receivetime=" + receivetime +
                ", receivecontent='" + receivecontent + '\'' +
                ", receivestatus=" + receivestatus +
                ", sendeventname='" + sendeventname + '\'' +
                ", sendcontent='" + sendcontent + '\'' +
                ", sendtime=" + sendtime +
                ", sendstatus=" + sendstatus +
                ", sendorreceive=" + sendorreceive +
                ", userid='" + userid + '\'' +
                ", createtime=" + createtime +
                '}';
    }
}
