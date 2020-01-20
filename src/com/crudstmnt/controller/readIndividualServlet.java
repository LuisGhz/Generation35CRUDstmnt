package com.crudstmnt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.crudstmnt.model.Product;
import java.util.List;

/**
 * Servlet implementation class readIndividualServlet
 */
@WebServlet("/readIndividualServlet")
public class readIndividualServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. Declaramos variables
		String urlServer = "jdbc:mysql://localhost:3306/store?serverTimezone=UTC";
		String username = "root";
		String password = "mysqlr00t";
		String idProduct = request.getParameter("individual");
		String sql = "select * from products where idProduct=" + idProduct;
		//2. Declaramos objectos
		Connection conn = null;
		Statement stmnt = null;
		ResultSet rs = null;
		RequestDispatcher rd = null; 
		HttpSession mySession = request.getSession(true);
		mySession.setAttribute("idProduct", idProduct);
		Product p = new Product();
		try 
		{			
			//3. Instanciamos el driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//4. Abrimos conexión 

			conn = DriverManager.getConnection(urlServer, username, password);
			
			//5. Preparamos el statement
			stmnt = conn.createStatement();
			
			//6. Executamos la sentencia SQL
			rs = stmnt.executeQuery(sql);
			
			//7. Procesamos la salida
			
			rs.next();
			p.setProduct(rs.getString(2));
			p.setProductName(rs.getString(3));
			p.setProductPrice(rs.getDouble(4));

		} catch(Exception e)
		{
			e.printStackTrace();
		}
		
		try 
		{
			//8. Cerramos conexión
			rs.close();
			stmnt.close();
			conn.close();
		} catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		request.setAttribute("product", p);
		
		rd = request.getRequestDispatcher("read.jsp");
		
		rd.forward(request, response);
	}

}
