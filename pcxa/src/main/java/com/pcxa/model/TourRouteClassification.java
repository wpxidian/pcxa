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
 * TourRouteClassification entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tour_route_classification", catalog = "pcxa")
public class TourRouteClassification implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 8862992260580448380L;
	
	private Integer tourRouteClassificationId;
	private String name;
	private Set<TourRoute> tourRoutes = new HashSet<TourRoute>(0);

	// Constructors

	/** default constructor */
	public TourRouteClassification() {
	}

	/** full constructor */
	public TourRouteClassification(String name, Set<TourRoute> tourRoutes) {
		this.name = name;
		this.tourRoutes = tourRoutes;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "tour_route_classification_id", unique = true, nullable = false)
	public Integer getTourRouteClassificationId() {
		return this.tourRouteClassificationId;
	}

	public void setTourRouteClassificationId(Integer tourRouteClassificationId) {
		this.tourRouteClassificationId = tourRouteClassificationId;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tourRouteClassification")
	public Set<TourRoute> getTourRoutes() {
		return this.tourRoutes;
	}

	public void setTourRoutes(Set<TourRoute> tourRoutes) {
		this.tourRoutes = tourRoutes;
	}

}