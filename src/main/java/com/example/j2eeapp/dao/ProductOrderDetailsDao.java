package com.example.j2eeapp.dao;

import java.util.List;

import com.example.j2eeapp.commons.dao.GenericDao;
import com.example.j2eeapp.domain.ProductOrderDetailsEntity;

public interface ProductOrderDetailsDao extends GenericDao<ProductOrderDetailsEntity, Long>
{

	void increaseProductCount(int proQty, Double proPrice, String proName, String userName);

	boolean checkAvaliable(String proName, String userName);

	ProductOrderDetailsEntity findByName(String proName, String userName);

	List<ProductOrderDetailsEntity> loadCartProductByUser(String userName);

	void decreaseProductCount(int proQty, Double proPrice, String proName, String userName);


}
