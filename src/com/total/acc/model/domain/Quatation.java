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
@Table(name = "ACC_QUATATION")
public class Quatation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3510165582558041964L;
	
	@Id
	@Column(name = "ID")
	@GeneratedValue
	private int id;
	
	@Column(name = "QUATATION_ID")
	private String quatationId;
	
	@Column(name = "QUATATION_CONTACT_NAME")
	private String quatationContactName;
	
	@Column(name = "QUATATION_CONTACR_MAIL")
	private String quatationContactEmail;
	
	@Column(name = "QUATATION_DESC")
	private String quatationDesc;
		
	@Column(name = "QUATATION_PRODUCT_ID")
	private String quatationProductId;
	
	@Column(name = "QUANTITY")
	private int quantity;
	
	@Column(name = "SUMPRICE")
	private float sumPrice;
	
	@Column(name = "EFFECTIVE_DATETIME")
	private Date effectiveDateTime;

	public Quatation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Quatation(int id, String quatationId, String quatationContactName,
			String quatationContactEmail, String quatationDesc,
			String quatationProductId, int quantity, float sumPrice,
			Date effectiveDateTime) {
		super();
		this.id = id;
		this.quatationId = quatationId;
		this.quatationContactName = quatationContactName;
		this.quatationContactEmail = quatationContactEmail;
		this.quatationDesc = quatationDesc;
		this.quatationProductId = quatationProductId;
		this.quantity = quantity;
		this.sumPrice = sumPrice;
		this.effectiveDateTime = effectiveDateTime;
	}

	@Override
	public String toString() {
		return "Quatation [id=" + id + ", quatationId=" + quatationId
				+ ", quatationContactName=" + quatationContactName
				+ ", quatationContactEmail=" + quatationContactEmail
				+ ", quatationDesc=" + quatationDesc + ", quatationProductId="
				+ quatationProductId + ", quantity=" + quantity + ", sumPrice="
				+ sumPrice + ", effectiveDateTime=" + effectiveDateTime + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuatationId() {
		return quatationId;
	}

	public void setQuatationId(String quatationId) {
		this.quatationId = quatationId;
	}

	public String getQuatationContactName() {
		return quatationContactName;
	}

	public void setQuatationContactName(String quatationContactName) {
		this.quatationContactName = quatationContactName;
	}

	public String getQuatationContactEmail() {
		return quatationContactEmail;
	}

	public void setQuatationContactEmail(String quatationContactEmail) {
		this.quatationContactEmail = quatationContactEmail;
	}

	public String getQuatationDesc() {
		return quatationDesc;
	}

	public void setQuatationDesc(String quatationDesc) {
		this.quatationDesc = quatationDesc;
	}

	public String getQuatationProductId() {
		return quatationProductId;
	}

	public void setQuatationProductId(String quatationProductId) {
		this.quatationProductId = quatationProductId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
