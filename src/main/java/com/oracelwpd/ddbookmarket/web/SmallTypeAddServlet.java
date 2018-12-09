package com.oracelwpd.ddbookmarket.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracelwpd.ddbookmarket.biz.SmallTypeBiz;
import com.oracelwpd.ddbookmarket.biz.lmpl.SmallTypeBizImpl;
import com.oracelwpd.ddbookmarket.model.SmallType;
import com.oracelwpd.ddbookmarket.util.MyBeanUtils;


@WebServlet("/smallTypeAdd")
public class SmallTypeAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public SmallTypeAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SmallType smallType=new SmallType();
		MyBeanUtils.populate(smallType, request.getParameterMap());
		SmallTypeBiz smallTypeBiz=new SmallTypeBizImpl();
		boolean ret=smallTypeBiz.save(smallType);
		if (ret) {
			response.sendRedirect("main.jsp");
		} else {
			request.setAttribute("smallType", smallType);
			request.getRequestDispatcher("SmallTypeAdd.jsp").forward(request, response);
		}
	}
	}


