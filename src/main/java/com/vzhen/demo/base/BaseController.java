/**
 * org.vz.product.data.collect.base
 * @since : jdk 1.8
 */
package com.vzhen.demo.base;

import com.vzhen.demo.util.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author      chenhuaijin
 * @CreateTime  2017年7月25日 下午2:18:27
 * @version     1.0.0
 * @description 为后续 的controller初始化某些常用的操作
 */
public class BaseController {
	@Autowired
	protected LogUtil logger ;

	/**
	 * @param logger
	 */
	public BaseController() {
		
	}
	
}
