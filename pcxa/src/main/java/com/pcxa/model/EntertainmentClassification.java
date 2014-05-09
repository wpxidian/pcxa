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
 * EntertainmentClassification entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "entertainment_classification", catalog = "pcxa")
public class EntertainmentClassification implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -8766674459795337297L;
	private Integer entertainmentClassificationId;
	private String name;
	private Set<Entertainment> entertainments = new HashSet<Entertainment>(0);

	// Constructors

	/** default constructor */
	public EntertainmentClassification() {
	}

	/** minimal constructor */
	public EntertainmentClassification(String name) {
		this.name = name;
	}

	/** full constructor */
	public EntertainmentClassification(String name,
			Set<Entertainment> entertainments) {
		this.name = name;
		this.entertainments = entertainments;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "entertainment_classification_id", unique = true, nullable = false)
	public Integer getEntertainmentClassificationId() {
		return this.entertainmentClassificationId;
	}

	public void setEntertainmentClassificationId(
			Integer entertainmentClassificationId) {
		this.entertainmentClassificationId = entertainmentClassificationId;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "entertainmentClassification")
	public Set<Entertainment> getEntertainments() {
		return this.entertainments;
	}

	public void setEntertainments(Set<Entertainment> entertainments) {
		this.entertainments = entertainments;
	}

}