package com.oracelwpd.ddbookmarket.biz.lmpl;

import java.util.List;

import com.oracelwpd.ddbookmarket.biz.BookTypeBiz;
import com.oracelwpd.ddbookmarket.dao.BookTypeDao;
import com.oracelwpd.ddbookmarket.dao.impl.BookTypeDaoImpl;
import com.oracelwpd.ddbookmarket.model.BookType;

public class BookTypeBizImpl implements BookTypeBiz {

	@Override
	public boolean save(BookType bookType) {
		BookTypeDao bookTypeDao=new BookTypeDaoImpl();
		return bookTypeDao.save(bookType);
	}

	@Override
	public List<BookType> findAll(int currentPage,String name,int sid) {
		BookTypeDao bookTypeDao=new BookTypeDaoImpl();
		return bookTypeDao.findAll(currentPage,name,sid);
	}

	@Override
	public int totalRow(String name,int sid) {
		BookTypeDao bookTypeDao=new BookTypeDaoImpl();
		return bookTypeDao.total(name,sid);
	}

	@Override
	public int delById(int id) {
		BookTypeDao bookTypeDao=new BookTypeDaoImpl();
		return bookTypeDao.del(id);
	}

	@Override
	public BookType findBookById(int id) {
		BookTypeDao bookTypeDao=new BookTypeDaoImpl();
		return bookTypeDao.find(id);
	}

	@Override
	public boolean update(BookType bookType) {
		BookTypeDao bookTypeDao=new BookTypeDaoImpl();
		return bookTypeDao.update(bookType);
	}

}
