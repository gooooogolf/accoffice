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
@Table(name = "ACC_TECHNIQUE")
public class Technique implements Serializable {



	/**
	 * 
	 */
	private static final long serialVersionUID = -4831483669231707568L;

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private int id;
	
	@Column(name = "PRODUCT_ID")
	private String productId;
	
	@Column(name = "TECH_SEQ")
	private int techSeq;
	
	@Column(name = "TECH_NAME", columnDefinition = "TEXT")
	private String techName;
	
	@Column(name = "TECH_TITLE", columnDefinition = "TEXT")
	private String techTitle;
	
	@Column(name = "TECH_DESC", columnDefinition = "TEXT")
	private String techDesc;

	public Technique() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Technique(int id, String productId, int techSeq, String techName,
			String techTitle, String techDesc) {
		super();
		this.id = id;
		this.productId = productId;
		this.techSeq = techSeq;
		this.techName = techName;
		this.techTitle = techTitle;
		this.techDesc = techDesc;
	}

	@Override
	public String toString() {
		return "Technique [id=" + id + ", productId=" + productId
				+ ", techSeq=" + techSeq + ", techName=" + techName
				+ ", techTitle=" + techTitle + ", techDesc=" + techDesc + "]";
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

	public int getTechSeq() {
		return techSeq;
	}

	public void setTechSeq(int techSeq) {
		this.techSeq = techSeq;
	}

	public String getTechName() {
		return techName;
	}

	public void setTechName(String techName) {
		this.techName = techName;
	}

	public String getTechTitle() {
		return techTitle;
	}

	public void setTechTitle(String techTitle) {
		this.techTitle = techTitle;
	}

	public String getTechDesc() {
		return techDesc;
	}

	public void setTechDesc(String techDesc) {
		this.techDesc = techDesc;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}
