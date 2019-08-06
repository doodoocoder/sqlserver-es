/**
 * org.vz.product.data.collect.service
 * @since : jdk 1.8
 */
package com.vzhen.demo.service;


import com.vzhen.demo.domain.User;
import org.beetl.sql.core.engine.PageQuery;

import java.util.List;

/**
 * @author      chenhj
 * @CreateTime  2017年7月24日 下午10:29:14
 * @version     1.0.0
 * @description TODO
 */
public interface UserService {
	public List<User> finById(String id);

	/**
	 * @description  TODO
	 * @author       chenhuaijin
	 * @CreateTime   2017年7月25日 下午2:32:19
	 * @param 从md文件得到
	 * @return
	 */
	public List<User> finById(User uu);

	/**
	 * @description  TODO
	 * @author       chenhuaijin
	 * @CreateTime   2017年7月25日 下午3:00:01
	 * @param uu
	 */
	public void insert(User uu);

	/**
	 * @description  TODO
	 * @author       chenhuaijin
	 * @CreateTime   2017年7月25日 下午3:06:42
	 * @param uu
	 */
	public void update(User uu);

	/**
	 * @description  TODO
	 * @author       chenhuaijin
	 * @CreateTime   2017年7月25日 下午4:00:40
	 * @param string
	 * @param query
	 */
	public void pageQuery(String string, PageQuery<User> query);


}
