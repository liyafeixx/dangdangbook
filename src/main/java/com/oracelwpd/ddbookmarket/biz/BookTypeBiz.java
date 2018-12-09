package com.oracelwpd.ddbookmarket.biz;

import java.util.List;

import com.oracelwpd.ddbookmarket.model.BookType;

public interface BookTypeBiz {

	boolean save(BookType bookType);

	List<BookType> findAll(int currentPage, String name, int sid);

	int totalRow(String name, int sid);

	int delById(int id);

    BookType findBookById(int id);

    boolean update(BookType bookType);
}
