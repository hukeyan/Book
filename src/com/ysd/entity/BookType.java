package com.ysd.entity;

public class BookType {
	private Integer C_Id;
	private String C_Name;
	public Integer getC_Id() {
		return C_Id;
	}
	public void setC_Id(Integer c_Id) {
		C_Id = c_Id;
	}
	public String getC_Name() {
		return C_Name;
	}
	public void setC_Name(String c_Name) {
		C_Name = c_Name;
	}
	@Override
	public String toString() {
		return "BookType [C_Id=" + C_Id + ", C_Name=" + C_Name + "]";
	}
	public BookType(Integer c_Id, String c_Name) {
		super();
		C_Id = c_Id;
		C_Name = c_Name;
	}
	public BookType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
