package com.ysd.dao;

import java.util.List;

import com.ysd.entity.Book;
import com.ysd.entity.BookType;
import com.ysd.entity.Fenye;

public interface BookMapper {
	/**
	 * ��ѯ��������
	 * @return ������
	 */
	Integer SelectBookCount(Fenye fenye);
	/**
	 * ��ѯ���ݼ���
	 * @return Book���ݼ���
	 */
	List<Book> SelectBookAll(Fenye fenye);
	/**
	 * ��ѯ�鼮����
	 * @return
	 */
	List<BookType> SelectBookType();
	/**
	 * �޸��鼮��Ϣ
	 * @param book
	 * @return
	 */
	Integer UpdateBook(Book book);
	/**
	 * ����鼮
	 * @param book
	 * @return
	 */
	Integer InsertBook(Book book);
	/**
	 * ɾ���鼮
	 * @param book
	 * @return
	 */
	Integer DelBook(Integer B_Id);
}
