package com.ypf.service.impl;

import javax.annotation.Resource;
import javax.management.RuntimeErrorException;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.ypf.entity.User;
import com.ypf.mapper.UserMapper;
import com.ypf.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Resource
	private UserMapper userMapper;
	public void UserRegister(User user) {
		userMapper.UserRegister(user);
	}
	public boolean UserActive(String code) {//根据激活码去查找用户
		User user=userMapper.UserActive(code);
		if(user==null) {
			return false;
		}
		userMapper.UpdateState(code);
		return true;
	}
	public User UserLogin(User user) {
		User user1=userMapper.UserLogin(user);
		
		if(null==user1) {
			throw new RuntimeException("密码有误");
		}/*else if(user1.getState()==0) {
			throw new RuntimeException("用户未激活");
		}*/else {
			return user1;
		}	
	}
	public String getUserByName(String username) {//通过用户名查询用户是否存在
		User user=userMapper.getUserByName(username);
		if(null==user)
			return "false";
		return "true";
	}
}
