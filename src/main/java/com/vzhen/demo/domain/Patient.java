package com.vzhen.demo.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @param
 * @author chenhj
 * @version 1.0.0
 * @CreateTime 2018/10/25
 * @description es模型及oracle表模型
 * @return
 */
@Document(indexName = "basic_info", type = "patient", shards = 1, replicas = 0)
public class Patient {
    @Id
    private String index;//es的索引，不能与表的id用一个
    @Field
    private String patId;
    @Field(type = FieldType.Text)
    private String patName;
    @Field(format = DateFormat.basic_date)
    private String patBirth;
    @Field
    private String patAddr;
    @Field
    private String patNation;
    @Field
    private String patPhone;
    @Field
    private String patMarri;
    @Field
    private String patFam;
    @Field
    private String patHeight;
    @Field
    private String patWeight;
    @Field
    private String patCard;
    @Field
    private long extractTime;

    private String state;


    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getPatId() {
        return patId;
    }

    public void setPatId(String patId) {
        this.patId = patId;
    }

    public String getPatName() {
        return patName;
    }

    public void setPatName(String patName) {
        this.patName = patName;
    }

    public String getPatBirth() {
        return patBirth;
    }

    public void setPatBirth(String patBirth) {
        this.patBirth = patBirth;
    }

    public String getPatAddr() {
        return patAddr;
    }

    public void setPatAddr(String patAddr) {
        this.patAddr = patAddr;
    }

    public String getPatNation() {
        return patNation;
    }

    public void setPatNation(String patNation) {
        this.patNation = patNation;
    }

    public String getPatPhone() {
        return patPhone;
    }

    public void setPatPhone(String patPhone) {
        this.patPhone = patPhone;
    }

    public String getPatMarri() {
        return patMarri;
    }

    public void setPatMarri(String patMarri) {
        this.patMarri = patMarri;
    }

    public String getPatFam() {
        return patFam;
    }

    public void setPatFam(String patFam) {
        this.patFam = patFam;
    }

    public String getPatHeight() {
        return patHeight;
    }

    public void setPatHeight(String patHeight) {
        this.patHeight = patHeight;
    }

    public String getPatWeight() {
        return patWeight;
    }

    public void setPatWeight(String patWeight) {
        this.patWeight = patWeight;
    }

    public String getPatCard() {
        return patCard;
    }

    public void setPatCard(String patCard) {
        this.patCard = patCard;
    }

    public long getExtractTime() {
        return extractTime;
    }

    public void setExtractTime(long extractTime) {
        this.extractTime = extractTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patId='" + patId + '\'' +
                ", patName='" + patName + '\'' +
                ", patBirth=" + patBirth +
                ", patAddr='" + patAddr + '\'' +
                ", patNation='" + patNation + '\'' +
                ", patPhone='" + patPhone + '\'' +
                ", patMarri='" + patMarri + '\'' +
                ", patFam='" + patFam + '\'' +
                ", patHeight='" + patHeight + '\'' +
                ", patWeight='" + patWeight + '\'' +
                ", patCard='" + patCard + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
