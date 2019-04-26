package com.ysd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ysd.entity.Book;
import com.ysd.entity.BookType;
import com.ysd.entity.Fenye;
import com.ysd.service.BookService;

@Controller
public class BookController {
	@Autowired
	private BookService bookService;
	@RequestMapping(value="/selectbook",method=RequestMethod.POST)
	@ResponseBody
	public Fenye SelectBookAll(Integer rows,Integer page,Book book) {
		Fenye fenye=new Fenye();
		fenye.setPage(page);
		fenye.setPageSize(rows);
		fenye.setBook(book);
		Fenye selectBookAll = bookService.SelectBookAll(fenye);
		return selectBookAll;
	}
	@RequestMapping(value="/selectbooktype",method=RequestMethod.POST)
	@ResponseBody
	public List<BookType> SelectBookTypeAll(){
		List<BookType> selectBoobTypeAll = bookService.SelectBoobTypeAll();
		return selectBoobTypeAll;
	}
	@RequestMapping(value="/updatebook",method=RequestMethod.POST)
	@ResponseBody
	public Integer UpdateBook(Book book) {
		Integer i = bookService.UpdateBook(book);
		return i;
	}
	@RequestMapping(value="/insertbook",method=RequestMethod.POST)
	@ResponseBody
	public Integer InsertBook(Book book) {
		Integer i = bookService.InsertBook(book);
		return i;
	}
	@RequestMapping(value="/delbook",method=RequestMethod.POST)
	@ResponseBody
	public Integer DelBook(Integer B_Id) {
		Integer i = bookService.DelBook(B_Id);
		return i;
	}
}
