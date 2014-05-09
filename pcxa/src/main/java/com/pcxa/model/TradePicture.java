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
 * TradingPicture entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "trading_picture", catalog = "pcxa")
public class TradePicture implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -8309990999054880846L;
	
	private Integer tradingPictureId;
	private Trade trading;
	private String pictureLink;

	// Constructors

	/** default constructor */
	public TradePicture() {
	}

	/** full constructor */
	public TradePicture(Trade trading, String pictureLink) {
		this.trading = trading;
		this.pictureLink = pictureLink;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "trading_picture_id", unique = true, nullable = false)
	public Integer getTradingPictureId() {
		return this.tradingPictureId;
	}

	public void setTradingPictureId(Integer tradingPictureId) {
		this.tradingPictureId = tradingPictureId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "trading_id", nullable = false)
	public Trade getTrading() {
		return this.trading;
	}

	public void setTrading(Trade trading) {
		this.trading = trading;
	}

	@Column(name = "picture_link", nullable = false)
	public String getPictureLink() {
		return this.pictureLink;
	}

	public void setPictureLink(String pictureLink) {
		this.pictureLink = pictureLink;
	}

}