package com.oracelwpd.ddbookmarket.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracelwpd.ddbookmarket.biz.BigTypeBiz;
import com.oracelwpd.ddbookmarket.biz.lmpl.BigTypeBizImpl;

/**
 * Servlet implementation class BigTypeAddServlet
 */
@WebServlet("/bigTypeAdd")
public class BigTypeAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public BigTypeAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    /*	if (request.getSession().getAttribute("hasLogined")==null||!(boolean)request.getSession().getAttribute("hasLogined")==true){
           response.sendRedirect("login.jsp");
           return;
		}*/
		//把用户输入的大类名存到数据库中
		String name=request.getParameter("name");
		//
		BigTypeBiz bigTypeBiz=new BigTypeBizImpl();
		boolean ret=bigTypeBiz.save(name);
		if (ret) {
			response.sendRedirect("main.jsp");
		} else {
         request.setAttribute("name", name);
         request.getRequestDispatcher("bigTypeAdd.jsp").forward(request, response);
		}
	}

}
