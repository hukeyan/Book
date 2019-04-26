package com.ysd.service;

import java.util.List;

import com.ysd.entity.Book;
import com.ysd.entity.BookType;
import com.ysd.entity.Fenye;

public interface BookService {
	Fenye SelectBookAll(Fenye fenye);
	List<BookType> SelectBoobTypeAll();
	Integer UpdateBook(Book book);
	Integer InsertBook(Book book);
	Integer DelBook(Integer B_Id);
}
