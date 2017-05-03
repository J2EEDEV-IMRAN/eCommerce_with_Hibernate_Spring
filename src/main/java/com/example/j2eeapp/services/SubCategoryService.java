package com.example.j2eeapp.services;

import java.util.List;

import com.example.j2eeapp.domain.SubCategoryEntity;


public interface SubCategoryService {
 boolean createSubcategory(SubCategoryEntity subCategoryEntity,String catName);
 List<SubCategoryEntity> loadAllSubCategories();
 SubCategoryEntity loadProductBySubCategory(Long subId); 
}

