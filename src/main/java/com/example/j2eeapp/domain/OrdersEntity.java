   package com.example.j2eeapp.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.j2eeapp.commons.domain.BaseEntity;

@Entity
@Table(name="orders")
public class OrdersEntity extends BaseEntity {
	
	
		private static final long serialVersionUID = 770899067108144092L;
		private String userName;
		private String countryName;
		private Double cartPrice;
		private Float tax;
		private Float shippingCost;
	 	private Double totalPrice;
	 	
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getCountryName() {
			return countryName;
		}
		public void setCountryName(String countryName) {
			this.countryName = countryName;
		}
	 	
		public Double getCartPrice() {
			return cartPrice;
		}
		public Double getTotalPrice() {
			return totalPrice;
		}
		public void setCartPrice(Double cartPrice) {
			this.cartPrice = cartPrice;
		}
		public void setTotalPrice(Double totalPrice) {
			this.totalPrice = totalPrice;
		}
		public Float getTax() {
			return tax;
		}
		public void setTax(Float tax) {
			this.tax = tax;
		}
		public Float getShippingCost() {
			return shippingCost;
		}
		public void setShippingCost(Float shippingCost) {
			this.shippingCost = shippingCost;
		}

}
