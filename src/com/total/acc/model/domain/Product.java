/**
 * 
 */
package com.total.acc.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Sirimongkol
 *
 */
@Entity
@Table(name = "ACC_PRODUCT")
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 113442362882565427L;
	
	@Id
	@Column(name = "ID")
	@GeneratedValue
	private int id;
	
	@Column(name = "PRODUCT_ID")
	private String productId;
	
	@Column(name = "PRODUCT_NAME", columnDefinition = "TEXT")
	private String productName;
	
	@Column(name = "PRODUCT_TITLE", columnDefinition = "TEXT")
	private String productTitle;
	
	@Column(name = "PRODUCT_DESC", columnDefinition = "TEXT")
	private String productDesc;
	
	@Column(name = "PRICE")
	private float productPrice;
	
	@Column(name = "IMG_SRC", columnDefinition = "TEXT")
	private String imgSrc;
	
	@Column(name = "STATUS")
	private String status;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}

	public String getImgSrc() {
		return imgSrc;
	}

	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productId=" + productId
				+ ", productName=" + productName + ", productTitle="
				+ productTitle + ", productDesc=" + productDesc
				+ ", productPrice=" + productPrice + ", imgSrc=" + imgSrc
				+ ", status=" + status + "]";
	}

	public Product(int id, String productId, String productName,
			String productTitle, String productDesc, float productPrice,
			String imgSrc, String status) {
		super();
		this.id = id;
		this.productId = productId;
		this.productName = productName;
		this.productTitle = productTitle;
		this.productDesc = productDesc;
		this.productPrice = productPrice;
		this.imgSrc = imgSrc;
		this.status = status;
	}
	
	
}
