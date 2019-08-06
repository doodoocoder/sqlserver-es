package com.vzhen.demo.service.impl;

import com.vzhen.demo.dao.PatientDao;
import com.vzhen.demo.domain.Patient;
import com.vzhen.demo.elastic.PatientRepository;
import com.vzhen.demo.service.PatientService;
import com.vzhen.demo.util.StringUtil;
import org.beetl.sql.core.engine.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @param
 * @author chenhj
 * @version 1.0.0
 * @CreateTime 2018/10/25
 * @description patientservice实现,在增加，修改加上es索引
 * @return
 */
@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    PatientDao patientDao;

    @Autowired
    PatientRepository pr;

    @Override
    public void insert(Patient patient) {
        String id = StringUtil.uuid();
        patient.setPatId(id);
        patient.setState("1");

        patientDao.getSQLManager().insert("patient.save",patient,null);

        String esId = StringUtil.esId(null);
        patient.setIndex(esId);
        long extract = new Date().getTime();
        patient.setExtractTime(extract);
        pr.save(patient);

    }

    @Override
    public PageQuery<Patient> matchQuery( PageQuery<Patient> query,Patient patient) {
        query.setPara("patName",patient.getPatName());
        PageQuery<Patient> rlt = patientDao.getSQLManager().pageQuery("patient.matchQuery", Patient.class,query);
        return rlt;
    }

    @Override
    public PageQuery<Patient> pageQuery(PageQuery<Patient> query) {
        PageQuery<Patient> rlt = patientDao.getSQLManager().pageQuery("patient.pageQuery", Patient.class,query);
        return rlt;
    }

    @Override
    public void update(Patient patient) {
        patientDao.getSQLManager().update("patient.update",patient);

        String esId = StringUtil.esId(null);
        patient.setIndex(esId);
        long extract = new Date().getTime();
        patient.setExtractTime(extract);
        pr.save(patient);

    }



    @Override
    public void delete(Patient patient) {
        patientDao.getSQLManager().update("patient.delete",patient);

    }
}
