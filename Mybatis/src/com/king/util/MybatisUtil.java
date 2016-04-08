package com.king.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
/**
 * MybatisUtil工具类获取sqlsession连接
 * 类名: MybatisUtil.java
 * 创建人: king 
 * 创建时间：2016年4月7日 下午5:33:25 
 * @version 1.0.0
 */
public class MybatisUtil {
	private static SqlSessionFactory sf;
	static{
		//加载配置文件
		SqlSessionFactoryBuilder build=new SqlSessionFactoryBuilder();
		sf=build.build(MybatisUtil.class.getClassLoader().
		getResourceAsStream("SqlMapConfig.xml"));
	}
	
	//创建连接
	public static SqlSession getSession(){
		return sf.openSession();
	}
	//测试代码
	public static void main(String[] args) {
		SqlSession session=MybatisUtil.getSession();
		System.out.println(session);
		session.close();
	}
}
