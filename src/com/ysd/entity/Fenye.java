package com.ysd.entity;

import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class Fenye {
	private Integer page;
	private Integer pageSize;
	private Integer total;
	private List<Book> rows;
	private Book book;
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public List<Book> getRows() {
		return rows;
	}
	public void setRows(List<Book> rows) {
		this.rows = rows;
	}
	@Override
	public String toString() {
		return "Fenye [page=" + page + ", pageSize=" + pageSize + ", total=" + total + ", rows=" + rows + "]";
	}
	public Fenye(Integer page, Integer pageSize, Integer total, List<Book> rows) {
		super();
		this.page = page;
		this.pageSize = pageSize;
		this.total = total;
		this.rows = rows;
	}
	public Fenye() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
