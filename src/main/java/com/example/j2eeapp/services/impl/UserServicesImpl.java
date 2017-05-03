package com.example.j2eeapp.services.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.example.j2eeapp.commons.domain.UserStatus;
import com.example.j2eeapp.dao.UserDao;
import com.example.j2eeapp.dao.UserRoleDao;
import com.example.j2eeapp.domain.UserEntity;
import com.example.j2eeapp.domain.UserRoleEntity;
import com.example.j2eeapp.services.UserService;

@SuppressWarnings("deprecation")
public class UserServicesImpl implements UserService,UserDetailsService {
	
private UserDao userDao;
private UserRoleDao userRoleDao;

public UserServicesImpl(UserDao userDao, UserRoleDao userRoleDao) {
	super();
	this.userDao = userDao;
	this.userRoleDao = userRoleDao;
}


	/**
	 * Create user - persist to database
	 * 
	 * @param userEntity
	 * @return true if success
	 */
	public boolean createUser(UserEntity userEntity) {
		
		if (!userDao.checkAvailable(userEntity.getUserName())) {
			FacesMessage message = constructErrorMessage(String.format("User name '%s' is not available", userEntity.getUserName()), null);
			getFacesContext().addMessage(null, message);
			
			return false;
		}
		
		try {
			List<UserRoleEntity> userRoleEntity= new ArrayList<UserRoleEntity>();
			userRoleEntity.add(userRoleDao.loadRoleByUserName("ROLE_USER"));
			userEntity.setUserRoleEntity(userRoleEntity);
			userDao.save(userEntity);
		} catch(Exception e) {
			FacesMessage message = constructFatalMessage(e.getMessage(), null);
			getFacesContext().addMessage(null, message);
			return false;
		}
		
		return true;
	}
	

	public List<UserEntity> loadAllUsers() {
		return userDao.findAll();
	}
	
	public void deleteUser(UserEntity entity)
	{
			userDao.delete(entity);
	
	}

	
	//public boolean insertRole(UserRoleEntity userroleEntity,String userName)
	//{
	  //UserEntity userEntity =userDao.loadUserByUserName(userName);
	  //userEntity.getUserRoleEntity().add(userroleEntity);
	  //userRoleDao.save(userroleEntity);
	  //return true;
	//}



	/**
	 * Construct UserDetails instance required by spring security
	 */
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		UserEntity user = userDao.loadUserByUserName(userName);
		
		if (user == null) {
			throw new UsernameNotFoundException(String.format("No such name with name Proviede '%s'", userName));
		}
		boolean enabled=user.getUserStatus().equals(UserStatus.ACTIVE);
		boolean accountNonExpired=user.getUserStatus().equals(UserStatus.ACTIVE);
		boolean credentialsNonExpired=user.getUserStatus().equals(UserStatus.ACTIVE);
		boolean accountNonLocked=user.getUserStatus().equals(UserStatus.ACTIVE);
		
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for(UserRoleEntity roles:user.getUserRoleEntity())
		{
			authorities.add(new GrantedAuthorityImpl(roles.getRole_name()));
		}
		
		User userDetails = new User(user.getUserName(), user.getPassword(), enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities) ;
		
		return userDetails;
	}
	
	/**
	 * Retrieves full User record from database by user name
	 * 
	 * @param userName
	 * @return UserEntity
	 */
	public UserEntity loadUserEntityByUsername(String userName) {
		return userDao.loadUserByUserName(userName);
	}

	protected FacesMessage constructErrorMessage(String message, String detail){
		return new FacesMessage(FacesMessage.SEVERITY_ERROR, message, detail);
	}
	
	protected FacesMessage constructInfoMessage(String message, String detail) {
		return new FacesMessage(FacesMessage.SEVERITY_INFO, message, detail);
	}
	
	protected FacesMessage constructFatalMessage(String message, String detail) {
		return new FacesMessage(FacesMessage.SEVERITY_FATAL, message, detail);
	}
	
	protected FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}

	public boolean activateUser(UserEntity user) {
		userDao.setUserActive(user);
		return false;
	}
	
	public UserRoleDao getUserRoleDao() {
		return userRoleDao;
	}

	public void setUserRoleDao(UserRoleDao userRoleDao) {
		this.userRoleDao = userRoleDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
