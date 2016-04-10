package com.king.mapper;

import java.util.List;

import com.king.po.UserInfo;

public interface UserInfoMapper {
	
	/**添加用户信息
	 * @param user 用户信息
	 * @return 返回参数
	 */
	public int addUser(UserInfo user);
	
	/**查询用户信息
	 * @param user 用户信息
	 * @return 返回参数
	 */
	public List<UserInfo> getUserList(UserInfo user);
	

	/**根据编号查询用户信息
	 * @param user 用户信息
	 * @return 返回参数
	 */
	public UserInfo getUser(Integer userId);
	
	
	/**修改用户信息
	 * @param user 用户信息
	 * @return 返回参数
	 */
	public int updateUser(UserInfo user);
	
	/**删除用户信息
	 * @param user 用户信息
	 * @return 返回参数
	 */
	public int deleteUser(Integer userId);
	
}
