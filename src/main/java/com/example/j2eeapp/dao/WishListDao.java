package com.example.j2eeapp.dao;

import java.util.List;

import com.example.j2eeapp.commons.dao.GenericDao;
import com.example.j2eeapp.domain.WishListEntity;

public interface WishListDao extends GenericDao<WishListEntity, Long>
{

	boolean checkAvaliable(String proName, String userName);

	List<WishListEntity> loadWishListProductByUser(String userName);



}
