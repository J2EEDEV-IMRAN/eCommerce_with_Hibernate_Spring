package com.example.j2eeapp.dao;

import com.example.j2eeapp.commons.dao.GenericDao;
import com.example.j2eeapp.domain.DeliverCostEntity;

public interface DeliverCostDao extends GenericDao<DeliverCostEntity, Long>
{

	boolean checkAvailable(String countryName, String regionName);

	DeliverCostEntity loadCostByCnamRname(String countryName, String regionName);

}
