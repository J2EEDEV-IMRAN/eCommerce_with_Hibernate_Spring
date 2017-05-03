package com.example.j2eeapp.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.springframework.transaction.annotation.Transactional;

import com.example.j2eeapp.dao.DeliverCostDao;
import com.example.j2eeapp.dao.ProductDao;
import com.example.j2eeapp.dao.ProductOrderDetailsDao;
import com.example.j2eeapp.dao.UserDao;
import com.example.j2eeapp.domain.DeliverCostEntity;
import com.example.j2eeapp.domain.ProductEntity;
import com.example.j2eeapp.domain.ProductOrderDetailsEntity;
import com.example.j2eeapp.domain.UserEntity;
import com.example.j2eeapp.services.ProductOrderDetailsService;


public class ProductOrderDetailsServiceImpl implements ProductOrderDetailsService {
	
private ProductOrderDetailsDao productOrderDetailsDao;
private UserDao userDao;
private ProductDao productDao;
private DeliverCostDao deliverCostDao;

public ProductOrderDetailsServiceImpl()
{
	
}

public ProductOrderDetailsServiceImpl(
		ProductOrderDetailsDao productOrderDetailsDao, UserDao userDao,
		ProductDao productDao,DeliverCostDao deliverCostDao) {
	super();
	this.productOrderDetailsDao = productOrderDetailsDao;
	this.userDao = userDao;
	this.productDao = productDao;
	this.deliverCostDao=deliverCostDao;
}

public UserDao getUserDao() {
	return userDao;
}

public void setUserDao(UserDao userDao) {
	this.userDao = userDao;
}

public ProductDao getProductDao() {
	return productDao;
}

public void setProductDao(ProductDao productDao) {
	this.productDao = productDao;
}

public ProductOrderDetailsDao getProductOrderDetailsDao() {
	return productOrderDetailsDao;
}

public void setProductOrderDetailsDao(
		ProductOrderDetailsDao productOrderDetailsDao) {
	this.productOrderDetailsDao = productOrderDetailsDao;
}


public DeliverCostDao getDeliverCostDao() {
	return deliverCostDao;
}

public void setDeliverCostDao(DeliverCostDao deliverCostDao) {
	this.deliverCostDao = deliverCostDao;
}
@Transactional
public List<SelectItem> loaCountry() {
	  List<DeliverCostEntity> costEntities=deliverCostDao.findAll();
	  List<SelectItem> country =new ArrayList<SelectItem>();
	  for (DeliverCostEntity costEntity:costEntities) 
	  {
		  country.add(new SelectItem(new String(costEntity.getCountryName())));
	  }
	return country;
}
@Transactional
public List<SelectItem> loaRegion() {
	  List<DeliverCostEntity> costEntities=deliverCostDao.findAll();
	  List<SelectItem> region =new ArrayList<SelectItem>();
	  for (DeliverCostEntity costEntity:costEntities) 
	  {
		  region.add(new SelectItem(new String(costEntity.getRegionName())));
		 
	  }
	return region;
}

@Transactional
public boolean addToOrder(Long proID, String userName) {
	ProductOrderDetailsEntity productOrderDetailsEntity=new ProductOrderDetailsEntity();
	ProductEntity productEntity =productDao.findById(proID);
	UserEntity userEntity=userDao.loadUserByUserName(userName);
	String productName=productEntity.getProName();
	if(productOrderDetailsDao.checkAvaliable(productName,userEntity.getUserName()))
	{
		productOrderDetailsEntity.setProName(productName);
		productOrderDetailsEntity.setProQty(1);
		productOrderDetailsEntity.setTotalPrice(productEntity.getProPrice());
		productOrderDetailsEntity.setOrderStatus("NOTDELIVERED");
		productOrderDetailsEntity.setProductEntity(productEntity);
		productOrderDetailsEntity.setUserName(userEntity.getUserName());
		productOrderDetailsEntity.setUserEntity(userEntity);
		productOrderDetailsDao.save(productOrderDetailsEntity);
	}
	else
	{
	  ProductOrderDetailsEntity productOrderDetailsEntity1=new ProductOrderDetailsEntity();
	  productOrderDetailsEntity1=searchProductByName(productName,userEntity.getUserName());
	  productOrderDetailsDao.increaseProductCount(productOrderDetailsEntity1.getProQty()+1,productEntity.getProPrice()*(productOrderDetailsEntity1.getProQty()+1),productEntity.getProName(),userEntity.getUserName());	
	}
	return true;
}

@Transactional
public boolean increaseProductCountTotal(String proName, String userName) {
	
	 ProductOrderDetailsEntity productOrderDetailsEntity1=new ProductOrderDetailsEntity();
		  ProductEntity productEntity=new ProductEntity();
		  productEntity=productDao.searchProductByName(proName);
		  productOrderDetailsEntity1=searchProductByName(proName,userName);
		  System.out.println(proName+userName);
		  if(productOrderDetailsEntity1.getProQty()>=1)
		  {
			  productOrderDetailsDao.increaseProductCount(productOrderDetailsEntity1.getProQty()+1,productEntity.getProPrice()*(productOrderDetailsEntity1.getProQty()+1),proName,userName);	
		  }
		 else
		  {
			  //do Nothing
		  }
	return true;
	
	
}

@Transactional
public boolean decreaseProductCountTotal(String proName, String userName) {
	
		ProductOrderDetailsEntity productOrderDetailsEntity1=new ProductOrderDetailsEntity();
		  ProductEntity productEntity=new ProductEntity();
		  productEntity=productDao.searchProductByName(proName);
		  productOrderDetailsEntity1=searchProductByName(proName,userName);
		  System.out.println(userName);
		  System.out.println();
		  if(productOrderDetailsEntity1.getProQty()>1)
		  {
			  productOrderDetailsDao.decreaseProductCount(productOrderDetailsEntity1.getProQty()-1,productEntity.getProPrice()*(productOrderDetailsEntity1.getProQty()-1),proName,userName); 
		  }
		  else
		  {
			  //do Nothing
		  }
		
	
	return true;
}


public ProductOrderDetailsEntity searchProductByName(String proName,String userName)
{
	return productOrderDetailsDao.findByName(proName,userName);
	
}

public List<ProductOrderDetailsEntity> showcartByUserAndStatue(String userName) {
	
	return productOrderDetailsDao.loadCartProductByUser(userName); 
}

@Transactional
public Double loaCartSubTotal(String userName) {
	List<ProductOrderDetailsEntity> productOrderDetailsEntities=productOrderDetailsDao.loadCartProductByUser(userName);
	Double cartSubTotal = 0.0;
	for(ProductOrderDetailsEntity productOrderDetailsEntity:productOrderDetailsEntities)
	{
		cartSubTotal=cartSubTotal+productOrderDetailsEntity.getTotalPrice();
	}
	return cartSubTotal;
}

@Transactional
public Double loaTotal(Double dcost,String name) {
	Double cartTotal=loaCartSubTotal(name);
	Double total=cartTotal+2+dcost;
	return total;
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

}
