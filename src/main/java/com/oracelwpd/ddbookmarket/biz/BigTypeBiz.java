package com.oracelwpd.ddbookmarket.biz;

import java.util.List;

import com.oracelwpd.ddbookmarket.model.BigType;

public interface BigTypeBiz {

	boolean save(String name);

	List<BigType> findAllBigType();

}
