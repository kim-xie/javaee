package com.king.dao;

import java.util.List;

import com.king.bean.Content;

public interface ContentMapper {
	//查询所有内容
	List<Content> findAll();
	//根据id查询用户
	Content findById(Integer id);
	//添加用户
	Boolean save(Content content);
	//修改用户
	Boolean update(Content content);
	//根据id删除用户
	Boolean delete(Integer id);
}
