package com.oracelwpd.ddbookmarket.web;

import com.oracelwpd.ddbookmarket.biz.BookTypeBiz;
import com.oracelwpd.ddbookmarket.biz.SmallTypeBiz;
import com.oracelwpd.ddbookmarket.biz.lmpl.BookTypeBizImpl;
import com.oracelwpd.ddbookmarket.biz.lmpl.SmallTypeBizImpl;
import com.oracelwpd.ddbookmarket.model.BookType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ToBookEditServlet" , value = "/toBookEdit")
public class ToBookEditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取
        String strid=request.getParameter("id");
        int id=Integer.parseInt(strid);
       /* String strBid=request.getParameter("bid");
        int bid =Integer.parseInt(strBid);*/

        //业务层
        BookTypeBiz bookTypeBiz=new BookTypeBizImpl();
        BookType bookType=bookTypeBiz.findBookById(id);
        SmallTypeBiz smallTypeBiz=new SmallTypeBizImpl();
        int bid=smallTypeBiz.findBidById(bookType.getSid());
        //回填数据库
       request.setAttribute("bookType",bookType);
       request.setAttribute("bid",bid);
       request.getRequestDispatcher("/bookEdit.jsp").forward(request,response);
    }
}
