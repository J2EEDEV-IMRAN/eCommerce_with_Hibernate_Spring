package com.example.j2eeapp.services;

import java.util.List;

import com.example.j2eeapp.domain.WishListEntity;


public interface WishListService {
	
	boolean addToWishList(Long proID, String userName);
	
	List<WishListEntity> showWishListByUserAndStatue(String userName);
	
	boolean addWishListProductToCartByUser(Long wishID,String userName);
	
	void deleteWishListProductByUser(Long wishID);
	
}

