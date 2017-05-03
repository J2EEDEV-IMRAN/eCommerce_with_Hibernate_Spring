package com.example.j2eeapp.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.j2eeapp.commons.domain.BaseEntity;

@Entity
@Table(name="category")
public class CategoryEntity extends BaseEntity
{
  /**
	 * 
	 */
	private static final long serialVersionUID = 1729057816632386708L;
private String catName;
  private String catDesc;
  @OneToMany(mappedBy="categoryEntity",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
  private List<SubCategoryEntity> subcategoryEntity;
  
public String getCatName() {
	return catName;
}
public void setCatName(String catName) {
	this.catName = catName;
}
public String getCatDesc() {
	return catDesc;
}
public void setCatDesc(String catDesc) {
	this.catDesc = catDesc;
}
public List<SubCategoryEntity> getSubcategoryEntity() {
	return subcategoryEntity;
}
public void setSubcategoryEntity(List<SubCategoryEntity> subcategoryEntity) {
	this.subcategoryEntity = subcategoryEntity;
}

}
