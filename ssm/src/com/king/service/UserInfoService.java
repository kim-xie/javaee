package com.king.service;

import java.util.List;

import com.king.po.UserInfo;

/**
 * @author mr-king
 *
 */
public interface UserInfoService {
	
	public boolean addUser(UserInfo user);
	
	/**根据编号查询用户信息
	 * @param user 用户信息
	 * @return 返回参数
	 */
	public UserInfo getUser(Integer userId);
	
	
	/**修改用户信息
	 * @param user 用户信息
	 * @return 返回参数
	 */
	public boolean updateUser(UserInfo user);
	
	/**查询用户信息
	 * @param user 用户信息
	 * @return 返回参数
	 */
	public List<UserInfo> getUserList(UserInfo user);
	
	/**删除用户信息
	 * @param user 用户信息
	 * @return 返回参数
	 */
	public boolean deleteUser(Integer userId);
}
