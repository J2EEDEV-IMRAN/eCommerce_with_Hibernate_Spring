package com.example.j2eeapp.dao;


import com.example.j2eeapp.commons.dao.GenericDao;
import com.example.j2eeapp.domain.ProductEntity;

public interface ProductDao extends GenericDao<ProductEntity, Long>
{

	ProductEntity searchProductByName(String proName);


}
