package com.example.j2eeapp.dao;

import com.example.j2eeapp.commons.dao.GenericDao;
import com.example.j2eeapp.domain.CategoryEntity;

public interface CategoryDao extends GenericDao<CategoryEntity, Long>
{

	boolean checkAvailable(String catName);

	CategoryEntity loadCategoryByCategoryName(String catName);

}
