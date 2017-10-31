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
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "USERS", uniqueConstraints = @UniqueConstraint(columnNames = "USERNAME"))
public class Users implements java.io.Serializable {

	@Id
	@Column(name = "ID", unique = true, nullable = false, precision = 38, scale = 0)
	private Long id;

	@Column(name = "USERNAME", unique = true, nullable = false, length = 128)
	private String username;

	@Column(name = "PASSWORD", nullable = false, length = 512)
	private String password;

	@Column(name = "ENABLED", nullable = false, precision = 1, scale = 0)
	private boolean enabled;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "USERS_AUTHORITIES", joinColumns = {
			@JoinColumn(name = "USERS_ID", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "AUTHORITIES_ID", nullable = false, updatable = false) })
	private Set<Authorities> authoritieses = new HashSet<Authorities>(0);

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "GROUPS_MEMBERS", joinColumns = {
			@JoinColumn(name = "USERS_ID", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "GROUPS_ID", nullable = false, updatable = false) })
	private Set<Groups> groupses = new HashSet<Groups>(0);

	public Users() {
	}

	public Users(Long id, String username, String password, boolean enabled) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}

	public Users(Long id, String username, String password, boolean enabled, Set<Authorities> authoritieses,
			Set<Groups> groupses) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.authoritieses = authoritieses;
		this.groupses = groupses;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Authorities> getAuthoritieses() {
		return this.authoritieses;
	}

	public void setAuthoritieses(Set<Authorities> authoritieses) {
		this.authoritieses = authoritieses;
	}

	public Set<Groups> getGroupses() {
		return this.groupses;
	}

	public void setGroupses(Set<Groups> groupses) {
		this.groupses = groupses;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", password=" + password + ", enabled=" + enabled
				+ ", authoritieses=" + authoritieses + ", groupses=" + groupses + "]";
	}

}
