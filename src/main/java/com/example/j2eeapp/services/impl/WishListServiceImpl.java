package com.example.j2eeapp.services.impl;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.transaction.annotation.Transactional;

import com.example.j2eeapp.dao.ProductDao;
import com.example.j2eeapp.dao.ProductOrderDetailsDao;
import com.example.j2eeapp.dao.UserDao;
import com.example.j2eeapp.dao.WishListDao;
import com.example.j2eeapp.domain.ProductEntity;
import com.example.j2eeapp.domain.ProductOrderDetailsEntity;
import com.example.j2eeapp.domain.UserEntity;
import com.example.j2eeapp.domain.WishListEntity;
import com.example.j2eeapp.services.WishListService;


public class WishListServiceImpl implements WishListService {
	
private WishListDao wishListDao;
 private UserDao userDao;
private ProductDao productDao;
private ProductOrderDetailsDao productOrderDetailsDao;

public WishListServiceImpl()
{
	
}
public WishListServiceImpl(WishListDao wishListDao, UserDao userDao,
		ProductDao productDao,ProductOrderDetailsDao productOrderDetailsDao) {
	super();
	this.wishListDao = wishListDao;
	this.userDao = userDao;
	this.productDao = productDao;
	this.productOrderDetailsDao=productOrderDetailsDao;
}



public WishListDao getWishListDao() {
	return wishListDao;
}
public void setWishListDao(WishListDao wishListDao) {
	this.wishListDao = wishListDao;
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
@Transactional
public boolean addToWishList(Long proID, String userName) {
    WishListEntity wishListEntity =new WishListEntity();
	ProductEntity productEntity =productDao.findById(proID);
	UserEntity userEntity=userDao.loadUserByUserName(userName);
	String productName=productEntity.getProName();
	if(wishListDao.checkAvaliable(productName,userEntity.getUserName()))
	{
		wishListEntity.setProName(productName);
		wishListEntity.setProQty(productEntity.getProQty());
		wishListEntity.setProPrice(productEntity.getProPrice());
		wishListEntity.setProDesc(productEntity.getProDesc());
	    wishListEntity.setProductEntity(productEntity);
		wishListEntity.setUserName(userEntity.getUserName());
		wishListEntity.setUserEntity(userEntity);
		wishListDao.save(wishListEntity);
	}
	else
	{
	  //do nothing
	}
	return true;
}

public List<WishListEntity> showWishListByUserAndStatue(String userName) {
	
	return wishListDao.loadWishListProductByUser(userName); 
}

@Transactional
public boolean addWishListProductToCartByUser(Long wishID, String userName) {
	ProductOrderDetailsEntity productOrderDetailsEntity=new ProductOrderDetailsEntity();
	WishListEntity wishListEntity=wishListDao.findById(wishID);
	String productName=wishListEntity.getProName();
	ProductEntity productEntity =productDao.searchProductByName(productName);
	UserEntity userEntity=userDao.loadUserByUserName(userName);
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
		wishListDao.delete(wishListEntity);	
	}
	else
	{
	  wishListDao.delete(wishListEntity);	
	}
	return true;
}

@Transactional
public void deleteWishListProductByUser(Long wishID) {
	
	WishListEntity wishListEntity=wishListDao.findById(wishID);
	wishListDao.delete(wishListEntity);
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
