/**
 * org.vz.product.data.collect.service.impl
 * @since : jdk 1.8
 */
package com.vzhen.demo.service.impl;


import com.vzhen.demo.dao.UserDao;
import com.vzhen.demo.domain.User;
import com.vzhen.demo.service.UserService;
import org.beetl.sql.core.engine.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author      chenhj
 * @CreateTime  2017年7月25日 上午12:22:17
 * @version     1.0.0
 * @description TODO
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
    UserDao userDao;

	/* (non-Javadoc)
	 * @see org.vz.product.data.collect.service.UserService#finById(java.lang.String)
	 */
	@Override
	public List<User> finById(String id) {
		
		return  userDao.getSQLManager().select("user.findById", User.class, id);
	}

	/* (non-Javadoc)
	 * @see org.vz.product.data.collect.service.UserService#finById(org.vz.product.data.collect.domain.User)
	 */
	@Override
	public List<User> finById(User uu) {
		
		return  userDao.getSQLManager().select("user.selectById", User.class, uu);
	}

	/* (non-Javadoc)
	 * @see org.vz.product.data.collect.service.UserService#insert(org.vz.product.data.collect.domain.User)
	 */
	@Override
	public void insert(User uu) {
		userDao.insert(uu);
		
	}

	/* (non-Javadoc)
	 * @see org.vz.product.data.collect.service.UserService#update(org.vz.product.data.collect.domain.User)
	 */
	@Override
	public void update(User uu) {
		userDao.updateById(uu);
		
	}

	/* (non-Javadoc)
	 * @see org.vz.product.data.collect.service.UserService#pageQuery(java.lang.String, org.beetl.sql.core.engine.PageQuery)
	 */
	@Override
	@Transactional
	public void pageQuery(String sqlid, PageQuery<User> query) {
		userDao.getSQLManager().pageQuery(sqlid, User.class,query);
		//userDao.pageQuery(sqlid,clazz, query);
		
	}


	
	

}
