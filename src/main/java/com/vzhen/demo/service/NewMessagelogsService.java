package com.vzhen.demo.service;

import com.vzhen.demo.domain.NewMessagelogs;

import java.util.List;

/**
 * @param
 * @author chenhj
 * @version 1.0.0
 * @CreateTime 2019/2/14
 * @description TODO
 * @return
 */
public interface NewMessagelogsService {
    List<NewMessagelogs> getAllPrimaryKey();

    /**
     * 不修改数据表中的数据进行导数据到ES
     * 根据传入的list，批量写入es
     * @param list
     */
    void inSertEs(List<NewMessagelogs> list);

    /**
     * 修改数据表中的数据isReply进行导数据到ES
     * 根据传入的list，批量写入es
     */
    void batchEs();

    /**
     * 一条一条导入Es,记录哪些出错
     */
    void oneyByOneEs();

    /**
     * 采用固定一条数据的方式写入ES,不查询关系型数据库,只查询一条数据
     *
     */
    NewMessagelogs queryOne();
}
