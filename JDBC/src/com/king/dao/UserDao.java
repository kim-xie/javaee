package com.king.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.king.bean.User;
import com.king.util.ConnectionUtil;
/**
 * UserDao对数据库进行curd
 * 类名: UserDao.java
 * 创建人: king 
 * 创建时间：2016年4月7日 下午8:07:49 
 * @version 1.0.0
 */
public class UserDao {
	/**
	 * @Title: findAll 
	 * @Description: TODO(查询所有用户) 
	 * @param @return
	 * @param @throws SQLException  参数说明 
	 * @return List<User>  返回类型 
	 * @throws
	 */
	public static List<User> findAll() throws SQLException{
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<User> users = null;
		try {
			String sql = "SELECT * FROM USER";
			connection = ConnectionUtil.getConnection();
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			users = new ArrayList<User>();
			while(rs.next()){
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setSex(rs.getInt("sex"));
				user.setAge(rs.getInt("age"));
				users.add(user);
			}
			return users;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			if(rs != null){
				rs.close();
			}
			if(ps != null){
				ps.close();
			}
			if(connection != null){
				connection.close();
			}
		}
	}
	/**
	 * @Title: findById 
	 * @Description: TODO(根据id查询用户) 
	 * @param @param id
	 * @param @return
	 * @param @throws SQLException  参数说明 
	 * @return User  返回类型 
	 * @throws
	 */
	public User findById(Integer id) throws SQLException{
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM USER WHERE id=?";
			connection = ConnectionUtil.getConnection();
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			User user = null;
			while(rs.next()){
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setSex(rs.getInt("sex"));
				user.setAge(rs.getInt("age"));
			}
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			if(rs != null){
				rs.close();
			}
			if(ps != null){
				ps.close();
			}
			if(connection != null){
				connection.close();
			}
		}
	}
	/**
	 * @Title: save 
	 * @Description: TODO(添加用户) 
	 * @param @param user
	 * @param @return
	 * @param @throws SQLException  参数说明 
	 * @return Boolean  返回类型 
	 * @throws
	 */
	public Boolean save(User user) throws SQLException{
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			String sql = "INSERT INTO USER(NAME,PASSWORD,sex,age,email,tel) VALUES(?,?,?,?,?,?)";
			connection = ConnectionUtil.getConnection();
			ps = connection.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			ps.setInt(3, user.getSex());
			ps.setInt(4, user.getAge());
			ps.setString(5,user.getEmail());
			ps.setInt(6,user.getTel());
			int count = ps.executeUpdate();
			return count>0?true:false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			if(ps != null){
				ps.close();
			}
			if(connection != null){
				connection.close();
			}
		}
	}
	/**
	 * @Title: update 
	 * @Description: TODO(修改用户) 
	 * @param @param user
	 * @param @return
	 * @param @throws SQLException  参数说明 
	 * @return Boolean  返回类型 
	 * @throws
	 */
	public Boolean update(User user) throws SQLException{
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			String sql = "UPDATE USER SET NAME=?,PASSWORD=?,sex=?,age=?,email=?,tel=?";
			connection = ConnectionUtil.getConnection();
			ps = connection.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			ps.setInt(3, user.getSex());
			ps.setInt(4, user.getAge());
			ps.setString(5,user.getEmail());
			ps.setInt(6,user.getTel());
			int count = ps.executeUpdate();
			return count>0?true:false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			if(ps != null){
				ps.close();
			}
			if(connection != null){
				connection.close();
			}
		}
	}
	/**
	 * @Title: delete 
	 * @Description: TODO(删除用户) 
	 * @param @param id
	 * @param @return
	 * @param @throws SQLException  参数说明 
	 * @return Boolean  返回类型 
	 * @throws
	 */
	public Boolean delete(Integer id) throws SQLException{
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			String sql = "DELETE FROM USER WHERE id=?";
			connection = ConnectionUtil.getConnection();
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			int count = ps.executeUpdate();
			return count>0?true:false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			if(ps != null){
				ps.close();
			}
			if(connection != null){
				connection.close();
			}
		}
	}
}
