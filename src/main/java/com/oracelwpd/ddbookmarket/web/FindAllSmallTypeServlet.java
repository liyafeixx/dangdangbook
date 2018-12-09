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

import com.oracelwpd.ddbookmarket.biz.SmallTypeBiz;
import com.oracelwpd.ddbookmarket.biz.lmpl.SmallTypeBizImpl;
import com.oracelwpd.ddbookmarket.model.SmallType;


@WebServlet("/findAllSmallType")
public class FindAllSmallTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public FindAllSmallTypeServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String callBack=request.getParameter("callback");
		//获取大类id
		String strBid=request.getParameter("bid");
		int bid=Integer.parseInt(strBid);
		//
		SmallTypeBiz smallTypeBiz=new SmallTypeBizImpl();
		List<SmallType> ls=smallTypeBiz.findAllByBid(bid);
		
		response.setContentType("text/javascript;charset=UTF-8");
		PrintWriter out=response.getWriter();
		JSONArray jsonArray=new JSONArray(ls);
		out.println(callBack+"("+jsonArray.toString()+")");//不能写死
		out.flush();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
