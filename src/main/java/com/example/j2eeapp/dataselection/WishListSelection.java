package com.example.j2eeapp.dataselection;

import java.io.Serializable;

import com.example.j2eeapp.domain.WishListEntity;


public class WishListSelection implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3101333144359091301L;
	private WishListEntity selected;

	public WishListEntity getSelected() {
		return selected;
	}

	public void setSelected(WishListEntity selected) {
		this.selected = selected;
	}
}
