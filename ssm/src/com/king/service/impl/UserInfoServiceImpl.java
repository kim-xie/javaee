package com.king.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.king.mapper.UserInfoMapper;
import com.king.po.UserInfo;
import com.king.service.UserInfoService;
@Service
public class UserInfoServiceImpl implements UserInfoService {
   
	@Resource(name="userInfoMapper")
	private UserInfoMapper userInfoMapper;
	public void setUserInfoMapper(UserInfoMapper userInfoMapper) {
		this.userInfoMapper = userInfoMapper;
	}
	@Override
	public boolean addUser(UserInfo user) {
		int count = userInfoMapper.addUser(user);
		return count>0?true:false;
	}
	
	@Override
	public List<UserInfo> getUserList(UserInfo user) {
		if(user != null && user.getuserName()!=null && !user.getuserName().equals("")){
			user.setuserName("%"+user.getuserName()+"%");
		}
		return userInfoMapper.getUserList(user);
	}
	
	@Override
	public boolean updateUser(UserInfo user) {
		int count = userInfoMapper.updateUser(user);
		return count>0?true:false;
		
	}
	@Override
	public UserInfo getUser(Integer userId) {
		if(userId != null){
			return userInfoMapper.getUser(userId);
		}
		return null;
	}
	@Override
	public boolean deleteUser(Integer userId) {
		int count = userInfoMapper.deleteUser(userId);
		return count>0?true:false;
	}

}
