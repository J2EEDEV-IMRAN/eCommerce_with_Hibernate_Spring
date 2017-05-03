package com.example.j2eeapp.services;

import java.util.List;


import com.example.j2eeapp.domain.ProductEntity;


/**
 * Service providing service methods to work with user data and entity.
 * 
 * @author Arthur Vin
 */
public interface ProductService {
	boolean createProduct(ProductEntity productEntity,String subCatName);
	List<ProductEntity> loadAllProduct();
	void deleteProduct(ProductEntity productEntity);
	boolean updateProduct(ProductEntity productEntity);
	
}

