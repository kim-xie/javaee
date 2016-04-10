package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.king.po.UserInfo;
import com.king.service.UserInfoService;

public class Test {
public static void main(String[] args) {
	
	ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
	UserInfoService userInfoService = (UserInfoService) ac.getBean("userInfoServiceImpl");
	UserInfo user = new UserInfo();
	user.setuserName("ÍõÐ¡Îå");
	user.setuserSex("ÄÐ");
	boolean mark = userInfoService.addUser(user);
	System.out.println(mark);
}
}
