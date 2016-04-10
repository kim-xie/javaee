package com.king.mapper;

import java.util.List;

import com.king.po.UserInfo;

public interface UserInfoMapper {
	
	/**����û���Ϣ
	 * @param user �û���Ϣ
	 * @return ���ز���
	 */
	public int addUser(UserInfo user);
	
	/**��ѯ�û���Ϣ
	 * @param user �û���Ϣ
	 * @return ���ز���
	 */
	public List<UserInfo> getUserList(UserInfo user);
	

	/**���ݱ�Ų�ѯ�û���Ϣ
	 * @param user �û���Ϣ
	 * @return ���ز���
	 */
	public UserInfo getUser(Integer userId);
	
	
	/**�޸��û���Ϣ
	 * @param user �û���Ϣ
	 * @return ���ز���
	 */
	public int updateUser(UserInfo user);
	
	/**ɾ���û���Ϣ
	 * @param user �û���Ϣ
	 * @return ���ز���
	 */
	public int deleteUser(Integer userId);
	
}
