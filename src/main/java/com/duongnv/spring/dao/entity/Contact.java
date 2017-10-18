package com.duongnv.spring.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONTACT")
public class Contact implements java.io.Serializable {

	private Long id;
	private String first;
	private String last;
	private String middle;
	private String notes;
	private Boolean starred;
	private String website;

	public Contact() {
	}

	public Contact(Long id) {
		this.id = id;
	}

	public Contact(Long id, String first, String last, String middle, String notes, Boolean starred, String website) {
		this.id = id;
		this.first = first;
		this.last = last;
		this.middle = middle;
		this.notes = notes;
		this.starred = starred;
		this.website = website;
	}

	@Id

	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "FIRST")
	public String getFirst() {
		return this.first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	@Column(name = "LAST")
	public String getLast() {
		return this.last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	@Column(name = "MIDDLE")
	public String getMiddle() {
		return this.middle;
	}

	public void setMiddle(String middle) {
		this.middle = middle;
	}

	@Column(name = "NOTES")
	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Column(name = "STARRED", precision = 1, scale = 0)
	public Boolean getStarred() {
		return this.starred;
	}

	public void setStarred(Boolean starred) {
		this.starred = starred;
	}

	@Column(name = "WEBSITE")
	public String getWebsite() {
		return this.website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

}
