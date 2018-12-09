package com.oracelwpd.ddbookmarket.dao;

import java.util.List;

import com.oracelwpd.ddbookmarket.model.BookType;

public interface BookTypeDao {

	boolean save(BookType bookType);

	List<BookType> findAll(int currentPage, String name, int sid);

	int total(String name, int sid);

	int del(int id);

    BookType find(int id);

    boolean update(BookType bookType);
}
