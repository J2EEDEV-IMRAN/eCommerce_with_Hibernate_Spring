package com.example.j2eeapp.domain;


import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.PasswordEncoder;

import com.example.j2eeapp.commons.domain.BaseEntity;
import com.example.j2eeapp.commons.domain.UserStatus;



/**
 * Entity to hold application user data - first name, last name, etc.
 * 
 * @author Arthur Vin
 */
@Entity
@Table(name="users")
public class UserEntity extends BaseEntity {
	private static final long serialVersionUID = -8789920463809744548L;

	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String email;
	private Date regDate;
	private String contact_no;
	@Enumerated(EnumType.STRING)
	private UserStatus userStatus;
	

	@ManyToMany( cascade =CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name="userrole",joinColumns=@JoinColumn(name="user_id"),inverseJoinColumns=@JoinColumn(name="role_id"))
	private List<UserRoleEntity> userRoleEntity;
	
	public UserEntity(){}

	public UserEntity(String firstName, String lastName, String userName,
			String password, String email, Date regDate, String contact_no,
			UserStatus userStatus, List<UserRoleEntity> userRoleEntity) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.regDate = regDate;
		this.contact_no = contact_no;
		this.userStatus = userStatus;
		this.userRoleEntity = userRoleEntity;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		PasswordEncoder crypto = new Md5PasswordEncoder();
		this.password = crypto.encodePassword(password, null);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getContact_no() {
		return contact_no;
	}

	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}

	public List<UserRoleEntity> getUserRoleEntity() {
		return userRoleEntity;
	}

	public void setUserRoleEntity(List<UserRoleEntity> userRoleEntity) {
		this.userRoleEntity = userRoleEntity;
	}

	public UserStatus getUserStatus() {
		return userStatus;
	}
	
	@SuppressWarnings("static-access")
	public void setUserStatus(UserStatus userStatus) {
		this.userStatus = userStatus.INACTIVE;
	}
	
	
}
