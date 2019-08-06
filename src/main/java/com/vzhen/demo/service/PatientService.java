package com.vzhen.demo.service;

import com.vzhen.demo.domain.Patient;
import org.beetl.sql.core.engine.PageQuery;

import java.util.List;

/**
 * @param
 * @author chenhj
 * @version 1.0.0
 * @CreateTime 2018/10/25
 * @description 只有delete，select不会操作es
 * @return
 */
public interface PatientService {

    void insert(Patient patient);

    /**
     * 模糊查询
     * @param query
     * @param patient
     * @return
     */
    PageQuery<Patient> matchQuery(PageQuery<Patient> query,Patient patient);

    /**
     * 加载全部
     * @param query
     * @param patient
     * @return
     */

    PageQuery<Patient> pageQuery(PageQuery<Patient> query);

    void update(Patient patient);

    /**
     * 逻辑删除
     * @param patient
     */
    void delete(Patient patient);
}
