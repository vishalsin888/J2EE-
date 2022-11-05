package com.search;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.util.DbUtil;

@WebServlet("/searchEmp")
public class EmployeeSearch extends HttpServlet {
	public Connection conn;
	public PreparedStatement pst;
	public void init(ServletConfig config) throws ServletException {
		try {
			conn = DbUtil.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String query = "Select * from users where empname like ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, request.getParameter("ename"));
			ResultSet res = pst.executeQuery();
			boolean isExists = res.next();
			if(isExists) {
				HttpSession session = request.getSession();
//				session.setAttribute("empname", res.getString(1));
//				session.setAttribute("email", res.getString(2));
				session.setAttribute("password", res.getString(3));
				session.setAttribute("role", res.getString(4));
				request.setAttribute("empname", res.getString(1));
				request.setAttribute("email", res.getString(2));
				RequestDispatcher rd = request.getRequestDispatcher("display.jsp");
				rd.forward(request, response);
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
