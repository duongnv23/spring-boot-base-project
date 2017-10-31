package com.duongnv.spring.dao.entity;

import java.util.Arrays;
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

@Entity
@Table(name = "GROUPS")
public class Groups implements java.io.Serializable {

	@Id
	@Column(name = "ID", unique = true, nullable = false, precision = 38, scale = 0)
	private Long id;

	@Column(name = "NAME", length = 512)
	private String name;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "GROUPS_AUTHORITIES", joinColumns = {
			@JoinColumn(name = "GROUPS_ID", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "AUTHORITIES_ID", nullable = false, updatable = false) })
	private Set<Authorities> authoritieses = new HashSet<Authorities>(0);

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "GROUPS_MEMBERS", joinColumns = {
			@JoinColumn(name = "GROUPS_ID", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "USERS_ID", nullable = false, updatable = false) })
	private Set<Users> userses = new HashSet<Users>(0);

	public Groups() {
	}

	public Groups(Long id) {
		this.id = id;
	}

	public Groups(Long id, String name, Set<Authorities> authoritieses, Set<Users> userses) {
		this.id = id;
		this.name = name;
		this.authoritieses = authoritieses;
		this.userses = userses;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Authorities> getAuthoritieses() {
		return this.authoritieses;
	}

	public void setAuthoritieses(Set<Authorities> authoritieses) {
		this.authoritieses = authoritieses;
	}

	public Set<Users> getUserses() {
		return this.userses;
	}

	public void setUserses(Set<Users> userses) {
		this.userses = userses;
	}

	@Override
	public String toString() {
		return "Groups [id=" + id + ", name=" + name + ", authoritieses=" + authoritieses + ", userses=" + userses
				+ "]";
	}

}
