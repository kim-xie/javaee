package com.king.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.king.bean.User;
/**
 * 持久层
 * 类名: UserDaoImpl.java
 * 创建人: king 
 * 创建时间：2016年4月9日 下午12:19:04 
 * @version 1.0.0
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao{
	/**
	 * 注入jdbcTemplate
	 */
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 依赖的RowMapper类
	 * 类名: UserDaoImpl.java
	 * 创建人: king 
	 * 创建时间：2016年4月9日 下午12:21:48 
	 * @version 1.0.0
	 */
	class UserRowMapper implements RowMapper<User>{
		@Override
		public User mapRow(ResultSet rs, int index) throws SQLException {
			User user = new User();
			user.setName(rs.getString("name"));
			user.setPassword(rs.getString("password"));
			return user;
		}
	}
	/**
	 * 查找全部
	 */
	@Override
	public List<User> findAll() {
		String sql = "select * from user";
		return jdbcTemplate.query(sql, new UserRowMapper());
	}
	/**
	 * 根据id查找
	 */
	@Override
	public User findById(Integer id) {
		String sql="select * from user where id=?";
		return jdbcTemplate.queryForObject(sql,new Object[]{id},new UserRowMapper());
	}
	/**
	 * 添加
	 */
	@Override
	public void save(User user) {
		String sql="INSERT INTO USER(name,password) VALUES(?,?)";
		Object[] param={user.getName(),user.getPassword()};
		jdbcTemplate.update(sql, param);
		
	}
	/**
	 * 修改
	 */
	@Override
	public void update(User user) {
		String sql="update user set name=?,password=? where id=?";
		// 注意，按次序 输入值
		Object[] param={user.getName(),user.getPassword(),user.getId()};
		jdbcTemplate.update(sql,param);
	}
	/**
	 * 删除
	 */
	@Override
	public void delete(Integer id) {
		String sql="delete from user where id=?";
		jdbcTemplate.update(sql,id);
	}

}
