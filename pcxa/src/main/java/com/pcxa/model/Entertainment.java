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
 * Entertainment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "entertainment", catalog = "pcxa")
public class Entertainment implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -6712664024547818237L;
	private Integer entertainmentId;
	private Shop shop;
	private EntertainmentClassification entertainmentClassification;
	private String name;
	private String pictureLink;
	private String briefIntroduction;
	private String introduction;
	private String address;
	private String phone;
	private String bus;
	private Integer weight;
	private Set<EntertainmentPicture> entertainmentPictures = new HashSet<EntertainmentPicture>(
			0);

	// Constructors

	/** default constructor */
	public Entertainment() {
	}

	/** minimal constructor */
	public Entertainment(Shop shop,
			EntertainmentClassification entertainmentClassification,
			String name, String pictureLink, Integer weight) {
		this.shop = shop;
		this.entertainmentClassification = entertainmentClassification;
		this.name = name;
		this.pictureLink = pictureLink;
		this.weight = weight;
	}

	/** full constructor */
	public Entertainment(Shop shop,
			EntertainmentClassification entertainmentClassification,
			String name, String pictureLink, String briefIntroduction,
			String introduction, String address, String phone, String bus,
			Integer weight) {
		this.shop = shop;
		this.entertainmentClassification = entertainmentClassification;
		this.name = name;
		this.pictureLink = pictureLink;
		this.briefIntroduction = briefIntroduction;
		this.introduction = introduction;
		this.address = address;
		this.phone = phone;
		this.bus = bus;
		this.weight = weight;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "entertainment_id", unique = true, nullable = false)
	public Integer getEntertainmentId() {
		return this.entertainmentId;
	}

	public void setEntertainmentId(Integer entertainmentId) {
		this.entertainmentId = entertainmentId;
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
	@JoinColumn(name = "entertainment_classification_id", nullable = false)
	public EntertainmentClassification getEntertainmentClassification() {
		return this.entertainmentClassification;
	}

	public void setEntertainmentClassification(
			EntertainmentClassification entertainmentClassification) {
		this.entertainmentClassification = entertainmentClassification;
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

	@Column(name = "brief_introduction", length = 65535)
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "entertainment")
	public Set<EntertainmentPicture> getEntertainmentPictures() {
		return this.entertainmentPictures;
	}

	public void setEntertainmentPictures(
			Set<EntertainmentPicture> entertainmentPictures) {
		this.entertainmentPictures = entertainmentPictures;
	}

}