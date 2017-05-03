package com.example.j2eeapp.dao;

import java.util.List;

import javax.persistence.Query;







import org.springframework.util.Assert;

import com.example.j2eeapp.commons.dao.GenericJpaDao;
import com.example.j2eeapp.domain.ProductOrderDetailsEntity;

public class ProductOrderDetailsJapaDao extends GenericJpaDao<ProductOrderDetailsEntity, Long> implements ProductOrderDetailsDao {

	public ProductOrderDetailsJapaDao()
	{
		super(ProductOrderDetailsEntity.class);
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

	public void increaseProductCount(int proQty,Double proPrice, String proName, String userName) {
		Assert.notNull(proQty);
		Query query= getEntityManager().createQuery("update "+ getPersistentClass().getSimpleName() 
				+" u set u.proQty=:proQty,u.totalPrice=:totalPrice where u.proName=:proName and u.userName=:userName").setParameter("proQty", proQty)
				.setParameter("totalPrice", proPrice).setParameter("proName", proName).setParameter("userName", userName);
		
		query.executeUpdate();
		
	}
	public void decreaseProductCount(int proQty, Double proPrice,
			String proName, String userName) {
		Assert.notNull(proQty);
		Query query= getEntityManager().createQuery("update "+ getPersistentClass().getSimpleName() 
				+" u set u.proQty=:proQty,u.totalPrice=:totalPrice where u.proName=:proName and u.userName=:userName").setParameter("proQty", proQty)
				.setParameter("totalPrice", proPrice).setParameter("proName", proName).setParameter("userName", userName);
		
		query.executeUpdate();
		
	}

	public ProductOrderDetailsEntity findByName(String proName,String userName) {
        Assert.notNull(proName);  // it checks whether the passed variable is empty or not (Assert class is from spring famework)
		
		return (ProductOrderDetailsEntity)getEntityManager()
			.createQuery("select p from " + getPersistentClass().getSimpleName() 
					+ " p where p.proName = :proName and p.userName=:userName").setParameter("proName", proName)
					.setParameter("userName", userName).getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public List<ProductOrderDetailsEntity> loadCartProductByUser(String userName) {
		
		 Assert.notNull(userName);  // it checks whether the passed variable is empty or not (Assert class is from spring famework)
		String orderStatus = "NOTDELIVERED";
			return (List<ProductOrderDetailsEntity>) getEntityManager()
				.createQuery("select p from " + getPersistentClass().getSimpleName() 
						+ " p where p.orderStatus = :orderStatus and p.userName=:userName").setParameter("orderStatus", orderStatus)
						.setParameter("userName", userName).getResultList();
	}
	

}
