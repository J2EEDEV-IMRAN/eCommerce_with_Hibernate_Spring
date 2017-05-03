package com.example.j2eeapp.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.util.Assert;

import com.example.j2eeapp.commons.dao.GenericJpaDao;
import com.example.j2eeapp.domain.WishListEntity;

public class WishListJapaDao extends GenericJpaDao<WishListEntity, Long> implements WishListDao {

	public WishListJapaDao()
	{
		super(WishListEntity.class);
	}

	public boolean checkAvaliable(String proName, String userName) {
	Assert.notNull(proName);  // it checks whether the passed variable is empty or not (Assert class is from spring famework)
		
		Query query = getEntityManager()
			.createQuery("select count(*) from " + getPersistentClass().getSimpleName() 
					+ " u where u.proName = :proName and u.userName=:userName").setParameter("proName", proName)
					.setParameter("userName", userName);
	
		Long count = (Long) query.getSingleResult();
		
		return count < 1;
	}

	@SuppressWarnings("unchecked")
	public List<WishListEntity> loadWishListProductByUser(String userName) {
		
		 Assert.notNull(userName);  // it checks whether the passed variable is empty or not (Assert class is from spring
			return (List<WishListEntity>) getEntityManager()
				.createQuery("select p from " + getPersistentClass().getSimpleName() 
						+ " p where p.userName=:userName")
						.setParameter("userName", userName).getResultList();
	}
	

}
