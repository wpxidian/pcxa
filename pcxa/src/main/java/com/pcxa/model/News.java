package com.pcxa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * News entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "news", catalog = "pcxa")
public class News implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -1773444681368823732L;
	private Integer newsId;
	private String title;
	private String introduction;
	private String pictureLink;
	private String time;

	// Constructors

	/** default constructor */
	public News() {
	}

	/** minimal constructor */
	public News(String introduction) {
		this.introduction = introduction;
	}

	/** full constructor */
	public News(String title, String introduction, String pictureLink,
			String time) {
		this.title = title;
		this.introduction = introduction;
		this.pictureLink = pictureLink;
		this.time = time;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "news_id", unique = true, nullable = false)
	public Integer getNewsId() {
		return this.newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

	@Column(name = "title")
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "introduction", nullable = false, length = 65535)
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

	@Column(name = "time")
	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}