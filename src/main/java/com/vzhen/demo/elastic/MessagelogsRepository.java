package com.vzhen.demo.elastic;

import com.vzhen.demo.domain.Messagelogs;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

@Component
public interface MessagelogsRepository extends ElasticsearchRepository<Messagelogs,String> {



}