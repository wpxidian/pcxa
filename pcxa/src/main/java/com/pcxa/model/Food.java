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
 * Food entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "food", catalog = "pcxa")
public class Food implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 3081710647880406926L;
	
	private Integer foodId;
	private Shop shop;
	private String name;
	private String briefIntroduction;
	private String introduction;
	private String pictureLink;
	private String address;
	private String phone;
	private String bus;
	private Integer weight;
	private String link;

	// Constructors

	/** default constructor */
	public Food() {
	}

	/** minimal constructor */
	public Food(Shop shop, String name, String briefIntroduction, Integer weight) {
		this.shop = shop;
		this.name = name;
		this.briefIntroduction = briefIntroduction;
		this.weight = weight;
	}

	/** full constructor */
	public Food(Shop shop, String name, String briefIntroduction,
			String introduction, String pictureLink, String address,
			String phone, String bus, Integer weight, String link) {
		this.shop = shop;
		this.name = name;
		this.briefIntroduction = briefIntroduction;
		this.introduction = introduction;
		this.pictureLink = pictureLink;
		this.address = address;
		this.phone = phone;
		this.bus = bus;
		this.weight = weight;
		this.link = link;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "food_id", unique = true, nullable = false)
	public Integer getFoodId() {
		return this.foodId;
	}

	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
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

	@Column(name = "picture_link")
	public String getPictureLink() {
		return this.pictureLink;
	}

	public void setPictureLink(String pictureLink) {
		this.pictureLink = pictureLink;
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

	@Column(name = "weight", nullable = false)
	public Integer getWeight() {
		return this.weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	@Column(name = "link")
	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}

}