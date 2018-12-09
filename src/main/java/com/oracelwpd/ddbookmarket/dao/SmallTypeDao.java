package com.oracelwpd.ddbookmarket.dao;

import java.util.List;

import com.oracelwpd.ddbookmarket.model.SmallType;

public interface SmallTypeDao {

	boolean save(SmallType smallType);

	List<SmallType> findAllByBid(int bid);

    int findBidById(int sid);
}
