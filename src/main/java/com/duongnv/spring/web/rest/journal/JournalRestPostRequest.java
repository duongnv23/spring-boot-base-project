package com.duongnv.spring.web.rest.journal;

import java.text.ParseException;
import java.util.Calendar;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.duongnv.spring.dao.entity.Journal;
import com.duongnv.spring.validator.Phone;

public class JournalRestPostRequest {
	@Min(1)
	private Long id;
	@NotNull
	@Size(min = 16, max = 255)
	private String title;
	@Size(max = 511)
	private String summary;
	@Phone
	private String phone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Journal toJournal() throws ParseException {
		return new Journal(id, title, summary, "11/1/2017");
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "JournalRestPostRequest [id=" + id + ", title=" + title + ", summary=" + summary + ", phone=" + phone
				+ "]";
	}

}
