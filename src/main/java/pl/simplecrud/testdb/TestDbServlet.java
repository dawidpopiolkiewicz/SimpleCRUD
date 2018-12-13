package pl.simplecrud.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter pw = response.getWriter();

		String user = "root";
		String password = "admin";

		String jdbcURL = "jdbc:mysql://localhost:3305/simplerud?useSSL=false";
		String driver = "com.mysql.jdbc.Driver";

		try {
			pw.println("Connection to database: " + jdbcURL);

			Class.forName(driver);
			DriverManager.getConnection(jdbcURL, user, password);
			pw.println("CONNECTED");
		} catch (Exception e) {
			pw.println("CONNECTION FAILED");
			e.printStackTrace();
			throw new ServletException(e);
		}

	}

}
