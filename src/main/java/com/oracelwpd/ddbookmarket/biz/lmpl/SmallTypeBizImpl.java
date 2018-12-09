package com.oracelwpd.ddbookmarket.biz.lmpl;

import java.util.List;

import com.oracelwpd.ddbookmarket.biz.SmallTypeBiz;
import com.oracelwpd.ddbookmarket.dao.SmallTypeDao;
import com.oracelwpd.ddbookmarket.dao.impl.SmallTypeDaoImpl;
import com.oracelwpd.ddbookmarket.model.SmallType;


public class SmallTypeBizImpl implements SmallTypeBiz {

	@Override
	public boolean save(SmallType smallType) {
		SmallTypeDao smallTypeDao=new SmallTypeDaoImpl();
		return smallTypeDao.save(smallType);
	}

	@Override
	public List<SmallType> findAllByBid(int bid) {
		SmallTypeDao smallTypeDao=new SmallTypeDaoImpl();
		return smallTypeDao.findAllByBid(bid);
	}

	@Override
	public int findBidById(int sid) {
		SmallTypeDao smallTypeDao=new SmallTypeDaoImpl();
		return smallTypeDao.findBidById(sid);
	}


}
