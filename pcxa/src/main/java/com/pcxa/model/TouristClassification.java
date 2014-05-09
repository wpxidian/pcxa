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
 * TouristClassification entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tourist_classification", catalog = "pcxa")
public class TouristClassification implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 2865236356427364140L;
	
	private Integer touristClassificationId;
	private String name;
	private Set<TouristSpot> touristSpots = new HashSet<TouristSpot>(0);

	// Constructors

	/** default constructor */
	public TouristClassification() {
	}

	/** minimal constructor */
	public TouristClassification(String name) {
		this.name = name;
	}

	/** full constructor */
	public TouristClassification(String name, Set<TouristSpot> touristSpots) {
		this.name = name;
		this.touristSpots = touristSpots;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "tourist_classification_id", unique = true, nullable = false)
	public Integer getTouristClassificationId() {
		return this.touristClassificationId;
	}

	public void setTouristClassificationId(Integer touristClassificationId) {
		this.touristClassificationId = touristClassificationId;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "touristClassification")
	public Set<TouristSpot> getTouristSpots() {
		return this.touristSpots;
	}

	public void setTouristSpots(Set<TouristSpot> touristSpots) {
		this.touristSpots = touristSpots;
	}

}