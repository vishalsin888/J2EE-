package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.DbUtil;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection conn = null;
	PreparedStatement pst = null;
	public void init(ServletConfig config) throws ServletException {
		try {
			conn = DbUtil.getConnection();
			System.out.println("db connected");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sql = "select count(*) from users where username= ? and password = ? and role = ?";
		String[] role = (String[]) request.getParameterValues("admin");
		String myRole = "";
		if(role == null) {
			myRole = "User";
		}else {
			myRole = "Admin";
		}
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, (String) request.getParameter("username"));
			pst.setString(2, (String) request.getParameter("password"));
			pst.setString(3, myRole);
			ResultSet result = pst.executeQuery();
			result.next();
			System.out.println(result.getInt(1));
			System.out.println(result.getInt(1) > 0 ? "loggedIn" : "Failed to login");
			
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			if(result.getInt(1) > 0) {				
				out.println("<h2>You have LoggedIn As </h2>"+myRole);
				
			}else {
				out.println("<h2>Invalid Credentials!!! . <br>Please Provide Correct One</h2>");
//				out.println("<a href='login.html'>Try Again</a>");
				RequestDispatcher rd= request.getRequestDispatcher("login.html");
				rd.include(request, response);
			}
		}catch (Exception e) {
			System.out.println("exception"+ e.getMessage());
		}
	}
}
