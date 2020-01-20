package com.crudstmnt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class deleteProductServlet
 */
@WebServlet("/deleteProductServlet")
public class deleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. Declaramos variables
				String urlServer = "jdbc:mysql://localhost:3306/store?serverTimezone=UTC";
				String username = "root";
				String password = "mysqlr00t";
				//2. Declaramos objectos
				Connection conn = null;
				Statement stmnt = null;
				PrintWriter pw = response.getWriter();
				HttpSession mySession = request.getSession(true);
				
				String idProduct = (String) mySession.getAttribute("idProduct");
				
				String sql = "delete from products where idProduct=" + idProduct;
				try 
				{			
					//3. Instanciamos el driver
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					//4. Abrimos conexión 

					conn = DriverManager.getConnection(urlServer, username, password);
					
					//5. Preparamos el statement
					stmnt = conn.createStatement();
					
					//6. Executamos la sentencia SQL
					stmnt.executeUpdate(sql);
					
					//7. Procesamos la salida
					pw.append("Delete success");
					response.sendRedirect("/Exercise35CRUDstmnt/");
					
				} catch(Exception e)
				{
					e.printStackTrace();
				}
				
				try 
				{
					//8. Cerramos conexión
					stmnt.close();
					conn.close();
				} catch(SQLException e)
				{
					e.printStackTrace();
				}
	}

}
