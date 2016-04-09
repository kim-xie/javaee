package com.king.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
	public void testSave(){
	
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(ac);
		UserDao userDao = ac.getBean("userDao",UserDao.class);
		/**
		 * 添加
		 */
		User user = new User();
		user.setName("王五");
		user.setPassword("123456");
		userDao.save(user);
		/**
		 * 删除
		 */
		userDao.delete(31);
		/**
		 * 修改
		 */
		user.setName("李四");
		user.setPassword("123456");
		user.setId(30);
		userDao.update(user);
		/**
		 * 查询
		 */
		User user2 = userDao.findById(30);
		System.out.println(user2.getName()+"=="+user2.getPassword());
		
		List<User> users = userDao.findAll();
		for(User user1:users){
			System.out.println(user1.getName()+"=="+user1.getPassword());
		}
	}
}
