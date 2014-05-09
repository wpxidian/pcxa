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
 * SpotPicture entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "spot_picture", catalog = "pcxa")
public class SpotPicture implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 5153776797165283233L;
	
	private Integer spotPictureId;
	private Spot spot;
	private String pictureLink;

	// Constructors

	/** default constructor */
	public SpotPicture() {
	}

	/** full constructor */
	public SpotPicture(Spot spot, String pictureLink) {
		this.spot = spot;
		this.pictureLink = pictureLink;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "spot_picture_id", unique = true, nullable = false)
	public Integer getSpotPictureId() {
		return this.spotPictureId;
	}

	public void setSpotPictureId(Integer spotPictureId) {
		this.spotPictureId = spotPictureId;
	}

	@ManyToOne
	@JoinColumn(name = "spot_id")
	public Spot getSpot() {
		return this.spot;
	}

	public void setSpot(Spot spot) {
		this.spot = spot;
	}

	@Column(name = "picture_link")
	public String getPictureLink() {
		return this.pictureLink;
	}

	public void setPictureLink(String pictureLink) {
		this.pictureLink = pictureLink;
	}

}