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
 * TouristVideo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tourist_video", catalog = "pcxa")
public class TouristVideo implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -142015310114534773L;
	
	private Integer touristVideoId;
	private TouristSpot touristSpot;
	private String videoLink;

	// Constructors

	/** default constructor */
	public TouristVideo() {
	}

	/** minimal constructor */
	public TouristVideo(String videoLink) {
		this.videoLink = videoLink;
	}

	/** full constructor */
	public TouristVideo(TouristSpot touristSpot, String videoLink) {
		this.touristSpot = touristSpot;
		this.videoLink = videoLink;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "tourist_video_id", unique = true, nullable = false)
	public Integer getTouristVideoId() {
		return this.touristVideoId;
	}

	public void setTouristVideoId(Integer touristVideoId) {
		this.touristVideoId = touristVideoId;
	}

	@ManyToOne
	@JoinColumn(name = "tourist_spot_id")
	public TouristSpot getTouristSpot() {
		return this.touristSpot;
	}

	public void setTouristSpot(TouristSpot touristSpot) {
		this.touristSpot = touristSpot;
	}

	@Column(name = "video_link", nullable = false)
	public String getVideoLink() {
		return this.videoLink;
	}

	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}

}