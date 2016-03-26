package com.my.utils;
/**
 * 
* @ClassName: MySqlUtil  
* @Description: TODO(配置数据库连接)  
* @author king 
* @date 2016年3月26日 下午12:52:02 
* @version 1.0.0  
*
 */
public class MySqlUtil {
	//mysql数据库的驱动和链接信息
	public static final String DRIVER  = "com.mysql.jdbc.Driver";
	public static final String URL  = "jdbc:mysql://localhost:3306/lbs?useUnicode=true&characterEncoding=utf8";
	public static final String USERNAME  = "root";
	public static final String PASSWORD  = "mysql";
	
	//sessionId
	public static final String SESSION_USER_ID = "sessionUser";
	
	//sqlserver数据库的驱动和链接信息
//	public static final String DRIVER  = "com.sqlserver.jdbc.Driver";
//	public static final String URL  = "jdbc:mysql://localhost:3306/tz_zone";
//	public static final String USERNAME  = "root";
//	public static final String PASSWORD  = "xiaoer";
		
}
