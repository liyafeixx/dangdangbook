package com.oracelwpd.ddbookmarket.dao;

import java.util.List;

import com.oracelwpd.ddbookmarket.model.BigType;

public interface BigTypeDao {

	boolean save(String name);

	List<BigType> findAll();

}
