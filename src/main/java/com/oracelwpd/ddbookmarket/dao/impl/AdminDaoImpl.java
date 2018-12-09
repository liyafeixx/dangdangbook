package com.oracelwpd.ddbookmarket.dao.impl;

import com.oracelwpd.ddbookmarket.dao.AdminDao;
import com.oracelwpd.ddbookmarket.model.Admin;
import com.oracelwpd.ddbookmarket.model.BigType;
import com.oracelwpd.ddbookmarket.util.DBUtils;
import com.oracelwpd.ddbookmarket.util.MD5Util;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDaoImpl implements AdminDao {
    @Override
    public boolean find(Admin admin) {
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        try {
            conn= DBUtils.getConnection();
           /* String sql="select * from t_Admin where name=? and pwd=?";
            stmt=conn.prepareStatement(sql);
            stmt.setString(1,admin.getName());
            try {
                stmt.setString(2, MD5Util.getEncryptedPwd(admin.getPwd()));
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }*/
           //盐在数据库，每次加密后的盐都不一样，所以需要从数据库中拿到盐
            String sql="select pwd from t_Admin where name=?";
            stmt=conn.prepareStatement(sql);
            stmt.setString(1,admin.getName());
            rs=stmt.executeQuery();
            if (rs.next()) {
                String dbPwd=rs.getString(1);
                try {
                    //用户输入的和数据库里的进行对比
                    return MD5Util.validPasswd(admin.getPwd(),dbPwd);
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            DBUtils.free(rs, stmt, conn);
        }
        return false;
    }
}
