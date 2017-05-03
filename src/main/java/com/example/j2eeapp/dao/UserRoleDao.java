package com.example.j2eeapp.dao;


import com.example.j2eeapp.commons.dao.GenericDao;
import com.example.j2eeapp.domain.UserRoleEntity;

public interface UserRoleDao extends GenericDao<UserRoleEntity, Long>
{
	UserRoleEntity loadRoleByUserName(String roleName);
}
