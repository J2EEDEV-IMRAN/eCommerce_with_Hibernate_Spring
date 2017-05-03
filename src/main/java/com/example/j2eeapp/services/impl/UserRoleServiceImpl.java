package com.example.j2eeapp.services.impl;


import com.example.j2eeapp.dao.UserDao;
import com.example.j2eeapp.dao.UserRoleDao;
import com.example.j2eeapp.services.UserRoleService;


public class UserRoleServiceImpl implements UserRoleService {
	
private UserRoleDao userRoleDao;
private UserDao userDao;

public UserDao getUserDao() {
	return userDao;
}

public void setUserDao(UserDao userDao) {
	this.userDao = userDao;
}



public UserRoleDao getUserRoleDao() {
	return userRoleDao;
}

public void setUserRoleDao(UserRoleDao userRoleDao) {
	this.userRoleDao = userRoleDao;
}


}
