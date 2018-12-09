package com.oracelwpd.ddbookmarket.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.oracelwpd.ddbookmarket.biz.BigTypeBiz;
import com.oracelwpd.ddbookmarket.biz.lmpl.BigTypeBizImpl;
import com.oracelwpd.ddbookmarket.model.BigType;


@WebServlet("/findAllBigType")
public class FindAllBigTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public FindAllBigTypeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String callBack=request.getParameter("callback");
		BigTypeBiz bigTypeBiz=new BigTypeBizImpl();
		List<BigType> ls=bigTypeBiz.findAllBigType();
		//js
		//1.1告诉客户端发送是Js
		response.setContentType("text/javascript;charset=UTF-8");
		PrintWriter out=response.getWriter();
		JSONArray jsonArray=new JSONArray(ls);
		out.println(callBack+"("+jsonArray.toString()+")");//不能写死
		out.flush();
	}

}
