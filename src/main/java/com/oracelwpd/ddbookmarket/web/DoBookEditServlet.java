package com.oracelwpd.ddbookmarket.web;

import com.oracelwpd.ddbookmarket.biz.BookTypeBiz;
import com.oracelwpd.ddbookmarket.biz.lmpl.BookTypeBizImpl;
import com.oracelwpd.ddbookmarket.model.BookType;
import com.oracelwpd.ddbookmarket.util.MyBeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "DoBookEditServlet",value = "/doBookEdit")
@MultipartConfig
public class DoBookEditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookType bookType=new BookType();
        MyBeanUtils.populate(bookType, request.getParameterMap(),"yyyy-MM-dd");
        String newFile =null;
        Part part=request.getPart("photo");
        if (part.getHeader("Content-Disposition").contains("; filename=")) {
            if (part.getSubmittedFileName()!=null&&!part.getSubmittedFileName().equals("")) {
                String ext=part.getSubmittedFileName().substring(part.getSubmittedFileName().lastIndexOf(".")+1);
                newFile= UUID.randomUUID()+"."+ext;//文件名加上后缀名

                part.write(request.getServletContext().getRealPath("/upload/"+newFile));
            }
        }
        bookType.setPhoto(newFile);

        BookTypeBiz bookTypeBiz=new BookTypeBizImpl();
        boolean ret=bookTypeBiz.update(bookType);
        if (ret) {
            response.sendRedirect("bookList");
        } else {
            request.setAttribute("bookType",bookType);
            //回填用户刚输入的
            request.setAttribute("bid",request.getParameter("bid"));
            request.getRequestDispatcher("/bookEdit.jsp").forward(request, response);
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
