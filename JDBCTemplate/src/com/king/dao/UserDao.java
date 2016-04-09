package com.king.dao;

import java.util.List;

import com.king.bean.User;
/**
 * UserDao接口，可插拔性
 * 类名: UserDao.java
 * 创建人: king 
 * 创建时间：2016年4月9日 下午12:22:31 
 * @version 1.0.0
 */
public interface UserDao {
	/**
	 * 接口里默认的方法权限为public 方法中可以不写
	 * @Title: findAll 
	 * @Description: TODO(查询所有方法) 
	 * @param @return  参数说明 
	 * @return List<User>  返回类型 
	 * @throws
	 */
	List<User> findAll();
	/**
	 * @Title: findById 
	 * @Description: TODO(根据id查询方法) 
	 * @param @param id
	 * @param @return  参数说明 
	 * @return User  返回类型 
	 * @throws
	 */
	User findById(Integer id);
	/**
	 * @Title: save 
	 * @Description: TODO(添加方法) 
	 * @param @param user  参数说明 
	 * @return void  返回类型 
	 * @throws
	 */
	void save(User user);
	/**
	 * @Title: update 
	 * @Description: TODO(修改方法) 
	 * @param @param user  参数说明 
	 * @return void  返回类型 
	 * @throws
	 */
	void update(User user);
	/**
	 * @Title: delete 
	 * @Description: TODO(删除方法) 
	 * @param @param id  参数说明 
	 * @return void  返回类型 
	 * @throws
	 */
	void delete(Integer id);
}
