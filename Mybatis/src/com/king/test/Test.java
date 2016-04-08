package com.king.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.king.bean.Content;
import com.king.bean.User;
import com.king.dao.ContentMapper;
import com.king.dao.UserMapper;
import com.king.util.MybatisUtil;

public class Test {
	public static void main(String[] args) {

		Date date = new Date();
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String s=sf.format(date);
		System.out.println(s);
		
	}
	@org.junit.Test
	public void testUserMapper(){
		SqlSession session = MybatisUtil.getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		
		User user1 = new User();
		user1.setName("jimi");
		user1.setPassword("123456");
		mapper.save(user1);
		System.out.println(user1.getName()+"=="+user1.getPassword());
		
		User user2 = mapper.findById(4);
		user2.setName("jie");
		user2.setPassword("123456");
		mapper.update(user2);
		System.out.println(user2.getName()+"=="+user2.getPassword());
		
		//mapper.delete(7);
		
		List<User> users = mapper.findAll();
		for(User user:users){
			System.out.println(user.getName()+"=="+user.getPassword());
		}
		
		session.commit();
		session.close();
	}
	
	@org.junit.Test
	public void testContentMapper(){
		SqlSession session = MybatisUtil.getSession();
		ContentMapper mapper = session.getMapper(ContentMapper.class);
		
		List<Content> contents = mapper.findAll();
		for(Content content:contents){
			System.out.println(content.getContent()+"=="+content.getTitle());
		}
		session.commit();
		session.close();
	}
}
