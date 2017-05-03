package com.example.j2eeapp.dao;

import com.example.j2eeapp.commons.dao.GenericJpaDao;
import com.example.j2eeapp.domain.OrdersEntity;

public class OrdersJapaDao extends GenericJpaDao<OrdersEntity, Long> implements OrdersDao  {

	public OrdersJapaDao()
	{
		super(OrdersEntity.class);
	}

}
