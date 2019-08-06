package com.vzhen.demo.elastic;

import com.vzhen.demo.domain.TbBaJbxx;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

@Component
public interface TbBaJbxxRepository extends ElasticsearchRepository<TbBaJbxx,String> {



}