package com.example.j2eeapp.domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.example.j2eeapp.commons.domain.BaseEntity;
@Entity
@Table(name="user_role")
public class UserRoleEntity extends BaseEntity 
{
 /**
	 * 
	 */
private static final long serialVersionUID = -3685608710129353769L;
private String role_name;
 @ManyToMany(mappedBy="userRoleEntity")
 private List<UserEntity> userEntity;

public String getRole_name() {
	return role_name;
}

public void setRole_name(String role_name) {
	this.role_name = role_name;
}

public List<UserEntity> getUserEntity() {
	return userEntity;
}

public void setUserEntity(List<UserEntity> userEntity) {
	this.userEntity = userEntity;
}

}
