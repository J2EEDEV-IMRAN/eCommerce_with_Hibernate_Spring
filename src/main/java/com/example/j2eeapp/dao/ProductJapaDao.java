package com.example.j2eeapp.dao;


import com.example.j2eeapp.commons.dao.GenericJpaDao;
import com.example.j2eeapp.domain.ProductEntity;

public class ProductJapaDao extends GenericJpaDao<ProductEntity, Long> implements ProductDao {

	public ProductJapaDao()
	{
		super(ProductEntity.class);
	}

	public ProductEntity searchProductByName(String proName) {
		
		return (ProductEntity) getEntityManager().createQuery("select p from "+getPersistentClass().getSimpleName() +" p where p.proName=:proName").setParameter("proName", proName).getSingleResult();
	}


}
