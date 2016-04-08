package com.king.bean;

import java.io.Serializable;
import java.util.Date;
/**
 * User实体类
 * 类名: User.java
 * 创建人: king 
 * 创建时间：2016年4月7日 下午5:07:44 
 * @version 1.0.0
 */
public class User implements Serializable{
	//实现IO序列化 可以以流的形式输出
	private static final long serialVersionUID = 1L;
	//主键
	private Integer id;
	//用户名
	private String name;
	//密码
	private String password;
	//性别  1--男性  0--女性
	private Integer sex;
	//年龄
	private Integer age;
	//邮箱
	private String email;
	//电话
	private Integer tel;
	//创建时间
	private Date createTime;
	//更新时间
	private Date updateTime;
	//头像
	private String headerPic;
	//是否激活  1--已激活  0--未激活
	private Integer active;
	//是否删除  1--已删除  0--未删除
	private Integer isDelete;
	
	//无参构造器
	public User() {
		
	}
	//有参构造器
	public User(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getTel() {
		return tel;
	}
	public void setTel(Integer tel) {
		this.tel = tel;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getHeaderPic() {
		return headerPic;
	}
	public void setHeaderPic(String headerPic) {
		this.headerPic = headerPic;
	}
	public Integer getActive() {
		return active;
	}
	public void setActive(Integer active) {
		this.active = active;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
