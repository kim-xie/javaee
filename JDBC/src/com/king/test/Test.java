package com.king.test;

import java.sql.SQLException;
import java.util.List;

import com.king.bean.User;
import com.king.dao.UserDao;
/**
 * 测试类
 * 类名: Test.java
 * 创建人: king 
 * 创建时间：2016年4月7日 下午8:14:08 
 * @version 1.0.0
 */
public class Test {
	@org.junit.Test
	public void testFindAll() throws SQLException{
		List<User> users = UserDao.findAll();
		for(User user:users){
			System.out.println(user.getName()+"=="+user.getPassword()+"=="+user.getSex());
		}
	}
}
