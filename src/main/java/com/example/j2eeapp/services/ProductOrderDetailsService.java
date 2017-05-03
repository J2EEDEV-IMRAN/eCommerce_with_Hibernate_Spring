package com.example.j2eeapp.services;

import java.util.List;

import javax.faces.model.SelectItem;

import com.example.j2eeapp.domain.ProductOrderDetailsEntity;


public interface ProductOrderDetailsService {
	
	boolean addToOrder(Long proID, String userName);
	
	List<ProductOrderDetailsEntity> showcartByUserAndStatue(String userName);
	
	boolean increaseProductCountTotal(String proName,String userName);
	boolean decreaseProductCountTotal(String proName,String userName);
	
	List<SelectItem> loaCountry();
	List<SelectItem> loaRegion();
	
	Double loaCartSubTotal(String userName);
	Double loaTotal(Double dcost,String name);
}

