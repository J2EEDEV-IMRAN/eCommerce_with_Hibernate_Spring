package com.example.j2eeapp.services.impl;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.example.j2eeapp.dao.ProductDao;
import com.example.j2eeapp.dao.SubCategoryDao;
import com.example.j2eeapp.domain.ProductEntity;
import com.example.j2eeapp.domain.SubCategoryEntity;
import com.example.j2eeapp.services.ProductService;



public class ProductServiceImpl implements ProductService {
	

private ProductDao productDao;
private SubCategoryDao subCategoryDao;
public ProductServiceImpl(ProductDao productDao, SubCategoryDao subCategoryDao) {
	super();
	this.productDao = productDao;
	this.subCategoryDao = subCategoryDao;
}

public boolean createProduct(ProductEntity productEntity,String subCatName)
{
  try {
	  SubCategoryEntity subCategoryEntity =subCategoryDao.loadSubcategoryNameBysubCatName(subCatName);
	   productEntity.setSubCategoryEntity(subCategoryEntity);
	   productDao.save(productEntity);
	
}catch(Exception e) {
	FacesMessage message = constructFatalMessage(e.getMessage(), null);
	getFacesContext().addMessage(null, message);
	return false;
}
  return true;
  
}

public List<ProductEntity> loadAllProduct() {
	
  return productDao.findAll(); 
}

public boolean updateProduct(ProductEntity productEntity) {
	try {
		 productDao.update(productEntity);	
		} 
		catch (Exception e) {
			FacesMessage message=constructFatalMessage(e.getMessage(), null);
			getFacesContext().addMessage(null, message);
			return false;
			
		}
	return true;
}

public void deleteProduct(ProductEntity productEntity) {
	productDao.delete(productEntity);
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

public ProductDao getProductDao() {
	return productDao;
}

public void setProductDao(ProductDao productDao) {
	this.productDao = productDao;
}

public SubCategoryDao getSubCategoryDao() {
	return subCategoryDao;
}

public void setSubCategoryDao(SubCategoryDao subCategoryDao) {
	this.subCategoryDao = subCategoryDao;
}

}
