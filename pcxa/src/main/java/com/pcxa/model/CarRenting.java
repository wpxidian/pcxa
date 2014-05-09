package com.pcxa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * CarRenting entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "car_renting", catalog = "pcxa")
public class CarRenting implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 8743893836717898165L;
	
	private Integer carRentingId;
	private Shop shop;
	private CarBrand carBrand;
	private CarLevel carLevel;
	private String name;
	private String type;
	private float displacement;
	private boolean gear;
	private String marineRisk;
	private String pictureLink;
	private String preAuthorization;
	private String shopName;
	private String address;
	private String phone;
	private String link;
	private Integer weight;
	private String price;

	// Constructors

	/** default constructor */
	public CarRenting() {
	}

	/** minimal constructor */
	public CarRenting(Shop shop, CarBrand carBrand, CarLevel carLevel,
			String name, String shopName, Integer weight) {
		this.shop = shop;
		this.carBrand = carBrand;
		this.carLevel = carLevel;
		this.name = name;
		this.shopName = shopName;
		this.weight = weight;
	}

	/** full constructor */
	public CarRenting(Shop shop, CarBrand carBrand, CarLevel carLevel,
			String name, String type, float displacement, boolean gear,
			String marineRisk, String pictureLink, String preAuthorization,
			String shopName, String address, String phone, String link,
			Integer weight, String price) {
		this.shop = shop;
		this.carBrand = carBrand;
		this.carLevel = carLevel;
		this.name = name;
		this.type = type;
		this.displacement = displacement;
		this.gear = gear;
		this.marineRisk = marineRisk;
		this.pictureLink = pictureLink;
		this.preAuthorization = preAuthorization;
		this.shopName = shopName;
		this.address = address;
		this.phone = phone;
		this.link = link;
		this.weight = weight;
		this.price = price;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "car_renting_id", unique = true, nullable = false)
	public Integer getCarRentingId() {
		return this.carRentingId;
	}

	public void setCarRentingId(Integer carRentingId) {
		this.carRentingId = carRentingId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "shop_id", nullable = false)
	public Shop getShop() {
		return this.shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "car_brand_id", nullable = false)
	public CarBrand getCarBrand() {
		return this.carBrand;
	}

	public void setCarBrand(CarBrand carBrand) {
		this.carBrand = carBrand;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "car_level_id", nullable = false)
	public CarLevel getCarLevel() {
		return this.carLevel;
	}

	public void setCarLevel(CarLevel carLevel) {
		this.carLevel = carLevel;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "type")
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "displacement", precision = 12, scale = 0)
	public float getDisplacement() {
		return this.displacement;
	}

	public void setDisplacement(float displacement) {
		this.displacement = displacement;
	}

	@Column(name = "gear")
	public boolean getGear() {
		return this.gear;
	}

	public void setGear(boolean gear) {
		this.gear = gear;
	}

	@Column(name = "marine_risk")
	public String getMarineRisk() {
		return this.marineRisk;
	}

	public void setMarineRisk(String marineRisk) {
		this.marineRisk = marineRisk;
	}

	@Column(name = "picture_link")
	public String getPictureLink() {
		return this.pictureLink;
	}

	public void setPictureLink(String pictureLink) {
		this.pictureLink = pictureLink;
	}

	@Column(name = "pre_authorization")
	public String getPreAuthorization() {
		return this.preAuthorization;
	}

	public void setPreAuthorization(String preAuthorization) {
		this.preAuthorization = preAuthorization;
	}

	@Column(name = "shop_name", nullable = false)
	public String getShopName() {
		return this.shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
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

	@Column(name = "link")
	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Column(name = "weight", nullable = false)
	public Integer getWeight() {
		return this.weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	@Column(name = "price")
	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}