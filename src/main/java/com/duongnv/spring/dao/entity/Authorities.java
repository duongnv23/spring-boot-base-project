package com.duongnv.spring.dao.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "AUTHORITIES", uniqueConstraints = @UniqueConstraint(columnNames = "AUTHORITY"))
public class Authorities implements java.io.Serializable {

	@Id
	@Column(name = "ID", unique = true, nullable = false, precision = 38, scale = 0)
	private Long id;

	@Column(name = "AUTHORITY", unique = true, nullable = false, length = 256)
	private String authority;

	@Column(name = "DESCRIPTION", length = 512)
	private String description;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "USERS_AUTHORITIES", joinColumns = {
			@JoinColumn(name = "AUTHORITIES_ID", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "USERS_ID", nullable = false, updatable = false) })
	private Set<Users> userses = new HashSet<Users>(0);

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "GROUPS_AUTHORITIES", joinColumns = {
			@JoinColumn(name = "AUTHORITIES_ID", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "GROUPS_ID", nullable = false, updatable = false) })
	private Set<Groups> groupses = new HashSet<Groups>(0);

	public Authorities() {
	}

	public Authorities(Long id, String authority) {
		this.id = id;
		this.authority = authority;
	}

	public Authorities(Long id, String authority, String description, Set<Users> userses, Set<Groups> groupses) {
		this.id = id;
		this.authority = authority;
		this.description = description;
		this.userses = userses;
		this.groupses = groupses;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthority() {
		return this.authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Users> getUserses() {
		return this.userses;
	}

	public void setUserses(Set<Users> userses) {
		this.userses = userses;
	}

	public Set<Groups> getGroupses() {
		return this.groupses;
	}

	public void setGroupses(Set<Groups> groupses) {
		this.groupses = groupses;
	}

	@Override
	public String toString() {
		return "Authorities [id=" + id + ", authority=" + authority + ", description=" + description + ", userses="
				+ userses + ", groupses=" + groupses + "]";
	}

}
