package com.oracelwpd.ddbookmarket.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracelwpd.ddbookmarket.biz.BookTypeBiz;
import com.oracelwpd.ddbookmarket.biz.lmpl.BookTypeBizImpl;
import com.oracelwpd.ddbookmarket.model.BookType;
import com.oracelwpd.ddbookmarket.util.PageContstant;

/**
 * Servlet implementation class BookListServlet
 */
@WebServlet("/bookList")
public class BookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String strCurrentPage=request.getParameter("currentPage");
		//没指明那一页，让其默认显示第一页
		if (strCurrentPage==null) {
			strCurrentPage="1";
		}
		int currentPage=Integer.parseInt(strCurrentPage);
		//获取name sid
		String name=request.getParameter("name");
		String strsid=request.getParameter("sid")==null?"-1":request.getParameter("sid");
		int sid=Integer.parseInt(strsid);
		
		String strBid=request.getParameter("bid")==null?"-1":request.getParameter("bid");
		int bid=Integer.parseInt(strBid);
		
		BookTypeBiz bookBiz=new BookTypeBizImpl();
		List<BookType> ls=bookBiz.findAll(currentPage,name,sid);
		
		int totalRow=bookBiz.totalRow(name,sid);
		int totalPage=totalRow%PageContstant.PAGE_SIZE==0?totalRow/PageContstant.PAGE_SIZE:totalRow/PageContstant.PAGE_SIZE+1;
		
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("ls", ls);	
		request.setAttribute("bid", bid);
		request.setAttribute("sid", sid);
		request.setAttribute("name", name);
		request.getRequestDispatcher("bookList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
