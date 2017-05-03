package com.example.j2eeapp.dataselection;

import java.io.Serializable;

import com.example.j2eeapp.domain.ProductEntity;


public class ProductSelection implements Serializable {
	
	private static final long serialVersionUID = -4885722276156750740L;
	private ProductEntity selected;

	public ProductEntity getSelected() {
		return selected;
	}

	public void setSelected(ProductEntity selected) {
		this.selected = selected;
	}
}
