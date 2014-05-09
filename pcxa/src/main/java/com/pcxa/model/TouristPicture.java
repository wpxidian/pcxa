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
 * TouristPicture entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tourist_picture", catalog = "pcxa")
public class TouristPicture implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 2746562130943706925L;
	private Integer touristPictureId;
	private TouristSpot touristSpot;
	private String pictureLink;

	// Constructors

	/** default constructor */
	public TouristPicture() {
	}

	/** full constructor */
	public TouristPicture(TouristSpot touristSpot, String pictureLink) {
		this.touristSpot = touristSpot;
		this.pictureLink = pictureLink;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "tourist_picture_id", unique = true, nullable = false)
	public Integer getTouristPictureId() {
		return this.touristPictureId;
	}

	public void setTouristPictureId(Integer touristPictureId) {
		this.touristPictureId = touristPictureId;
	}

	@ManyToOne
	@JoinColumn(name = "tourist_spot_id", nullable = false)
	public TouristSpot getTouristSpot() {
		return this.touristSpot;
	}

	public void setTouristSpot(TouristSpot touristSpot) {
		this.touristSpot = touristSpot;
	}

	@Column(name = "picture_link", nullable = false)
	public String getPictureLink() {
		return this.pictureLink;
	}

	public void setPictureLink(String pictureLink) {
		this.pictureLink = pictureLink;
	}

}