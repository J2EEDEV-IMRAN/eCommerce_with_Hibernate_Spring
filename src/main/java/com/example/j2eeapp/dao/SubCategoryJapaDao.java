package com.example.j2eeapp.dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.springframework.util.Assert;
import com.example.j2eeapp.commons.dao.GenericJpaDao;
import com.example.j2eeapp.domain.SubCategoryEntity;

public class SubCategoryJapaDao extends GenericJpaDao<SubCategoryEntity, Long> implements SubCategoryDao {

	public SubCategoryJapaDao()
	{
		super(SubCategoryEntity.class);
	}
	
	public boolean checkAvailable(String subCatName) {
		Assert.notNull(subCatName);  // it checks whether the passed variable is empty or not (Assert class is from spring famework)
			
			Query query = getEntityManager()
				.createQuery("select count(*) from " + getPersistentClass().getSimpleName() 
						+ " u where u.subCatName = :subCatName").setParameter("subCatName", subCatName);
		
			Long count = (Long) query.getSingleResult();
			
			return count < 1;
		}

	public SubCategoryEntity loadSubcategoryNameBysubCatName(String subCatName) {
		Assert.notNull(subCatName);
		
	       SubCategoryEntity subcategory = null;
			
			Query query = getEntityManager().createQuery("select u from " + getPersistentClass().getSimpleName()
					+ " u where u.subCatName = :subCatName").setParameter("subCatName", subCatName);
			
			try {
				 subcategory= (SubCategoryEntity) query.getSingleResult();
			} catch(NoResultException e) {
				//do nothing
			}
			
			return subcategory;
	}

}
