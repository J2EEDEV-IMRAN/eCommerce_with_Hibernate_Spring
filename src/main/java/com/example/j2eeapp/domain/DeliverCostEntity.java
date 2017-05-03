package com.example.j2eeapp.domain;


import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.j2eeapp.commons.domain.BaseEntity;
@Entity
@Table(name="delivarycost")
public class DeliverCostEntity extends BaseEntity
{
  /**
	 * 
	 */
	private static final long serialVersionUID = 1081652769483766165L;
  private String countryName;
  private String regionName;
  private Double deliveryCost;
  
public String getCountryName() {
	return countryName;
}
public void setCountryName(String countryName) {
	this.countryName = countryName;
}
public String getRegionName() {
	return regionName;
}
public void setRegionName(String regionName) {
	this.regionName = regionName;
}
public Double getDeliveryCost() {
	return deliveryCost;
}
public void setDeliveryCost(Double deliveryCost) {
	this.deliveryCost = deliveryCost;
}



}
