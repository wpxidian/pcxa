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
 * Hotel entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "hotel", catalog = "pcxa")
public class Hotel implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 7213107936150717073L;
	
	private Integer hotelId;
	private Shop shop;
	private String name;
	private String pictureLink;
	private String introduction;
	private String star;
	private String link;
	private String briefIntroduction;
	private String address;
	private String phone;
	private String bus;
	private Integer weight;

	// Constructors

	/** default constructor */
	public Hotel() {
	}

	/** minimal constructor */
	public Hotel(Shop shop, String name, String pictureLink,
			String briefIntroduction) {
		this.shop = shop;
		this.name = name;
		this.pictureLink = pictureLink;
		this.briefIntroduction = briefIntroduction;
	}

	/** full constructor */
	public Hotel(Shop shop, String name, String pictureLink,
			String introduction, String star, String link,
			String briefIntroduction, String address, String phone, String bus,
			Integer weight) {
		this.shop = shop;
		this.name = name;
		this.pictureLink = pictureLink;
		this.introduction = introduction;
		this.star = star;
		this.link = link;
		this.briefIntroduction = briefIntroduction;
		this.address = address;
		this.phone = phone;
		this.bus = bus;
		this.weight = weight;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "hotel_id", unique = true, nullable = false)
	public Integer getHotelId() {
		return this.hotelId;
	}

	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}

	@ManyToOne
	@JoinColumn(name = "shop_id", nullable = false)
	public Shop getShop() {
		return this.shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
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

	@Column(name = "introduction", length = 65535)
	public String getIntroduction() {
		return this.introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	@Column(name = "star")
	public String getStar() {
		return this.star;
	}

	public void setStar(String star) {
		this.star = star;
	}

	@Column(name = "link")
	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Column(name = "brief_introduction", nullable = false)
	public String getBriefIntroduction() {
		return this.briefIntroduction;
	}

	public void setBriefIntroduction(String briefIntroduction) {
		this.briefIntroduction = briefIntroduction;
	}

	@Column(name = "address")
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "phone")
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "bus")
	public String getBus() {
		return this.bus;
	}

	public void setBus(String bus) {
		this.bus = bus;
	}

	@Column(name = "weight")
	public Integer getWeight() {
		return this.weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

}