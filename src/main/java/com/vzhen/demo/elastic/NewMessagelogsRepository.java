package com.vzhen.demo.elastic;

import com.vzhen.demo.domain.NewMessagelogsDoc;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

@Component
public interface NewMessagelogsRepository extends ElasticsearchRepository<NewMessagelogsDoc,String> {



}