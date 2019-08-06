/**
 * org.vz.product.data.collect.domain
 * @since : jdk 1.8
 */
package com.vzhen.demo.domain;

import org.beetl.sql.core.annotatoin.AssignID;
import org.springframework.data.annotation.Id;

/**
 * @author      chenhj
 * @CreateTime  2017年7月24日 下午10:41:17
 * @version     1.0.0
 * @description TODO
 */
public class User {
	@Id
	private int id;
	private String nameDexMon;
	private String age;
	private boolean bl;
	
	
	/**
	 * @return the id
	 */
	@AssignID("uuid2")
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * @return the nameDexMon
	 */
	public String getNameDexMon() {
		return nameDexMon;
	}
	/**
	 * @return the bl
	 */
	public boolean isBl() {
		return bl;
	}
	/**
	 * @param bl the bl to set
	 */
	public void setBl(boolean bl) {
		this.bl = bl;
	}
	/**
	 * @param nameDexMon the nameDexMon to set
	 */
	public void setNameDexMon(String nameDexMon) {
		this.nameDexMon = nameDexMon;
	}
	/**
	 * @return the age
	 */
	public String getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(String age) {
		this.age = age;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}

	


	
}
