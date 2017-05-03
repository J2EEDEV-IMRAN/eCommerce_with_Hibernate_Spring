package com.example.j2eeapp.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.j2eeapp.commons.domain.BaseEntity;
@Entity
@Table(name="productorderdetails")
public class ProductOrderDetailsEntity extends BaseEntity
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 2637737340770172281L;
	private String proName;
    private Integer proQty;
    private Double totalPrice;
    private String userName;
	private String orderStatus;
    @ManyToOne
    private UserEntity userEntity;
    @ManyToOne
    private ProductEntity productEntity;
    
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public Integer getProQty() {
		return proQty;
	}
	public void setProQty(Integer proQty) {
		this.proQty = proQty;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public UserEntity getUserEntity() {
		return userEntity;
	}
	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}
	public ProductEntity getProductEntity() {
		return productEntity;
	}
	public void setProductEntity(ProductEntity productEntity) {
		this.productEntity = productEntity;
	}
    public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
    
}
