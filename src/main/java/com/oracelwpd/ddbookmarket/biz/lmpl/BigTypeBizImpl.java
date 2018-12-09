package com.oracelwpd.ddbookmarket.biz.lmpl;

import java.util.List;

import com.oracelwpd.ddbookmarket.biz.BigTypeBiz;
import com.oracelwpd.ddbookmarket.dao.BigTypeDao;
import com.oracelwpd.ddbookmarket.dao.impl.BigTypeDaoImpl;
import com.oracelwpd.ddbookmarket.model.BigType;

public class BigTypeBizImpl implements BigTypeBiz {

	@Override
	public boolean save(String name) {
		BigTypeDao bigTypeDao=new BigTypeDaoImpl();
		return bigTypeDao.save(name);
	}

	@Override
	public List<BigType> findAllBigType() {
		BigTypeDao bigTypeDao=new BigTypeDaoImpl();
		return bigTypeDao.findAll();
	}

}
