package com.king.service;

import java.util.List;

import com.king.po.UserInfo;

/**
 * @author mr-king
 *
 */
public interface UserInfoService {
	
	public boolean addUser(UserInfo user);
	
	/**���ݱ�Ų�ѯ�û���Ϣ
	 * @param user �û���Ϣ
	 * @return ���ز���
	 */
	public UserInfo getUser(Integer userId);
	
	
	/**�޸��û���Ϣ
	 * @param user �û���Ϣ
	 * @return ���ز���
	 */
	public boolean updateUser(UserInfo user);
	
	/**��ѯ�û���Ϣ
	 * @param user �û���Ϣ
	 * @return ���ز���
	 */
	public List<UserInfo> getUserList(UserInfo user);
	
	/**ɾ���û���Ϣ
	 * @param user �û���Ϣ
	 * @return ���ز���
	 */
	public boolean deleteUser(Integer userId);
}
