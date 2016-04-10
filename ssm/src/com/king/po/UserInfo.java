package com.king.po;

public class UserInfo {
 @Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", userName=" + userName + ", userSex=" + userSex + "]";
	}
private Integer userId;
 private String userName;
 private String userSex;
public Integer getuserId() {
	return userId;
}
public void setuserId(Integer userId) {
	this.userId = userId;
}
public String getuserName() {
	return userName;
}
public void setuserName(String userName) {
	this.userName = userName;
}
public String getuserSex() {
	return userSex;
}
public void setuserSex(String userSex) {
	this.userSex = userSex;
}
}
