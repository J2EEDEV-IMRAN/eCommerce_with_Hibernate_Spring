package com.example.j2eeapp.services;

import java.util.List;

import com.example.j2eeapp.domain.CategoryEntity;

/**
 * Service providing service methods to work with user data and entity.
 * 
 * @author Arthur Vin
 */
public interface CategoryService {
	boolean createCategory(CategoryEntity categoryEntity);
	List<CategoryEntity> loadAllCategory();
	boolean updateCategory(CategoryEntity categoryEntity);
	List<CategoryEntity> loadAllSubCategoryByCategory();
  
}

