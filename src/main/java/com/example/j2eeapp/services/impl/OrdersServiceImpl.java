package com.example.j2eeapp.services.impl;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.example.j2eeapp.dao.DeliverCostDao;
import com.example.j2eeapp.dao.OrdersDao;
import com.example.j2eeapp.domain.DeliverCostEntity;
import com.example.j2eeapp.services.OrdersService;


public class OrdersServiceImpl implements OrdersService  {
	private OrdersDao ordersDao;
	private DeliverCostDao deliverCostDao;
	
	public OrdersServiceImpl()
	{
		
	}
	
	public OrdersServiceImpl(OrdersDao ordersDao,DeliverCostDao deliverCostDao) {
		super();
		this.ordersDao = ordersDao;
		this.deliverCostDao= deliverCostDao;
	}



	public void setOrdersDao(OrdersDao ordersDao,DeliverCostDao deliverCostDao) {
		this.ordersDao = ordersDao;
		this.deliverCostDao=deliverCostDao;
	}

	public OrdersDao getOrdersDao() {
		return ordersDao;
	}
	public DeliverCostDao getDeliverCostDao() {
		return deliverCostDao;
	}

	public void setDeliverCostDao(DeliverCostDao deliverCostDao) {
		this.deliverCostDao = deliverCostDao;
	}

	public void setOrdersDao(OrdersDao ordersDao) {
		this.ordersDao = ordersDao;
	}

	public DeliverCostEntity setShippingPrice(String cname,String rname) {
		DeliverCostEntity deliverCostEntity=new DeliverCostEntity();
		try {
			 deliverCostEntity=deliverCostDao.loadCostByCnamRname(cname,rname);
		} catch (Exception e) {
			FacesMessage message=constructFatalMessage(e.getMessage(), null);
			getFacesContext().addMessage(null, message);
			return null;
			
		}
		return deliverCostEntity; 
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
