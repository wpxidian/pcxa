package com.pcxa.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Goods entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "goods", catalog = "pcxa")
public class Goods implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -3906263852285368757L;
	
	private Integer goodsId;
	private Shop shop;
	private GoodsClassification goodsClassification;
	private String name;
	private Integer weight;
	private String introduction;
	private Integer quantityLeft;
	private float price;
	private String pictureLink;
	private String sendMethod;
	private Integer state;
	private Set<Indent> indents = new HashSet<Indent>(0);

	// Constructors

	/** default constructor */
	public Goods() {
	}

	/** minimal constructor */
	public Goods(Shop shop, GoodsClassification goodsClassification,
			String name, Integer weight, Integer quantityLeft, float price,
			String sendMethod, Integer state) {
		this.shop = shop;
		this.goodsClassification = goodsClassification;
		this.name = name;
		this.weight = weight;
		this.quantityLeft = quantityLeft;
		this.price = price;
		this.sendMethod = sendMethod;
		this.state = state;
	}

	/** full constructor */
	public Goods(Shop shop, GoodsClassification goodsClassification,
			String name, Integer weight, String introduction,
			Integer quantityLeft, float price, String pictureLink,
			String sendMethod, Integer state) {
		this.shop = shop;
		this.goodsClassification = goodsClassification;
		this.name = name;
		this.weight = weight;
		this.introduction = introduction;
		this.quantityLeft = quantityLeft;
		this.price = price;
		this.pictureLink = pictureLink;
		this.sendMethod = sendMethod;
		this.state = state;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "goods_id", unique = true, nullable = false)
	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
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
	@JoinColumn(name = "goods_classification_id", nullable = false)
	public GoodsClassification getGoodsClassification() {
		return this.goodsClassification;
	}

	public void setGoodsClassification(GoodsClassification goodsClassification) {
		this.goodsClassification = goodsClassification;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "weight", nullable = false)
	public Integer getWeight() {
		return this.weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	@Column(name = "introduction", length = 65535)
	public String getIntroduction() {
		return this.introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	@Column(name = "quantity_left", nullable = false)
	public Integer getQuantityLeft() {
		return this.quantityLeft;
	}

	public void setQuantityLeft(Integer quantityLeft) {
		this.quantityLeft = quantityLeft;
	}

	@Column(name = "price", nullable = false, precision = 10)
	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Column(name = "picture_link", length = 500)
	public String getPictureLink() {
		return this.pictureLink;
	}

	public void setPictureLink(String pictureLink) {
		this.pictureLink = pictureLink;
	}

	@Column(name = "send_method", nullable = false)
	public String getSendMethod() {
		return this.sendMethod;
	}

	public void setSendMethod(String sendMethod) {
		this.sendMethod = sendMethod;
	}

	@Column(name = "state", nullable = false)
	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "goods")
	public Set<Indent> getIndents() {
		return this.indents;
	}

	public void setIndents(Set<Indent> indents) {
		this.indents = indents;
	}

}