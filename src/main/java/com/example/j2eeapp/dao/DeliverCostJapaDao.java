package com.example.j2eeapp.dao;

import javax.persistence.Query;

import org.springframework.util.Assert;

import com.example.j2eeapp.commons.dao.GenericJpaDao;
import com.example.j2eeapp.domain.DeliverCostEntity;

public class DeliverCostJapaDao extends GenericJpaDao<DeliverCostEntity, Long> implements DeliverCostDao {

	public DeliverCostJapaDao()
	{
		super(DeliverCostEntity.class);
	}

	public boolean checkAvailable(String countryName,String regionName) {
      Assert.notNull(countryName);  // it checks whether the passed variable is empty or not (Assert class is from spring famework)
		
		Query query = getEntityManager()
			.createQuery("select count(*) from " + getPersistentClass().getSimpleName() 
					+ " u where u.countryName = :countryName and u.regionName=:regionName").setParameter("countryName", countryName).setParameter("regionName", regionName);
	
		Long count = (Long) query.getSingleResult();
		
		return count < 1;
	}

	public DeliverCostEntity loadCostByCnamRname(String countryName, String regionName) {
		 Assert.notNull(countryName);  // it checks whether the passed variable is empty or not (Assert class is from spring famework)
		 Assert.notNull(regionName); 
	return (DeliverCostEntity) getEntityManager()
				.createQuery("select u from " + getPersistentClass().getSimpleName() 
						+ " u where u.countryName = :countryName and u.regionName=:regionName").setParameter("countryName", countryName).setParameter("regionName", regionName).getSingleResult();
		
			
	}

}
