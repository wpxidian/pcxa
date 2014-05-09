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
 * TouristSpot entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tourist_spot", catalog = "pcxa")
public class TouristSpot implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2835296583034833690L;
	// Fields

	private Integer touristSpotId;
	private Shop shop;
	private TouristClassification touristClassification;
	private String name;
	private String briefIntroduction;
	private String introduction;
	private float longitude;
	private float latitude;
	private String address;
	private String pictureLink;
	private Integer grade;
	private Integer weight;
	private String bus;
	private String phone;
	private Set<Spot> spots = new HashSet<Spot>(0);
	private Set<TouristPicture> touristPictures = new HashSet<TouristPicture>(0);
	private Set<TouristVideo> touristVideos = new HashSet<TouristVideo>(0);

	// Constructors

	/** default constructor */
	public TouristSpot() {
	}

	/** minimal constructor */
	public TouristSpot(TouristClassification touristClassification,
			String name, String briefIntroduction, Integer weight) {
		this.touristClassification = touristClassification;
		this.name = name;
		this.briefIntroduction = briefIntroduction;
		this.weight = weight;
	}

	/** full constructor */
	public TouristSpot(Shop shop, TouristClassification touristClassification,
			String name, String briefIntroduction, String introduction,
			float longitude, float latitude, String address,
			String pictureLink, Integer grade, Integer weight, String bus,
			String phone) {
		this.shop = shop;
		this.touristClassification = touristClassification;
		this.name = name;
		this.briefIntroduction = briefIntroduction;
		this.introduction = introduction;
		this.longitude = longitude;
		this.latitude = latitude;
		this.address = address;
		this.pictureLink = pictureLink;
		this.grade = grade;
		this.weight = weight;
		this.bus = bus;
		this.phone = phone;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "tourist_spot_id", unique = true, nullable = false)
	public Integer getTouristSpotId() {
		return this.touristSpotId;
	}

	public void setTouristSpotId(Integer touristSpotId) {
		this.touristSpotId = touristSpotId;
	}

	@ManyToOne
	@JoinColumn(name = "shop_id")
	public Shop getShop() {
		return this.shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	@ManyToOne
	@JoinColumn(name = "tourist_classification_id", nullable = false)
	public TouristClassification getTouristClassification() {
		return this.touristClassification;
	}

	public void setTouristClassification(
			TouristClassification touristClassification) {
		this.touristClassification = touristClassification;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "brief_introduction", nullable = false)
	public String getBriefIntroduction() {
		return this.briefIntroduction;
	}

	public void setBriefIntroduction(String briefIntroduction) {
		this.briefIntroduction = briefIntroduction;
	}

	@Column(name = "introduction", length = 65535)
	public String getIntroduction() {
		return this.introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
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

	@Column(name = "address")
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "picture_link")
	public String getPictureLink() {
		return this.pictureLink;
	}

	public void setPictureLink(String pictureLink) {
		this.pictureLink = pictureLink;
	}

	@Column(name = "grade")
	public Integer getGrade() {
		return this.grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	@Column(name = "weight", nullable = false)
	public Integer getWeight() {
		return this.weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	@Column(name = "bus")
	public String getBus() {
		return this.bus;
	}

	public void setBus(String bus) {
		this.bus = bus;
	}

	@Column(name = "phone")
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "touristSpot")
	public Set<Spot> getSpots() {
		return this.spots;
	}

	public void setSpots(Set<Spot> spots) {
		this.spots = spots;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "touristSpot")
	public Set<TouristPicture> getTouristPictures() {
		return this.touristPictures;
	}

	public void setTouristPictures(Set<TouristPicture> touristPictures) {
		this.touristPictures = touristPictures;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "touristSpot")
	public Set<TouristVideo> getTouristVideos() {
		return this.touristVideos;
	}

	public void setTouristVideos(Set<TouristVideo> touristVideos) {
		this.touristVideos = touristVideos;
	}

}