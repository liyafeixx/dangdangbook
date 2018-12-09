package com.oracelwpd.ddbookmarket.biz.lmpl;

import com.oracelwpd.ddbookmarket.biz.AdminBiz;
import com.oracelwpd.ddbookmarket.dao.AdminDao;
import com.oracelwpd.ddbookmarket.dao.impl.AdminDaoImpl;
import com.oracelwpd.ddbookmarket.model.Admin;

public class AdminBizImpl implements AdminBiz {
    @Override
    public boolean findAdmin(Admin admin) {
        AdminDao adminDao=new AdminDaoImpl();
        return adminDao.find(admin);
    }
}
