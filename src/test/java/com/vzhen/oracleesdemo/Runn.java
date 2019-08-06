package com.vzhen.oracleesdemo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * @param
 * @author chenhj
 * @version 1.0.0
 * @CreateTime 2019/2/18
 * @description TODO
 * @return
 */
public class Runn {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+03:00"));
        System.out.println(sdf.format(new Date()));

    }
}
