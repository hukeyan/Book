package com.ysd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysd.dao.BookMapper;
import com.ysd.entity.Book;
import com.ysd.entity.BookType;
import com.ysd.entity.Fenye;
@Service
public class BookServiceImp implements BookService {
	@Autowired
	private BookMapper bookMapper;
	@Override
	public Fenye SelectBookAll(Fenye fenye) {
		// TODO Auto-generated method stub
		fenye.setPage((fenye.getPage()-1)*fenye.getPageSize());
		fenye.setPageSize(fenye.getPageSize());
		Integer selectBookCount = bookMapper.SelectBookCount(fenye);
		List<Book> selectBookAll = bookMapper.SelectBookAll(fenye);
		fenye.setRows(selectBookAll);
		fenye.setTotal(selectBookCount);
		return fenye;
	}
	@Override
	public List<BookType> SelectBoobTypeAll() {
		// TODO Auto-generated method stub
		List<BookType> selectBookType = bookMapper.SelectBookType();
		return selectBookType;
	}
	@Override
	public Integer UpdateBook(Book book) {
		// TODO Auto-generated method stub
		Integer i = bookMapper.UpdateBook(book);
		return i;
	}
	@Override
	public Integer InsertBook(Book book) {
		// TODO Auto-generated method stub
		Integer i = bookMapper.InsertBook(book);
		return i;
	}
	@Override
	public Integer DelBook(Integer B_Id) {
		// TODO Auto-generated method stub
		Integer i = bookMapper.DelBook(B_Id);
		return i;
	}

}
