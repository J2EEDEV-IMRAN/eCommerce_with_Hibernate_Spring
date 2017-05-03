package com.example.j2eeapp.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.j2eeapp.commons.domain.BaseEntity;
@Entity
@Table(name="product")
public class ProductEntity extends BaseEntity
{
   /**
	 * 
	 */
   private static final long serialVersionUID = 444578297843380867L;
   private String proName;
   private Integer proQty;
   private Double proPrice;
   private String url;
   private String proDesc;
  
   @ManyToOne(cascade=CascadeType.ALL)  
   @JoinColumn(name="subcat_id")
   private SubCategoryEntity subCategoryEntity; 
   

public String getProName() {
	return proName;
}
public void setProName(String proName) {
	this.proName = proName;
}
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public Integer getProQty() {
	return proQty;
}
public void setProQty(Integer proQty) {
	this.proQty = proQty;
}
public Double getProPrice() {
	return proPrice;
}
public void setProPrice(Double proPrice) {
	this.proPrice = proPrice;
}
public String getProDesc() {
	return proDesc;
}
public void setProDesc(String proDesc) {
	this.proDesc = proDesc;
}
public SubCategoryEntity getSubCategoryEntity() {
	return subCategoryEntity;
}
public void setSubCategoryEntity(SubCategoryEntity subCategoryEntity) {
	this.subCategoryEntity = subCategoryEntity;
}
   
}
