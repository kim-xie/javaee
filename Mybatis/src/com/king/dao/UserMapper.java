package com.king.dao;

import java.util.List;

import com.king.bean.User;
/**
 * UserMapper接口
 * 类名: UserMapper.java
 * 创建人: king 
 * 创建时间：2016年4月8日 下午5:28:46 
 * @version 1.0.0
 */
public interface UserMapper {	
	//查询所有用户
	List<User> findAll();
	//根据id查询用户
	User findById(Integer id);
	//添加用户
	Boolean save(User user);
	//修改用户
	Boolean update(User user);
	//根据id删除用户
	Boolean delete(Integer id);
}
