/**
 * org.vz.product.data.collect.util
 * @since : jdk 1.8
 */
package com.vzhen.demo.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @author      chenhj
 * @CreateTime  2017年7月24日 上午12:00:49
 * @version     1.0.0
 * @description 日志工具类
 */
@Component
public class LogUtil {
	private Logger logger;
	
	

	/**
	 * @param logger
	 */
	public LogUtil(@SuppressWarnings("rawtypes") Class clazz) {
		logger = LogManager.getLogger(clazz);
	}
	/**
	 * @param logger
	 */
	public LogUtil() {
		logger = LogManager.getLogger();
	}

	/**
	 * @return the logger
	 */
	public Logger getLogger() {
		return logger;
	}
	/**
	 * trace级别，用于打出该级别的日志信息
	 */
	public void trace(String msg){
		logger.trace(msg);
	}
	/**
	 * debug级别，用于打出该级别的日志信息
	 */
	public void debug(String msg){
		logger.debug(msg);
	}
	/**
	 * info级别，用于打出该级别的日志信息
	 */
	public void info(String msg){
		logger.info(msg);
	}
	/**
	 * warn级别，用于打出该级别的日志信息
	 */
	public void warn(String msg){
		logger.warn(msg);
	}
	/**
	 * 
	 * @description  TODO
	 * @author       chenhj
	 * @CreateTime   2017年7月24日 上午12:48:48
	 * @param msg 要打出的信息
	 * @param throwable 异常信息
	 */
	public void error(String msg,Throwable throwable){
		logger.error( msg,throwable);
	}
	/**
	 * error级别，用于打出该级别的日志信息
	 */
	public void error(String msg){
		logger.error(msg);
	}
	/**
	 * fatal级别，用于打出该级别的日志信息
	 */
	public void fatal(String msg){
		logger.fatal(msg);
	}
	/**
	 * @param logger the logger to set
	 */
	public void setLogger(Logger logger) {
		this.logger = logger;
	}
	
	

}
