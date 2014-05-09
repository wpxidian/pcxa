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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Shop entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "shop", catalog = "pcxa")
public class Shop implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 2603227942734636543L;
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "shop_id", unique = true, nullable = false)
	private Integer shopId;
	@Column(name = "username", nullable = false)
	private String username;
	@Column(name = "password", nullable = false)
	private String password;
	@Column(name = "weight", nullable = false)
	private Integer weight;
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "introduction", length = 65535)
	private String introduction;
	@Column(name = "mail_box", nullable = false)
	private String mailBox;
	@Column(name = "phone", nullable = false)
	private String phone;
	@Column(name = "account", nullable = false)
	private String account;
	@Column(name = "picture_link")
	private String pictureLink;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "shop")
	private Set<TouristSpot> touristSpots = new HashSet<TouristSpot>(0);
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "shop")
	private Set<TourRoute> tourRoutes = new HashSet<TourRoute>(0);
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "shop")
	private Set<Goods> goodses = new HashSet<Goods>(0);

	// Constructors

	/** default constructor */
	public Shop() {
	}

	/** minimal constructor */
	public Shop(String username, String password, Integer weight, String name,
			String mailBox, String phone, String account) {
		this.username = username;
		this.password = password;
		this.weight = weight;
		this.name = name;
		this.mailBox = mailBox;
		this.phone = phone;
		this.account = account;
	}

	/** full constructor */
	public Shop(String username, String password, Integer weight, String name,
			String introduction, String mailBox, String phone, String account,
			String pictureLink, Set<TouristSpot> touristSpots,
			Set<TourRoute> tourRoutes, Set<Goods> goodses) {
		this.username = username;
		this.password = password;
		this.weight = weight;
		this.name = name;
		this.introduction = introduction;
		this.mailBox = mailBox;
		this.phone = phone;
		this.account = account;
		this.pictureLink = pictureLink;
		this.touristSpots = touristSpots;
		this.tourRoutes = tourRoutes;
		this.goodses = goodses;
	}

	// Property accessors
	
	public Integer getShopId() {
		return this.shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Integer getWeight() {
		return this.weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIntroduction() {
		return this.introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	
	public String getMailBox() {
		return this.mailBox;
	}

	public void setMailBox(String mailBox) {
		this.mailBox = mailBox;
	}
	
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
	
	public String getPictureLink() {
		return this.pictureLink;
	}

	public void setPictureLink(String pictureLink) {
		this.pictureLink = pictureLink;
	}

	public Set<TouristSpot> getTouristSpots() {
		return this.touristSpots;
	}

	public void setTouristSpots(Set<TouristSpot> touristSpots) {
		this.touristSpots = touristSpots;
	}

	public Set<TourRoute> getTourRoutes() {
		return this.tourRoutes;
	}

	public void setTourRoutes(Set<TourRoute> tourRoutes) {
		this.tourRoutes = tourRoutes;
	}

	public Set<Goods> getGoodses() {
		return this.goodses;
	}

	public void setGoodses(Set<Goods> goodses) {
		this.goodses = goodses;
	}

}