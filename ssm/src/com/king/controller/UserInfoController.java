package com.king.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.king.po.UserInfo;
import com.king.service.UserInfoService;
@Controller
public class UserInfoController {
	
	@Resource(name="userInfoServiceImpl")
	private UserInfoService userInfoService;
	
	@RequestMapping("/addUser.do")
	public String addUser(UserInfo user,Model model){
		
		System.out.println("user"+user);
		boolean mark = false;
		try {
			userInfoService.addUser(user);
		} catch (Exception e) {
		    e.printStackTrace();
		}
		if(!mark){
			model.addAttribute("info","用户信息添加成功");
		}else{
			model.addAttribute("info","用户信息添加失败");
		}
		return "userinfo/user_info";
	}
	
	@RequestMapping("/userList.do")
	public String userList(UserInfo user,Model model){
		try {
			List<UserInfo> list = userInfoService.getUserList(user);
			model.addAttribute("list",list);
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return "userinfo/user_list";
	}
	
	@RequestMapping("/loadUpdate.do")
	public String loadUpdate(Integer userId,Model model){
		try {
			UserInfo user = userInfoService.getUser(userId);
			model.addAttribute("user",user);
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return "userinfo/user_update";
	}
	
	@RequestMapping("/updateUser.do")
	public String updateUser(UserInfo user,Model model){
		
		System.out.println("user"+user);
		boolean mark = false;
		try {
			userInfoService.updateUser(user);
		} catch (Exception e) {
		    e.printStackTrace();
		}
		if(!mark){
			model.addAttribute("info","用户信息修改成功");
		}else{
			model.addAttribute("info","用户信息修改失败");
		}
		return "userinfo/user_info";
	}
	
	@RequestMapping("/deleteUser.do")
	public String deleteUser(Integer userId,Model model){
		
		boolean mark = false;
		try {
			userInfoService.deleteUser(userId);
		} catch (Exception e) {
		    e.printStackTrace();
		}
		if(!mark){
			model.addAttribute("info","用户信息删除成功");
		}else{
			model.addAttribute("info","用户信息删除失败");
		}
		return "userinfo/user_info";
		
	}
}
