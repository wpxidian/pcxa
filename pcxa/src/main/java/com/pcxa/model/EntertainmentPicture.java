package com.pcxa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * EntertainmentPicture entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "entertainment_picture", catalog = "pcxa")
public class EntertainmentPicture implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -6214069952880513776L;
	private Integer entertainmentPictureId;
	private Entertainment entertainment;
	private String pictureLink;

	// Constructors

	/** default constructor */
	public EntertainmentPicture() {
	}

	/** full constructor */
	public EntertainmentPicture(Entertainment entertainment, String pictureLink) {
		this.entertainment = entertainment;
		this.pictureLink = pictureLink;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "entertainment_picture_id", unique = true, nullable = false)
	public Integer getEntertainmentPictureId() {
		return this.entertainmentPictureId;
	}

	public void setEntertainmentPictureId(Integer entertainmentPictureId) {
		this.entertainmentPictureId = entertainmentPictureId;
	}

	@ManyToOne
	@JoinColumn(name = "entertainment_id", nullable = false)
	public Entertainment getEntertainment() {
		return this.entertainment;
	}

	public void setEntertainment(Entertainment entertainment) {
		this.entertainment = entertainment;
	}

	@Column(name = "picture_link", nullable = false)
	public String getPictureLink() {
		return this.pictureLink;
	}

	public void setPictureLink(String pictureLink) {
		this.pictureLink = pictureLink;
	}

}