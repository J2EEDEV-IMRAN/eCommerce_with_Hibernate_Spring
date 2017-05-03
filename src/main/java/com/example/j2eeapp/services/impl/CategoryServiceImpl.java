package com.example.j2eeapp.services.impl;


import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.example.j2eeapp.dao.CategoryDao;
import com.example.j2eeapp.domain.CategoryEntity;
import com.example.j2eeapp.domain.SubCategoryEntity;
import com.example.j2eeapp.services.CategoryService;



public class CategoryServiceImpl implements CategoryService {
	
private CategoryDao categoryDao;

public boolean createCategory(CategoryEntity categoryEntity)
{
	if(!categoryDao.checkAvailable(categoryEntity.getCatName()))
	{
		  FacesMessage message=constructErrorMessage(String.format("Course '%s' is not available", categoryEntity.getCatName()), null);
		   getFacesContext().addMessage(null, message);
		   return false;
	}
	try {
		categoryDao.save(categoryEntity);
	} catch (Exception e) {
		return false;
	}
	return true;
}

public List<CategoryEntity> loadAllCategory() {
	return categoryDao.findAll();
}

public boolean updateCategory(CategoryEntity categoryEntity) {

try {
	categoryDao.update(categoryEntity);	
	} 
	catch (Exception e) {
		FacesMessage message=constructFatalMessage(e.getMessage(), null);
		getFacesContext().addMessage(null, message);
		return false;
		
	}
return true;
}

public List<CategoryEntity> loadAllSubCategoryByCategory()
{
 List<CategoryEntity> categoryEntities=categoryDao.findAll();
 for (CategoryEntity categoryEntity:categoryEntities) 
 {
	List<SubCategoryEntity> subCat=categoryEntity.getSubcategoryEntity();
    categoryEntity.setSubcategoryEntity(subCat);	
 }
 return categoryEntities;
}



protected FacesMessage constructInfoMessage(String message,String detail)
	{
		return new FacesMessage(FacesMessage.SEVERITY_INFO,message,detail);
	}
 protected FacesMessage constructFatalMessage(String message,String detail)
	{
		return new FacesMessage(FacesMessage.SEVERITY_FATAL,message,detail);
	}
  protected FacesMessage constructErrorMessage(String message,String detail)
	{
		return new FacesMessage(FacesMessage.SEVERITY_ERROR,message,detail);
	}
	
	FacesContext getFacesContext()
	{
	 return	FacesContext.getCurrentInstance();
	}
	
public CategoryDao getCategoryDao() {
	return categoryDao;
}

public void setCategoryDao(CategoryDao categoryDao) {
	this.categoryDao = categoryDao;
}



}
