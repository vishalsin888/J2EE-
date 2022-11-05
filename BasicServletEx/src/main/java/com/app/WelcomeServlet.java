package com.app;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class WelcomeServlet extends GenericServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		System.out.println("init");
		super.init();
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(req.getParameter("btn"));
		Integer n1 = Integer.parseInt(req.getParameter("num1"));
		Integer n2 = Integer.parseInt(req.getParameter("num2"));
		int sum = n1+n2;
		req.setAttribute("sum", sum);
		req.setAttribute("num1", n1);
		req.setAttribute("num2", n2);
		RequestDispatcher rd = req.getRequestDispatcher("display.jsp");
		rd.forward(req, res);
//		System.out.println("service");
//		PrintWriter output = res.getWriter();
//		output.print("<a href='home.html'>Back</a><br>");
//		output.print("sum ="+sum);
		
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy");
		super.destroy();
	}

}
