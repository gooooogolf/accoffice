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
@Table(name = "ACC_VIDEO")
public class Video implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4899930654653578311L;

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private int id;
	
	@Column(name = "PRODUCT_ID")
	private String productId;
	
	@Column(name = "VIDEO_SEQ")
	private int videoSeq;
	
	@Column(name = "VIDEO_NAME", columnDefinition = "TEXT")
	private String videoName;
	
	@Column(name = "VIDEO_TITLE", columnDefinition = "TEXT")
	private String videoTitle;
	
	@Column(name = "VIDEO_DESC", columnDefinition = "TEXT")
	private String videoDesc;

	public Video() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Video(int id, String productId, int videoSeq, String videoName,
			String videoTitle, String videoDesc) {
		super();
		this.id = id;
		this.productId = productId;
		this.videoSeq = videoSeq;
		this.videoName = videoName;
		this.videoTitle = videoTitle;
		this.videoDesc = videoDesc;
	}

	@Override
	public String toString() {
		return "Video [id=" + id + ", productId=" + productId + ", videoSeq="
				+ videoSeq + ", videoName=" + videoName + ", videoTitle="
				+ videoTitle + ", videoDesc=" + videoDesc + "]";
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

	public int getVideoSeq() {
		return videoSeq;
	}

	public void setVideoSeq(int videoSeq) {
		this.videoSeq = videoSeq;
	}

	public String getVideoName() {
		return videoName;
	}

	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}

	public String getVideoTitle() {
		return videoTitle;
	}

	public void setVideoTitle(String videoTitle) {
		this.videoTitle = videoTitle;
	}

	public String getVideoDesc() {
		return videoDesc;
	}

	public void setVideoDesc(String videoDesc) {
		this.videoDesc = videoDesc;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
