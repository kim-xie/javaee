package com.my.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static com.my.utils.MySqlUtil.*;

/**
 * 
* @ClassName: ConnectionUtil  
* @Description: TODO(获取连接的工具)  
* @author king 
* @date 2016年3月26日 下午12:38:19 
* @version 1.0.0  
*
 */
public class ConnectionUtil {

	public static Connection getConection(){
		try {
			Class.forName(DRIVER);
			Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			return connection;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	};
	
	public static void closeResultSet(ResultSet rs,PreparedStatement stat,Connection con){
		try {
			if(rs!=null)rs.close();
			if(stat!=null)stat.close();
			if(con!=null)con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	};
	
	public static void closeStatement(PreparedStatement stat,Connection con){
		try {
			if(stat!=null)stat.close();
			if(con!=null)con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	};
	
	/**
	 * 
	 * @Title: main  
	 * @Description: TODO(测试方法)  
	 * @param @param args    设定文件  
	 * @return void    返回类型  
	 * @throws
	 */
	public static void main(String[] args) {
		System.out.println(getConection());
		
	}
}
