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
 * TourRoute entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tour_route", catalog = "pcxa")
public class TourRoute implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -3357706276145531221L;
	
	private Integer tourRouteId;
	private Shop shop;
	private TourRouteClassification tourRouteClassification;
	private String name;
	private String pictureLink;
	private String briefIntroduction;
	private String introduction;
	private Integer weight;

	// Constructors

	/** default constructor */
	public TourRoute() {
	}

	/** minimal constructor */
	public TourRoute(Shop shop,
			TourRouteClassification tourRouteClassification, String name,
			String pictureLink, String briefIntroduction, Integer weight) {
		this.shop = shop;
		this.tourRouteClassification = tourRouteClassification;
		this.name = name;
		this.pictureLink = pictureLink;
		this.briefIntroduction = briefIntroduction;
		this.weight = weight;
	}

	/** full constructor */
	public TourRoute(Shop shop,
			TourRouteClassification tourRouteClassification, String name,
			String pictureLink, String briefIntroduction, String introduction,
			Integer weight) {
		this.shop = shop;
		this.tourRouteClassification = tourRouteClassification;
		this.name = name;
		this.pictureLink = pictureLink;
		this.briefIntroduction = briefIntroduction;
		this.introduction = introduction;
		this.weight = weight;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "tour_route_id", unique = true, nullable = false)
	public Integer getTourRouteId() {
		return this.tourRouteId;
	}

	public void setTourRouteId(Integer tourRouteId) {
		this.tourRouteId = tourRouteId;
	}

	@ManyToOne
	@JoinColumn(name = "shop_id", nullable = false)
	public Shop getShop() {
		return this.shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	@ManyToOne
	@JoinColumn(name = "tour_route_classification_id", nullable = false)
	public TourRouteClassification getTourRouteClassification() {
		return this.tourRouteClassification;
	}

	public void setTourRouteClassification(
			TourRouteClassification tourRouteClassification) {
		this.tourRouteClassification = tourRouteClassification;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "picture_link", nullable = false)
	public String getPictureLink() {
		return this.pictureLink;
	}

	public void setPictureLink(String pictureLink) {
		this.pictureLink = pictureLink;
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

	@Column(name = "weight", nullable = false)
	public Integer getWeight() {
		return this.weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

}