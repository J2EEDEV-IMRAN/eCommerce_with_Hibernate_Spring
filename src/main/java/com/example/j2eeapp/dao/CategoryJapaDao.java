package com.example.j2eeapp.dao;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.util.Assert;

import com.example.j2eeapp.commons.dao.GenericJpaDao;
import com.example.j2eeapp.domain.CategoryEntity;

public class CategoryJapaDao extends GenericJpaDao<CategoryEntity, Long> implements CategoryDao {

	public CategoryJapaDao()
	{
		super(CategoryEntity.class);
	}

	public boolean checkAvailable(String catName) {
	Assert.notNull(catName);  // it checks whether the passed variable is empty or not (Assert class is from spring famework)
		
		Query query = getEntityManager()
			.createQuery("select count(*) from " + getPersistentClass().getSimpleName() 
					+ " u where u.catName = :catName").setParameter("catName", catName);
	
		Long count = (Long) query.getSingleResult();
		
		return count < 1;
	}

	public CategoryEntity loadCategoryByCategoryName(String catName) {
		
           CategoryEntity category = null;
		
		Query query = getEntityManager().createQuery("select u from " + getPersistentClass().getSimpleName()
				+ " u where u.catName = :catName").setParameter("catName", catName);
		
		try {
			category =  (CategoryEntity) query.getSingleResult();
		} catch(NoResultException e) {
			//do nothing
		}
		
		return category;
	}
}
