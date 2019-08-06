package com.vzhen.demo.service;

import java.text.ParseException;

/**
 * @param
 * @author chenhj
 * @version 1.0.0
 * @CreateTime 2018/10/25
 * @description 只有delete，select不会操作es
 * @return
 */
public interface MessagelogsService {





    void genIndex() throws ParseException, InterruptedException;


}
