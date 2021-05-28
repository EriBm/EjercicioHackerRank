package com.example.EjercicioHackerRank.controller;

import java.util.List;


public class JSONResponse {
	
	private Integer page;
	
	private Integer perPage;
	
	private Integer total;
	
	private Integer totalPages;
	
	private List<DataResponse> data;

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPerPage() {
		return perPage;
	}

	public void setPerPage(Integer perPage) {
		this.perPage = perPage;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	public List<DataResponse> getData() {
		return data;
	}

	public void setData(List<DataResponse> data) {
		this.data = data;
	}

}
