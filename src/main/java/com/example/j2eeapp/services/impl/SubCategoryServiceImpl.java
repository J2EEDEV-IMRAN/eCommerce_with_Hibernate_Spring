package com.example.j2eeapp.services.impl;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.transaction.annotation.Transactional;

import com.example.j2eeapp.dao.CategoryDao;
import com.example.j2eeapp.dao.SubCategoryDao;
import com.example.j2eeapp.domain.CategoryEntity;
import com.example.j2eeapp.domain.ProductEntity;
import com.example.j2eeapp.domain.SubCategoryEntity;
import com.example.j2eeapp.services.SubCategoryService;


public class SubCategoryServiceImpl implements SubCategoryService  {
	
private SubCategoryDao subCategoryDao;
private CategoryDao categoryDao;



public SubCategoryServiceImpl(SubCategoryDao subCategoryDao,
		CategoryDao categoryDao) {
	super();
	this.subCategoryDao = subCategoryDao;
	this.categoryDao = categoryDao;
}

@Transactional
public boolean createSubcategory(SubCategoryEntity subCategoryEntity,String catName)
{
	if (!subCategoryDao .checkAvailable(subCategoryEntity.getSubCatName())) {
		FacesMessage message = constructErrorMessage(String.format("Sub-category name '%s' is not available", subCategoryEntity.getSubCatName()), null);
		getFacesContext().addMessage(null, message);
		
		return false;
	}
	
	try {
		CategoryEntity categoryEntity = categoryDao.loadCategoryByCategoryName(catName);
		subCategoryEntity.setCategoryEntity(categoryEntity);
		subCategoryDao.save(subCategoryEntity);
	} catch(Exception e) {
		FacesMessage message = constructFatalMessage(e.getMessage(), null);
		getFacesContext().addMessage(null, message);
		return false;
	}
	
	return true;
}

public void deleteSubCategory(SubCategoryEntity subCategoryEntity)
{
	subCategoryDao.delete(subCategoryEntity);
	
	
}
@Transactional
public boolean updateSubcategory(SubCategoryEntity subCategoryEntity)
{
	try {
		subCategoryDao.update(subCategoryEntity);
		} 
		catch (Exception e) {
			FacesMessage message=constructFatalMessage(e.getMessage(), null);
			getFacesContext().addMessage(null, message);
			return false;
			
		}
	return true;
}

public List<SubCategoryEntity> loadAllSubCategories()
{
 List<SubCategoryEntity> subcategories= subCategoryDao.findAll();
 return subcategories;
}

public SubCategoryEntity loadProductBySubCategory(Long subId){
	   SubCategoryEntity subCategoryEntity=subCategoryDao.findById(subId);
	    System.out.println(subId);
		List<ProductEntity> products=subCategoryEntity.getProductEntity();
		subCategoryEntity.setProductEntity(products);
        if(products.size()>0)
        {
		return subCategoryEntity;
        }
        else
        {
        	return null;
        }
}

/**
 * public List<SubCategoryEntity> loadAllProductBySubcategory()
{
	List<SubCategoryEntity> subcategories = subCategoryDao.findAll();
	for(SubCategoryEntity subcategory : subcategories)
	{
			List<ProductEntity> products=subcategory.getProductEntity();
          	subcategory.setProductEntity(products);    
	}
	return subcategories;
}

 * @return
 */


public CategoryDao getCategoryDao() {
	return categoryDao;
}
public void setCategoryDao(CategoryDao categoryDao) {
	this.categoryDao = categoryDao;
}


protected FacesMessage constructErrorMessage(String message, String detail){
	return new FacesMessage(FacesMessage.SEVERITY_ERROR, message, detail);
}

protected FacesMessage constructInfoMessage(String message, String detail) {
	return new FacesMessage(FacesMessage.SEVERITY_INFO, message, detail);
}

protected FacesMessage constructFatalMessage(String message, String detail) {
	return new FacesMessage(FacesMessage.SEVERITY_FATAL, message, detail);
}

protected FacesContext getFacesContext() {
	return FacesContext.getCurrentInstance();
}


public SubCategoryDao getSubCategoryDao() {
	return subCategoryDao;
}

public void setSubCategoryDao(SubCategoryDao subCategoryDao) {
	this.subCategoryDao = subCategoryDao;
}



}
