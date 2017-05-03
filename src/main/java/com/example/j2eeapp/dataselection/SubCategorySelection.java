package com.example.j2eeapp.dataselection;

import java.io.Serializable;

import com.example.j2eeapp.domain.SubCategoryEntity;

public class SubCategorySelection implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7478236132906852078L;
	
	private SubCategoryEntity selected;

	public SubCategoryEntity getSelected() {
		return selected;
	}

	public void setSelected(SubCategoryEntity selected) {
		this.selected = selected;
	}
}
