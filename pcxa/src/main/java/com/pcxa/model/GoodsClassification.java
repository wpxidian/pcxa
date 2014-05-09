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
 * GoodsClassification entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "goods_classification", catalog = "pcxa")
public class GoodsClassification implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 4187590895623974818L;
	
	private Integer goodsClassificationId;
	private String name;
	private Integer superClass;
	private Set<Goods> goodses = new HashSet<Goods>(0);

	// Constructors

	/** default constructor */
	public GoodsClassification() {
	}

	/** minimal constructor */
	public GoodsClassification(String name, Integer superClass) {
		this.name = name;
		this.superClass = superClass;
	}

	/** full constructor */
	public GoodsClassification(String name, Integer superClass,
			Set<Goods> goodses) {
		this.name = name;
		this.superClass = superClass;
		this.goodses = goodses;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "goods_classification_id", unique = true, nullable = false)
	public Integer getGoodsClassificationId() {
		return this.goodsClassificationId;
	}

	public void setGoodsClassificationId(Integer goodsClassificationId) {
		this.goodsClassificationId = goodsClassificationId;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "super_class", nullable = false)
	public Integer getSuperClass() {
		return this.superClass;
	}

	public void setSuperClass(Integer superClass) {
		this.superClass = superClass;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "goodsClassification")
	public Set<Goods> getGoodses() {
		return this.goodses;
	}

	public void setGoodses(Set<Goods> goodses) {
		this.goodses = goodses;
	}

}