/**
 * org.vz.product.data.collect.util
 * @since : jdk 1.8
 */
package com.vzhen.demo.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

/**
 * @author      chenhuaijin
 * @CreateTime  2017年7月26日 下午4:25:30
 * @version     1.0.0
 * @description 先提供转换成json 字符串和json对象的，后再补充
 */
public class StringUtil {
	
	public static String toJsonString(Object obj){

		return JSON.toJSONString(obj, SerializerFeature.WriteMapNullValue);
	}
	public static <T> List<T> toList(String obj,Class<T> clz){
		return JSON.parseArray( obj, clz);
	}
	public static JSONObject parseJSONObject(String str){
		return JSON.parseObject(str);
	}
	/**
	 * 
	 * @description  截取最后个分隔符后面的内容，不包括分隔符
	 * @author       chenhuaijin
	 * @CreateTime   2017年7月28日 上午10:54:04
	 * @param str  要处理的字符串
	 * @param sepa 分隔符
	 * @return
	 */
	public static String substringAfterLast(String str,String sepa){
		String rlt = StringUtils.substringAfterLast(str,sepa);
		return rlt;
	}
	/**
	 * 
	 * @description  统一标准得到的uuid
	 * @author       chenhuaijin
	 * @CreateTime   2017年8月1日 上午11:39:08
	 * @return
	 */
	public static String uuid(){
		String uuid = UUID.randomUUID().toString();
		return uuid;
	}



    public static String esId(Date date){
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss",Locale.getDefault());
        String id ="";
        if(date == null){
           id = format.format(new Date())+uuid().substring(0,8).replace("-","x");
        }else {
            id= format.format(date)+uuid().substring(0,8).replace("-","x");
        }


        return  id;
    }
	/**
	 * 
	 * @description  将list加个分隔符变成字符串
	 * @author       chenhuaijin
	 * @CreateTime   2017年9月5日 上午9:18:16
	 * @param list
	 * @param separator
	 * @return
	 */
	public static String listToString(List<?> list, String separator){
		String rlt = StringUtils.join(list.toArray(),separator);
		return rlt;
		
	}
	/**
	 * 
	 * @description  某个字符串是否包含另一个字符串
	 * @author       chenhuaijin
	 * @CreateTime   2017年9月5日 上午9:18:45
	 * @param str
	 * @param search
	 * @return
	 */
	public static boolean contains(String str,String search){
		return StringUtils.contains(str, search);
	}
	/**
	 * 
	 * @description 生成不重复的Long
	 * @author       chenhuaijin
	 * @CreateTime   2017年9月5日 上午9:19:08
	 * @return
	 */
	public static long randomNoDuplicate(){
		return System.currentTimeMillis()/1000 - 500;
	}
	/**
	 * 
	 * @description  某个字符串是否以某个字符串开头
	 * @author       chenhuaijin
	 * @CreateTime   2017年9月5日 上午9:19:29
	 * @param str
	 * @param prefix
	 * @return
	 */
	public static boolean startWith(String str,String prefix){
		return StringUtils.startsWith(str, prefix);
	}
	/**
	 * 
	 * @description  把字符串左右的空格去掉
	 * @author       chenhuaijin
	 * @CreateTime   2017年9月14日 上午10:33:11
	 * @param str
	 * @return
	 */
	public static String trim(String str){
		return StringUtils.trim(str);
	}
	

}
