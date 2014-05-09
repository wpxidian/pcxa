package com.pcxa.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Spot entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "spot", catalog = "pcxa")
public class Spot implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1355353438804275720L;
	
	private Integer spotId;
	private TouristSpot touristSpot;
	private String name;
	private String introduction;
	private String pictureLink;
	private float longitude;
	private float latitude;
	private Set<SpotVideo> spotVideos = new HashSet<SpotVideo>(0);
	private Set<SpotPicture> spotPictures = new HashSet<SpotPicture>(0);

	// Constructors

	/** default constructor */
	public Spot() {
	}

	/** minimal constructor */
	public Spot(TouristSpot touristSpot, String name) {
		this.touristSpot = touristSpot;
		this.name = name;
	}

	/** full constructor */
	public Spot(TouristSpot touristSpot, String name, String introduction,
			String pictureLink, float longitude, float latitude,
			Set<SpotVideo> spotVideos, Set<SpotPicture> spotPictures) {
		this.touristSpot = touristSpot;
		this.name = name;
		this.introduction = introduction;
		this.pictureLink = pictureLink;
		this.longitude = longitude;
		this.latitude = latitude;
		this.spotVideos = spotVideos;
		this.spotPictures = spotPictures;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "spot_id", unique = true, nullable = false)
	public Integer getSpotId() {
		return this.spotId;
	}

	public void setSpotId(Integer spotId) {
		this.spotId = spotId;
	}

	@ManyToOne
	@JoinColumn(name = "tourist_spot_id", nullable = false)
	public TouristSpot getTouristSpot() {
		return this.touristSpot;
	}

	public void setTouristSpot(TouristSpot touristSpot) {
		this.touristSpot = touristSpot;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "introduction", length = 65535)
	public String getIntroduction() {
		return this.introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	@Column(name = "picture_link")
	public String getPictureLink() {
		return this.pictureLink;
	}

	public void setPictureLink(String pictureLink) {
		this.pictureLink = pictureLink;
	}

	@Column(name = "longitude", precision = 12, scale = 0)
	public float getLongitude() {
		return this.longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	@Column(name = "latitude", precision = 12, scale = 0)
	public float getLatitude() {
		return this.latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "spot")
	public Set<SpotVideo> getSpotVideos() {
		return this.spotVideos;
	}

	public void setSpotVideos(Set<SpotVideo> spotVideos) {
		this.spotVideos = spotVideos;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "spot")
	public Set<SpotPicture> getSpotPictures() {
		return this.spotPictures;
	}

	public void setSpotPictures(Set<SpotPicture> spotPictures) {
		this.spotPictures = spotPictures;
	}

}