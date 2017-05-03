package com.example.j2eeapp.services.impl;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.example.j2eeapp.dao.DeliverCostDao;
import com.example.j2eeapp.domain.DeliverCostEntity;
import com.example.j2eeapp.services.DeliverCostService;


public class DeliverCostServiceImpl implements DeliverCostService  {
	
  private DeliverCostDao deliverCostDao;

public DeliverCostDao getDeliverCostDao() {
	return deliverCostDao;
}

public void setDeliverCostDao(DeliverCostDao deliverCostDao) {
	this.deliverCostDao = deliverCostDao;
}

public boolean createCost(DeliverCostEntity deliverCostEntity) {
	if(!deliverCostDao.checkAvailable(deliverCostEntity.getCountryName(),deliverCostEntity.getRegionName()))
	{
		  FacesMessage message=constructErrorMessage(String.format("Country '%s' is not available", deliverCostEntity.getCountryName()), null);
		   getFacesContext().addMessage(null, message);
		   return false;
	}
	try {
		deliverCostDao.save(deliverCostEntity);
	} catch (Exception e) {
		return false;
	}
	return true;
}

public List<DeliverCostEntity> loadAllCosts() {
	
	return deliverCostDao.findAll();
}

public void deleteCost(DeliverCostEntity deliverCostEntity) {
	deliverCostDao.delete(deliverCostEntity);	
}

public boolean updateCost(DeliverCostEntity deliverCostEntity) {
	try {
		deliverCostDao.update(deliverCostEntity);	
		} 
		catch (Exception e) {
			FacesMessage message=constructFatalMessage(e.getMessage(), null);
			getFacesContext().addMessage(null, message);
			return false;
			
		}
	return true;
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
