package com.example.j2eeapp.dataselection;

import java.io.Serializable;

import com.example.j2eeapp.domain.ProductOrderDetailsEntity;



public class ProductOrderDetailsSelection implements Serializable {
	
	private static final long serialVersionUID = 9203714220362652869L;
	private ProductOrderDetailsEntity selected;
	
	public ProductOrderDetailsEntity getSelected() {
		return selected;
	}
	public void setSelected(ProductOrderDetailsEntity selected) {
		this.selected = selected;
	}


}
