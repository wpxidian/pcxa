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
 * SpotVideo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "spot_video", catalog = "pcxa")
public class SpotVideo implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -1800724357158539638L;
	
	private Integer spotVideoId;
	private Spot spot;
	private String videoLink;

	// Constructors

	/** default constructor */
	public SpotVideo() {
	}

	/** full constructor */
	public SpotVideo(Spot spot, String videoLink) {
		this.spot = spot;
		this.videoLink = videoLink;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "spot_video_id", unique = true, nullable = false)
	public Integer getSpotVideoId() {
		return this.spotVideoId;
	}

	public void setSpotVideoId(Integer spotVideoId) {
		this.spotVideoId = spotVideoId;
	}

	@ManyToOne
	@JoinColumn(name = "spot_id", nullable = false)
	public Spot getSpot() {
		return this.spot;
	}

	public void setSpot(Spot spot) {
		this.spot = spot;
	}

	@Column(name = "video_link", nullable = false)
	public String getVideoLink() {
		return this.videoLink;
	}

	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}

}