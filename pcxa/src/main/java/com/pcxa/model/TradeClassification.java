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
 * TradingClassification entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "trading_classification", catalog = "pcxa")
public class TradeClassification implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -2706213575632293496L;
	
	private Integer tradeClassificationId;
	private String name;
	private String introduction;
	private String pictureLink;
	private String address;
	private String briefIntroduction;
	private Set<Trade> tradings = new HashSet<Trade>(0);

	// Constructors

	/** default constructor */
	public TradeClassification() {
	}

	/** minimal constructor */
	public TradeClassification(String name) {
		this.name = name;
	}

	/** full constructor */
	public TradeClassification(String name, String introduction,
			String pictureLink, String address, String briefIntroduction,
			Set<Trade> tradings) {
		this.name = name;
		this.introduction = introduction;
		this.pictureLink = pictureLink;
		this.address = address;
		this.briefIntroduction = briefIntroduction;
		this.tradings = tradings;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "trading_classification_id", unique = true, nullable = false)
	public Integer getTradeClassificationId() {
		return this.tradeClassificationId;
	}

	public void setTradeClassificationId(Integer tradeClassificationId) {
		this.tradeClassificationId = tradeClassificationId;
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

	@Column(name = "address")
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "brief_introduction")
	public String getBriefIntroduction() {
		return this.briefIntroduction;
	}

	public void setBriefIntroduction(String briefIntroduction) {
		this.briefIntroduction = briefIntroduction;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tradeClassification")
	public Set<Trade> getTradings() {
		return this.tradings;
	}

	public void setTradings(Set<Trade> tradings) {
		this.tradings = tradings;
	}

}