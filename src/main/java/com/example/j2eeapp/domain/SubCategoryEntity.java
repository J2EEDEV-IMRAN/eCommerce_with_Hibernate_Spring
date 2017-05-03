package com.example.j2eeapp.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.example.j2eeapp.commons.domain.BaseEntity;

@Entity
@Table(name="subcategory")
public class SubCategoryEntity extends BaseEntity
{
  /**
	 * 
	 */
	private static final long serialVersionUID = -4634469120730606657L;
private String subCatName;
  private String subCatDesc;
  @ManyToOne
  @JoinColumn(name="categori_id")
  private CategoryEntity categoryEntity; 
  @OneToMany(fetch=FetchType.EAGER,mappedBy="subCategoryEntity")
  @Fetch(value=FetchMode.SUBSELECT)
  private List<ProductEntity> productEntity;
  

public String getSubCatName() {
	return subCatName;
}
public void setSubCatName(String subCatName) {
	this.subCatName = subCatName;
}
public String getSubCatDesc() {
	return subCatDesc;
}
public void setSubCatDesc(String subCatDesc) {
	this.subCatDesc = subCatDesc;
}
public CategoryEntity getCategoryEntity() {
	return categoryEntity;
}
public void setCategoryEntity(CategoryEntity categoryEntity) {
	this.categoryEntity = categoryEntity;
}
public List<ProductEntity> getProductEntity() {
	return productEntity;
}
public void setProductEntity(List<ProductEntity> productEntity) {
	this.productEntity = productEntity;
}
  
}
