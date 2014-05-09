package com.pcxa.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Indent entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "indent", catalog = "pcxa")
public class Indent implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -4284966424835531583L;
	private Integer indentId;
	private User user;
	private Goods goods;
	private String number;
	private Integer tradeCondition;
	private Integer count;
	private float price;
	private String phone;
	private String address;
	private Date buyTime;

	// Constructors

	/** default constructor */
	public Indent() {
	}

	/** minimal constructor */
	public Indent(User user, Goods goods, String number,
			Integer tradeCondition, Integer count, float price, String phone,
			Date buyTime) {
		this.user = user;
		this.goods = goods;
		this.number = number;
		this.tradeCondition = tradeCondition;
		this.count = count;
		this.price = price;
		this.phone = phone;
		this.buyTime = buyTime;
	}

	/** full constructor */
	public Indent(User user, Goods goods, String number,
			Integer tradeCondition, Integer count, float price, String phone,
			String address, Date buyTime) {
		this.user = user;
		this.goods = goods;
		this.number = number;
		this.tradeCondition = tradeCondition;
		this.count = count;
		this.price = price;
		this.phone = phone;
		this.address = address;
		this.buyTime = buyTime;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "indent_id", unique = true, nullable = false)
	public Integer getIndentId() {
		return this.indentId;
	}

	public void setIndentId(Integer indentId) {
		this.indentId = indentId;
	}

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne
	@JoinColumn(name = "goods_id", nullable = false)
	public Goods getGoods() {
		return this.goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	@Column(name = "number", nullable = false, length = 50)
	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Column(name = "trade_condition", nullable = false)
	public Integer getTradeCondition() {
		return this.tradeCondition;
	}

	public void setTradeCondition(Integer tradeCondition) {
		this.tradeCondition = tradeCondition;
	}

	@Column(name = "count", nullable = false)
	public Integer getCount() {
		return this.count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Column(name = "price", nullable = false, precision = 10)
	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Column(name = "phone", nullable = false, length = 50)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "address")
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "buy_time", nullable = false, length = 19)
	public Date getBuyTime() {
		return this.buyTime;
	}

	public void setBuyTime(Date buyTime) {
		this.buyTime = buyTime;
	}

}