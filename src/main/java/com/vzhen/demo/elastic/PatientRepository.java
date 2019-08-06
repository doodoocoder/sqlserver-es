package com.vzhen.demo.elastic;

import com.vzhen.demo.domain.Patient;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

@Component
public interface PatientRepository extends ElasticsearchRepository<Patient,String> {



}