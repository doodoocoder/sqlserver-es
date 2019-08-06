package com.vzhen.demo.service;

import com.vzhen.demo.domain.TbBaJbxx;
import org.beetl.sql.core.engine.PageQuery;

import java.text.ParseException;
import java.util.List;

/**
 * @param
 * @author chenhj
 * @version 1.0.0
 * @CreateTime 2018/10/25
 * @description 只有delete，select不会操作es
 * @return
 */
public interface TbBaJbxxService {

    void insert(TbBaJbxx tbBaJbxx);

    /**
     * 模糊查询
     * @param query
     * @param TbBaJbxx
     * @return
     */
    PageQuery<TbBaJbxx> matchQuery(PageQuery<TbBaJbxx> query, TbBaJbxx tbBaJbxx);

    /**
     * 加载全部
     * @param query
     * @param TbBaJbxx
     * @return
     */

    PageQuery<TbBaJbxx> pageQuery(PageQuery<TbBaJbxx> query);

    void update(TbBaJbxx tbBaJbxx);

    /**
     * 逻辑删除
     * @param TbBaJbxx
     */
    void delete(TbBaJbxx tbBaJbxx);


    void genIndex() throws ParseException;

    TbBaJbxx detail(TbBaJbxx p);
}
