package com.ysd.entity;

public class Book {
	private Integer B_Id;
	private String B_Name;
	private Integer B_Price;
	private String B_Author;
	private String B_Introduce;
	private Integer C_Id;
	private BookType booktype;
	
	
	private Integer KS_price;
	private Integer JS_price;
	public Integer getB_Id() {
		return B_Id;
	}
	public void setB_Id(Integer b_Id) {
		B_Id = b_Id;
	}
	public String getB_Name() {
		return B_Name;
	}
	public void setB_Name(String b_Name) {
		B_Name = b_Name;
	}
	public Integer getB_Price() {
		return B_Price;
	}
	public void setB_Price(Integer b_Price) {
		B_Price = b_Price;
	}
	public String getB_Author() {
		return B_Author;
	}
	public void setB_Author(String b_Author) {
		B_Author = b_Author;
	}
	public String getB_Introduce() {
		return B_Introduce;
	}
	public void setB_Introduce(String b_Introduce) {
		B_Introduce = b_Introduce;
	}
	public Integer getC_Id() {
		return C_Id;
	}
	public void setC_Id(Integer c_Id) {
		C_Id = c_Id;
	}
	public BookType getBooktype() {
		return booktype;
	}
	public void setBooktype(BookType booktype) {
		this.booktype = booktype;
	}
	public Integer getKS_price() {
		return KS_price;
	}
	public void setKS_price(Integer kS_price) {
		KS_price = kS_price;
	}
	public Integer getJS_price() {
		return JS_price;
	}
	public void setJS_price(Integer jS_price) {
		JS_price = jS_price;
	}
	@Override
	public String toString() {
		return "Book [B_Id=" + B_Id + ", B_Name=" + B_Name + ", B_Price=" + B_Price + ", B_Author=" + B_Author
				+ ", B_Introduce=" + B_Introduce + ", C_Id=" + C_Id + ", booktype=" + booktype + ", KS_price="
				+ KS_price + ", JS_price=" + JS_price + "]";
	}
	public Book(Integer b_Id, String b_Name, Integer b_Price, String b_Author, String b_Introduce, Integer c_Id,
			BookType booktype, Integer kS_price, Integer jS_price) {
		super();
		B_Id = b_Id;
		B_Name = b_Name;
		B_Price = b_Price;
		B_Author = b_Author;
		B_Introduce = b_Introduce;
		C_Id = c_Id;
		this.booktype = booktype;
		KS_price = kS_price;
		JS_price = jS_price;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
