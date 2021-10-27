package com.innova.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestOjdbc
 */
@WebServlet("/TestOjdbc")
public class TestOjdbc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user = "FPA_PORTAL";
		String pass = "FPA_PORTAL";
		
		String jdbcUrl = "jdbc:oracle:thin:@192.168.240.244:1920:INNOVADS";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		try {
			
			PrintWriter out = response.getWriter();
			
			out.println("Connecing to database "+jdbcUrl);
			
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(jdbcUrl,user, pass);
			
			out.println("CONNECTION OK!!!!");
			
			conn.close();
			
		}catch(Exception exc) {
			exc.getStackTrace();
			throw new ServletException(exc);
		}
		
		
	}

}
