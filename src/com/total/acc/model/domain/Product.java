/**
 * 
 */
package com.total.acc.model.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.total.acc.util.JsonDateSerializer;


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
	
	@Column(name = "EFFECTIVE_DATETIME")
	private Date effectiveDateTime;

	@Column(name = "DOWNLOAD_URL")
	private String downloadURL;
	
	@Column(name = "DOWNLOAD_DESC", columnDefinition = "TEXT")
	private String downloadDesc;
	
	@Column(name = "PRICE_DESC", columnDefinition = "TEXT")
	private String priceDesc;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int id, String productId, String productName,
			String productTitle, String productDesc, float productPrice,
			String imgSrc, String status, Date effectiveDateTime,
			String downloadURL, String downloadDesc, String priceDesc) {
		super();
		this.id = id;
		this.productId = productId;
		this.productName = productName;
		this.productTitle = productTitle;
		this.productDesc = productDesc;
		this.productPrice = productPrice;
		this.imgSrc = imgSrc;
		this.status = status;
		this.effectiveDateTime = effectiveDateTime;
		this.downloadURL = downloadURL;
		this.downloadDesc = downloadDesc;
		this.priceDesc = priceDesc;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productId=" + productId
				+ ", productName=" + productName + ", productTitle="
				+ productTitle + ", productDesc=" + productDesc
				+ ", productPrice=" + productPrice + ", imgSrc=" + imgSrc
				+ ", status=" + status + ", effectiveDateTime="
				+ effectiveDateTime + ", downloadURL=" + downloadURL
				+ ", downloadDesc=" + downloadDesc + ", priceDesc=" + priceDesc
				+ "]";
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

	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getEffectiveDateTime() {
		return effectiveDateTime;
	}

	public void setEffectiveDateTime(Date effectiveDateTime) {
		this.effectiveDateTime = effectiveDateTime;
	}

	public String getDownloadURL() {
		return downloadURL;
	}

	public void setDownloadURL(String downloadURL) {
		this.downloadURL = downloadURL;
	}

	public String getDownloadDesc() {
		return downloadDesc;
	}

	public void setDownloadDesc(String downloadDesc) {
		this.downloadDesc = downloadDesc;
	}

	public String getPriceDesc() {
		return priceDesc;
	}

	public void setPriceDesc(String priceDesc) {
		this.priceDesc = priceDesc;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
