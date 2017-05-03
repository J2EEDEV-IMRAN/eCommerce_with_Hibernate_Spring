package com.example.j2eeapp.services;

import java.util.List;

import com.example.j2eeapp.domain.DeliverCostEntity;

public interface DeliverCostService {

	boolean createCost(DeliverCostEntity deliverCostEntity);
	List<DeliverCostEntity> loadAllCosts();
	void deleteCost(DeliverCostEntity deliverCostEntity);
	boolean updateCost(DeliverCostEntity deliverCostEntity);
	
}

