package com.oracelwpd.ddbookmarket.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.oracelwpd.ddbookmarket.dao.BookTypeDao;
import com.oracelwpd.ddbookmarket.model.BookType;
import com.oracelwpd.ddbookmarket.util.DBUtils;
import com.oracelwpd.ddbookmarket.util.PageContstant;

public class BookTypeDaoImpl implements BookTypeDao {

	@Override
	public boolean save(BookType bookType) {
		Connection conn=null;
		PreparedStatement stmt=null;
		try {
			conn=DBUtils.getConnection();
			stmt=conn.prepareStatement("insert into t_book_type values(default,?,?,?,?,?,?,?,?)");
			stmt.setString(1, bookType.getName());
			stmt.setDouble(2, bookType.getPrice());
			stmt.setString(3, bookType.getAuthor());
			stmt.setString(4, bookType.getCbs());
			stmt.setDate(5, new java.sql.Date(bookType.getCdDate().getTime()));
			stmt.setString(6, bookType.getDescri());
			stmt.setInt(7, bookType.getSid());
			stmt.setString(8, bookType.getPhoto());
			int ret=stmt.executeUpdate();
			if(ret>0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.free(stmt, conn);

	}
		return false;
	}

	@Override
	public List<BookType> findAll(int currentPage,String name,int sid) {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			conn=DBUtils.getConnection();
			stmt=conn.createStatement();
			//四种情况
			/*if((name==null||name.equals(""))&&sid==-1) {
				
			}
			if((name!=null&&!name.equals(""))&&(sid==-1)){
				sql+="where name like '%"+name+"%' ";
			}
		    if ((name==null||name.equals(""))&&sid!=-1) {
				sql+=" where sid="+sid;
			}
		    if ((name!=null&&!name.equals(""))&&(sid!=-1)) {
				sql+=" where name like '%\"+name+\"%' and sid="+sid;
			}*/
			String sql="select * from t_book_type  where 1=1 ";
			if(name!=null&&!name.equals("")) {
				sql+=" and name like '%"+name+"%' ";
			}
			if (sid!=-1) {
				sql+=" and sid="+sid;
			}
			sql+="  limit "+((currentPage-1)*PageContstant.PAGE_SIZE+1-1)+","+PageContstant.PAGE_SIZE;
			rs=stmt.executeQuery(sql);
			List<BookType> ls=new ArrayList<>();
			while (rs.next()) {
				BookType bookType=new BookType();
				bookType.setId(rs.getInt("id"));
				bookType.setName(rs.getString("name"));
				bookType.setPrice(rs.getDouble("price"));
				bookType.setAuthor(rs.getString("author"));
				bookType.setCbs(rs.getString("cbs"));
				bookType.setCdDate(rs.getDate("cdDate"));
				bookType.setDescri(rs.getString("descri"));
				bookType.setSid(rs.getInt("sid"));
				bookType.setPhoto(rs.getString("photo"));
				ls.add(bookType);
			}
			return ls;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.free(rs, stmt, conn);
		}
		return null;
	}

	@Override
	public int total(String name,int sid) {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			conn=DBUtils.getConnection();
			stmt=conn.createStatement();
			String sql="select count(*) from t_book_type where 1=1 ";
			if(name!=null&&!name.equals("")) {
				sql+=" and name like '%"+name+"%' ";
			}
			if (sid!=-1) {
				sql+=" and sid="+sid;
			}
			rs=stmt.executeQuery(sql);
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.free(rs, stmt, conn);
		}
		return 0;
	}

	@Override
	public int del(int id) {
		Connection conn=null;
		PreparedStatement stmt=null;
		try {
			conn=DBUtils.getConnection();
			stmt=conn.prepareStatement("delete from t_book_type where id="+id);
			int ret=stmt.executeUpdate();
				return ret;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.free(stmt, conn);

	}
		return 0;
	}

	@Override
	public BookType find(int id) {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			conn=DBUtils.getConnection();
			stmt=conn.createStatement();
			String sql="select * from t_book_type  where id="+id;
			rs=stmt.executeQuery(sql);

			if (rs.next()) {
				BookType bookType = new BookType();
				bookType.setId(rs.getInt("id"));
				bookType.setName(rs.getString("name"));
				bookType.setPrice(rs.getDouble("price"));
				bookType.setAuthor(rs.getString("author"));
				bookType.setCbs(rs.getString("cbs"));
				bookType.setCdDate(rs.getDate("cdDate"));
				bookType.setDescri(rs.getString("descri"));
				bookType.setSid(rs.getInt("sid"));
				bookType.setPhoto(rs.getString("photo"));
				return bookType;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.free(rs, stmt, conn);
		}
		return null;
	}

	@Override
	public boolean update(BookType bookType) {
		Connection conn=null;
		PreparedStatement stmt=null;
		try {
			conn=DBUtils.getConnection();
			if(bookType.getPhoto()==null){
				stmt=conn.prepareStatement("update t_book_type set name=?,price=?,author=?,cbs=?,cdDate=?,descri=?,sid=? where id=?");
				stmt.setString(1, bookType.getName());
				stmt.setDouble(2, bookType.getPrice());
				stmt.setString(3, bookType.getAuthor());
				stmt.setString(4, bookType.getCbs());
				stmt.setDate(5, new java.sql.Date(bookType.getCdDate().getTime()));
				stmt.setString(6, bookType.getDescri());
				stmt.setInt(7, bookType.getSid());
				stmt.setInt(8,bookType.getId());
			}else{
				stmt=conn.prepareStatement("update t_book_type set name=?,price=?,author=?,cbs=?,cdDate=?,descri=?,sid=?,photo=? where id=?");
				stmt.setString(1, bookType.getName());
				stmt.setDouble(2, bookType.getPrice());
				stmt.setString(3, bookType.getAuthor());
				stmt.setString(4, bookType.getCbs());
				stmt.setDate(5, new java.sql.Date(bookType.getCdDate().getTime()));
				stmt.setString(6, bookType.getDescri());
				stmt.setInt(7, bookType.getSid());
				stmt.setString(8,bookType.getPhoto());
				stmt.setInt(9,bookType.getId());
			}
			int ret=stmt.executeUpdate();
			if(ret>0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.free(stmt, conn);

		}
		return false;
	}


}
