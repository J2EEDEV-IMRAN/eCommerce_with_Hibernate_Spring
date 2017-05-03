package com.example.j2eeapp.dao;


import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.springframework.util.Assert;
import com.example.j2eeapp.commons.dao.GenericJpaDao;
import com.example.j2eeapp.domain.UserRoleEntity;

public class UserRoleJapaDao extends GenericJpaDao<UserRoleEntity, Long> implements UserRoleDao {

	public UserRoleJapaDao()
	{
		super(UserRoleEntity.class);
	}


	public UserRoleEntity loadRoleByUserName(String roleName) {
	Assert.notNull(roleName);
		
		UserRoleEntity role = null;
		
		Query query = getEntityManager().createQuery("select u from " + getPersistentClass().getSimpleName()
				+ " u where u.role_name = :roleName").setParameter("roleName", roleName);
		
		try {
			role = (UserRoleEntity) query.getSingleResult();
		} catch(NoResultException e) {
			//do nothing
		}
		
		return role;
	}

}
