package com.ypf.mapper;

import com.ypf.entity.User;

public interface UserMapper {

	void UserRegister(User user);

	User UserActive(String code);

	void UpdateState(String code);

	User UserLogin(User user);

	User getUserByName(String username);

}
