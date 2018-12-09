package com.oracelwpd.ddbookmarket.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.oracelwpd.ddbookmarket.biz.AdminBiz;
import com.oracelwpd.ddbookmarket.biz.lmpl.AdminBizImpl;
import com.oracelwpd.ddbookmarket.model.Admin;
import com.oracelwpd.ddbookmarket.util.MyBeanUtils;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public LoginServlet() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取参数值
		Admin admin=new Admin();
		MyBeanUtils.populate(admin, request.getParameterMap());
        //验证码
		String vcode=request.getParameter("vcode");
		String serverVcode= (String) request.getSession().getAttribute("validateCode");
		//不区分大小写比较
		/*if (!serverVcode.equalsIgnoreCase(vcode)){
			request.setAttribute("sam","验证码输入有误");
			request.setAttribute("admin", admin);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		//进行校验
		ValidatorFactory factory= Validation.buildDefaultValidatorFactory();
		Validator validator=factory.getValidator();
		Set<ConstraintViolation<Admin>> constraintViolations=validator.validate(admin);
		
        if (constraintViolations.size()>0){//验证没有通过
			Map<String,String> errors=new HashMap<>();
			for (ConstraintViolation<Admin> cv:constraintViolations) {
				errors.put(cv.getPropertyPath().toString(),cv.getMessage());
			}
			request.setAttribute("errors",errors);
            request.setAttribute("admin", admin);
            request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}*/
		//
        Map<String,String> errors=new HashMap<>();
        if (!serverVcode.equalsIgnoreCase(vcode)){
            errors.put("vcode","验证码错误");
        }
        ValidatorFactory factory= Validation.buildDefaultValidatorFactory();
        Validator validator=factory.getValidator();
        Set<ConstraintViolation<Admin>> constraintViolations=validator.validate(admin);

        if (constraintViolations.size()>0){//验证没有通过

            for (ConstraintViolation<Admin> cv:constraintViolations) {
                errors.put(cv.getPropertyPath().toString(),cv.getMessage());
            }
        }
        if (errors.size()>0){
            request.setAttribute("errors",errors);
            request.setAttribute("admin", admin);
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }
		//与数据库进行对比
		AdminBiz adminBiz=new AdminBizImpl();
		boolean ret=adminBiz.findAdmin(admin);
		if (ret) {
			request.getSession().setAttribute("hasLogined",true);
			request.getRequestDispatcher("main.jsp").forward(request, response);
		} else {
           request.setAttribute("admin", admin);
           request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}
