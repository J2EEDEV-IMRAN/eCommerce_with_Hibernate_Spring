package com.example.j2eeapp.dao;

import com.example.j2eeapp.commons.dao.GenericDao;
import com.example.j2eeapp.domain.SubCategoryEntity;

public interface SubCategoryDao extends GenericDao<SubCategoryEntity, Long>
{
	boolean checkAvailable(String subCatName);

	SubCategoryEntity loadSubcategoryNameBysubCatName(String subCatName);
}
