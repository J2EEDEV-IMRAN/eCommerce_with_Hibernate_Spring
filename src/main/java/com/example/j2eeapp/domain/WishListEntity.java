package com.example.j2eeapp.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.j2eeapp.commons.domain.BaseEntity;
@Entity
@Table(name="wishlist")
public class WishListEntity extends BaseEntity
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 2637737340770172281L;
	private String proName;
    private Integer proQty;
    private Double proPrice;
	private String url;
	private String proDesc;
    private String userName;
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
	
    public Double getProPrice() {
		return proPrice;
	}
	public void setProPrice(Double proPrice) {
		this.proPrice = proPrice;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getProDesc() {
		return proDesc;
	}
	public void setProDesc(String proDesc) {
		this.proDesc = proDesc;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
    
}
