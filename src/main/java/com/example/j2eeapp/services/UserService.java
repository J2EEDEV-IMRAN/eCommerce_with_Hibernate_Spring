package com.example.j2eeapp.services;



import java.util.List;

import com.example.j2eeapp.domain.UserEntity;

/**
 * Service providing service methods to work with user data and entity.
 * 
 * @author Arthur Vin
 */
public interface UserService {

	/**
	 * Create user - persist to database
	 * 
	 * @param userEntity
	 * @return true if success
	 */
	boolean createUser(UserEntity userEntity);
	List<UserEntity> loadAllUsers();
    boolean activateUser(UserEntity user);
    void deleteUser(UserEntity entity);
    UserEntity loadUserEntityByUsername(String userName);
}

