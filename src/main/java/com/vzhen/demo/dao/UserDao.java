/**
 * org.vz.product.data.collect.dao
 * @since : jdk 1.8
 */
package com.vzhen.demo.dao;

import com.vzhen.demo.domain.User;
import org.beetl.sql.core.annotatoin.SqlStatement;

/**
 * @author      chenhj
 * @CreateTime  2017年7月24日 下午10:28:31
 * @version     1.0.0
 * @description TODO
 */
public interface UserDao extends BaseDao<User>{
	
	 @SqlStatement(params = "name")
     User selectUserByName(String name);
}
