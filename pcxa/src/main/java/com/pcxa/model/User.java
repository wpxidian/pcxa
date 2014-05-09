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
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user", catalog = "pcxa")
public class User implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 4135830638070966057L;
	private Integer userId;
	private String username;
	private String password;
	private String pid;
	private String mailBox;
	private Integer weight;
	private Set<Indent> indents = new HashSet<Indent>(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String username, String password, String pid, String mailBox,
			Integer weight) {
		this.username = username;
		this.password = password;
		this.pid = pid;
		this.mailBox = mailBox;
		this.weight = weight;
	}

	/** full constructor */
	public User(String username, String password, String pid, String mailBox,
			Integer weight, Set<Indent> indents) {
		this.username = username;
		this.password = password;
		this.pid = pid;
		this.mailBox = mailBox;
		this.weight = weight;
		this.indents = indents;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "user_id", unique = true, nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "username", nullable = false)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "pid", nullable = false)
	public String getPid() {
		return this.pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	@Column(name = "mail_box", nullable = false)
	public String getMailBox() {
		return this.mailBox;
	}

	public void setMailBox(String mailBox) {
		this.mailBox = mailBox;
	}

	@Column(name = "weight", nullable = false)
	public Integer getWeight() {
		return this.weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Indent> getIndents() {
		return this.indents;
	}

	public void setIndents(Set<Indent> indents) {
		this.indents = indents;
	}

}