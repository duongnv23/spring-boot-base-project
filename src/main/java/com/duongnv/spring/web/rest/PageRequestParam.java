package com.duongnv.spring.web.rest;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PageRequestParam {

	@JsonProperty(defaultValue = "0")
	private Integer page;
	@JsonProperty(defaultValue = "20")
	private Integer size;
	@JsonProperty(defaultValue = "")
	private List<FilterParam> filters;
	@JsonProperty(defaultValue = "")
	private List<SortParam> sorts;

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public List<FilterParam> getFilters() {
		return filters;
	}

	public void setFilters(List<FilterParam> filters) {
		this.filters = filters;
	}

	public List<SortParam> getSorts() {
		return sorts;
	}

	public void setSorts(List<SortParam> sorts) {
		this.sorts = sorts;
	}

}
