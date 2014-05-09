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
 * CarLevel entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "car_level", catalog = "pcxa")
public class CarLevel implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer carLevelId;
	private String name;
	private Set<CarRenting> carRentings = new HashSet<CarRenting>(0);

	// Constructors

	/** default constructor */
	public CarLevel() {
	}

	/** minimal constructor */
	public CarLevel(String name) {
		this.name = name;
	}

	/** full constructor */
	public CarLevel(String name, Set<CarRenting> carRentings) {
		this.name = name;
		this.carRentings = carRentings;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "car_level_id", unique = true, nullable = false)
	public Integer getCarLevelId() {
		return this.carLevelId;
	}

	public void setCarLevelId(Integer carLevelId) {
		this.carLevelId = carLevelId;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "carLevel")
	public Set<CarRenting> getCarRentings() {
		return this.carRentings;
	}

	public void setCarRentings(Set<CarRenting> carRentings) {
		this.carRentings = carRentings;
	}

}