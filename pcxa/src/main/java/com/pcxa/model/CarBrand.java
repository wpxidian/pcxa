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
 * CarBrand entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "car_brand", catalog = "pcxa")
public class CarBrand implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -8084623667879967955L;
	
	private Integer carBrandId;
	private String name;
	private Set<CarRenting> carRentings = new HashSet<CarRenting>(0);

	// Constructors

	/** default constructor */
	public CarBrand() {
	}

	/** minimal constructor */
	public CarBrand(String name) {
		this.name = name;
	}

	/** full constructor */
	public CarBrand(String name, Set<CarRenting> carRentings) {
		this.name = name;
		this.carRentings = carRentings;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "car_brand_id", unique = true, nullable = false)
	public Integer getCarBrandId() {
		return this.carBrandId;
	}

	public void setCarBrandId(Integer carBrandId) {
		this.carBrandId = carBrandId;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "carBrand")
	public Set<CarRenting> getCarRentings() {
		return this.carRentings;
	}

	public void setCarRentings(Set<CarRenting> carRentings) {
		this.carRentings = carRentings;
	}

}