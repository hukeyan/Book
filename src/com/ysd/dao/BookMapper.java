package com.ysd.dao;

import java.util.List;

import com.ysd.entity.Book;
import com.ysd.entity.BookType;
import com.ysd.entity.Fenye;

public interface BookMapper {
	/**
	 * 查询数据总数
	 * @return 总条数
	 */
	Integer SelectBookCount(Fenye fenye);
	/**
	 * 查询数据集合
	 * @return Book数据集合
	 */
	List<Book> SelectBookAll(Fenye fenye);
	/**
	 * 查询书籍分类
	 * @return
	 */
	List<BookType> SelectBookType();
	/**
	 * 修改书籍信息
	 * @param book
	 * @return
	 */
	Integer UpdateBook(Book book);
	/**
	 * 添加书籍
	 * @param book
	 * @return
	 */
	Integer InsertBook(Book book);
	/**
	 * 删除书籍
	 * @param book
	 * @return
	 */
	Integer DelBook(Integer B_Id);
}
