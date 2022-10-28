package com.signup;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.DbUtil;

@WebServlet("/signup")
public class Signup extends HttpServlet {
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
		String sql = "insert into users values(?,?,?,?)";
		try {
			System.out.println((String)request.getAttribute("username"));
			pst = conn.prepareStatement(sql);
			pst.setString(1, (String) request.getAttribute("username"));
			pst.setString(2, (String) request.getAttribute("email"));
			pst.setString(3, (String) request.getAttribute("password"));
			pst.setString(4, (String) request.getAttribute("role"));
			int count = pst.executeUpdate();
			System.out.println(count > 0 ? "Registered" : "Failed to register");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
