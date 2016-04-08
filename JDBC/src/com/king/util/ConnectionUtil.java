package com.king.util;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 * 获取数据库连接工具类
 * 类名: ConnectionUtil.java
 * 创建人: king 
 * 创建时间：2016年4月7日 下午7:35:01 
 * @version 1.0.0
 */
public class ConnectionUtil {
	/**
	 * 定义数据库连接常量
	 */
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/MyBoke";
	private static final String username = "root";
	private static final String password = "mysql";
	/**
	 * @Title: getConnection 
	 * @Description: TODO(获取数据库连接的方法) 
	 * @param @return  参数说明 
	 * @return Connection  返回类型 
	 * @throws
	 */
	public static Connection getConnection(){
		Connection connection = null;
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url,username,password);
			return connection;
		} catch (Exception e) {
			return null;	
		}
	};

	/**
	 * @Title: main 
	 * @Description: TODO(测试数据库连接是否成功) 
	 * @param @param args  参数说明 
	 * @return void  返回类型 
	 * @throws
	 */
	public static void main(String[] args) {
		Connection connection = ConnectionUtil.getConnection();
		System.out.println(connection);
	}
}
