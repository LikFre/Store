package com.ypf.service;

import com.ypf.entity.User;

public interface UserService {
	//用户注册
	void UserRegister(User user);
	//用户激活
	boolean UserActive(String code);
	//用户登录
	User UserLogin(User user);
	//通过用户名查找用户
	String getUserByName(String username);

}
