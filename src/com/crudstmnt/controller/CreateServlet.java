package com.crudstmnt.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 * 
 * @author Luis Antonio Gutiérrez Hérnandez
 *
 * @since 1.0
 * 
 * @see javax.servlet.HttpServlet
 * @see java.io.IOException
 */
@WebServlet("/CreateServlet")
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	/**
	 *  Method doPost
	 *  
	 *  @param request Is for recieve the clien data
	 *  @param response Is for send the data to the client
	 *  
	 *  @return This method return the data to the client
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html charset='utf-8'");
		
		PrintWriter out = response.getWriter();
		
		String product = request.getParameter("txtProduct");
		String productName = request.getParameter("txtProductName");
		double productPrice = Double.parseDouble(request.getParameter("txtProductPrice"));
		
		//1. Declaramos variables
		String urlServidor = "jdbc:mysql://localhost:3306/store?serverTimezone=UTC";
		String nombreUsuario = "root";
		String password = "mysqlr00t";
		int rowsAffected = 0;
		//2. Declaramos los objetos
		//Connection conn = null;
		//Statement stmnt = null;
		//ResultSet rs = null;
		//3. Instanciamos el driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//.getClass().getConstructor();
			
			Connection conn = DriverManager.getConnection(urlServidor, nombreUsuario, password);
			
			Statement stmnt = conn.createStatement();
			
			rowsAffected = stmnt.executeUpdate(String.format("INSERT INTO products (product, productName, productPrice) values ('%s', '%s', %f)", product, productName, productPrice));
			
			if (rowsAffected != 0)
			{
				out.append("Añadido con exito!!!!!!");
				response.sendRedirect("/Exercise35CRUDstmnt/");
			} 
			else
			{
				out.append("Registro no añadido");
			}
			
			stmnt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
