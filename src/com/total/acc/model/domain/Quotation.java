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

/**
 * @author Sirimongkol
 *
 */
@Entity
@Table(name = "ACC_QUOTATION")
public class Quotation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3510165582558041964L;
	
	@Id
	@Column(name = "ID")
	@GeneratedValue
	private int id;
	
	@Column(name = "QUOTATION_ID")
	private String quotationId;
	
	@Column(name = "QUOTATION_CONTACT_NAME")
	private String quotationContactName;
	
	@Column(name = "QUOTATION_CONTACT_MAIL")
	private String quotationContactEmail;
	
	@Column(name = "QUOTATION_SEQ")
	private String quotationSeq;
	
	@Column(name = "QUOTATION_DESC")
	private String quotationDesc;
		
	@Column(name = "QUOTATION_PRODUCT_ID")
	private String quotationProductId;
	
	@Column(name = "PRICE")
	private float price;
	
	@Column(name = "QUANTITY")
	private int quantity;
	
	@Column(name = "VAT")
	private float vat;
	
	@Column(name = "SUMPRICE")
	private float sumPrice;
	
	@Column(name = "EFFECTIVE_DATETIME")
	private Date effectiveDateTime;

	public Quotation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Quotation(int id, String quotationId, String quotationContactName,
			String quotationContactEmail, String quotationSeq,
			String quotationDesc, String quotationProductId, float price,
			int quantity, float vat, float sumPrice, Date effectiveDateTime) {
		super();
		this.id = id;
		this.quotationId = quotationId;
		this.quotationContactName = quotationContactName;
		this.quotationContactEmail = quotationContactEmail;
		this.quotationSeq = quotationSeq;
		this.quotationDesc = quotationDesc;
		this.quotationProductId = quotationProductId;
		this.price = price;
		this.quantity = quantity;
		this.vat = vat;
		this.sumPrice = sumPrice;
		this.effectiveDateTime = effectiveDateTime;
	}

	@Override
	public String toString() {
		return "Quotation [id=" + id + ", quotationId=" + quotationId
				+ ", quotationContactName=" + quotationContactName
				+ ", quotationContactEmail=" + quotationContactEmail
				+ ", quotationSeq=" + quotationSeq + ", quotationDesc="
				+ quotationDesc + ", quotationProductId=" + quotationProductId
				+ ", price=" + price + ", quantity=" + quantity + ", vat="
				+ vat + ", sumPrice=" + sumPrice + ", effectiveDateTime="
				+ effectiveDateTime + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuotationId() {
		return quotationId;
	}

	public void setQuotationId(String quotationId) {
		this.quotationId = quotationId;
	}

	public String getQuotationContactName() {
		return quotationContactName;
	}

	public void setQuotationContactName(String quotationContactName) {
		this.quotationContactName = quotationContactName;
	}

	public String getQuotationContactEmail() {
		return quotationContactEmail;
	}

	public void setQuotationContactEmail(String quotationContactEmail) {
		this.quotationContactEmail = quotationContactEmail;
	}

	public String getQuotationSeq() {
		return quotationSeq;
	}

	public void setQuotationSeq(String quotationSeq) {
		this.quotationSeq = quotationSeq;
	}

	public String getQuotationDesc() {
		return quotationDesc;
	}

	public void setQuotationDesc(String quotationDesc) {
		this.quotationDesc = quotationDesc;
	}

	public String getQuotationProductId() {
		return quotationProductId;
	}

	public void setQuotationProductId(String quotationProductId) {
		this.quotationProductId = quotationProductId;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getVat() {
		return vat;
	}

	public void setVat(float vat) {
		this.vat = vat;
	}

	public float getSumPrice() {
		return sumPrice;
	}

	public void setSumPrice(float sumPrice) {
		this.sumPrice = sumPrice;
	}

	public Date getEffectiveDateTime() {
		return effectiveDateTime;
	}

	public void setEffectiveDateTime(Date effectiveDateTime) {
		this.effectiveDateTime = effectiveDateTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
