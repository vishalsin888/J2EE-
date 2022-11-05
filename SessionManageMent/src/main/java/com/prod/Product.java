package com.prod;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/product")
public class Product extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String pname = request.getParameter("pname");
		String qty = request.getParameter("qty");
		String btn = request.getParameter("btn");
		request.setAttribute("pname", pname);
		request.setAttribute("qty", qty);
		request.setAttribute("btn", btn);
		HttpSession session1 = request.getSession();
		session1.setAttribute("pname", pname);
		session1.setAttribute("qty", qty);
		session1.setAttribute("btn", btn);
		RequestDispatcher rd = request.getRequestDispatcher("display.jsp");
		rd.forward(request, response);
		//Session   keyboard 11 
		String type = "aaa";
		
		if(type.equals("Session")) {
			HttpSession session = request.getSession();
			if(btn.equals("Add")) {
				session.setAttribute(pname, qty);
				out.print("<h2>Product "+pname+" Added</h2>");
			}else if(btn.equals("Update")) {
				session.setAttribute(pname, qty);
				out.print("<h2>Product "+pname+" Updated</h2>");
			}else if(btn.equals("Delete")) {
				session.removeAttribute(pname);
				out.print("<h2>Product "+pname+" Deleted</h2>");
			}else 
				if(btn.equals("GetAll")) {
				Enumeration values = session.getAttributeNames(); // A,AB ,C
				out.print("<table><tr><th>Product</th><th> Qty</th><tr>");
				while (values.hasMoreElements()) {
					String pn = (String) values.nextElement();
					String qty1 = (String) session.getAttribute(pn);
					out.print("<tr><td> "+pn+ "</td><td> "+qty1+ "</td><tr>");
				}
				out.print("</table>");
			}else {
				
				session.invalidate();
				out.print("<h2>Session Timed Out<h2>");
			}
			
//			RequestDispatcher rd = request.getRequestDispatcher("index.html");
//			rd.include(request, response);
			
		}else if(type.equals("Cookie")) {
			System.out.println("inside cookie");
			//abc 12 - add //abc 20  // delete abc 12
			if(btn.equals("Add")) {
				Cookie addc = new Cookie(pname, qty);
				response.addCookie(addc);
				out.print("<h2>Product "+pname+" Added</h2>");
			}else if(btn.equals("Update")) {
				Cookie updatec = new Cookie(pname, qty);
				response.addCookie(updatec);
				out.print("<h2>Product "+pname+" Updated</h2>");
			}else if(btn.equals("Delete")) {
				Cookie deletec = new Cookie(pname, qty);
				deletec.setMaxAge(0);
				response.addCookie(deletec);
				out.print("<h2>Product "+pname+" Deleted</h2>");
			}else 
				if(btn.equals("GetAll")) {
				Cookie[] allcookie = request.getCookies();
				System.out.println(allcookie);
				out.print("<table><tr><th>Product</th><th> Qty</th><tr>");
				System.out.println();
				for(Cookie c : allcookie) {
					System.out.println(c);
					out.print("<tr><td> "+c.getName()+ "</td><td> "+c.getValue()+ "</td><tr>");
				}
				out.print("</table>");
			}else {
		
				out.print("<h2>Session Timed Out<h2>");
			}
			
//			RequestDispatcher rd = request.getRequestDispatcher("index.html");
//			rd.include(request, response);
//			
		}
		
	}

}
