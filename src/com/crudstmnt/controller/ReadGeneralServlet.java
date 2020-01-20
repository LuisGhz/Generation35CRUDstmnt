package com.crudstmnt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crudstmnt.model.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet que obtiene el listado de los productos
 * @author Luis Gutiérrez
 * @version 1.0
 * 
 * <p>
 *  Este es un listado de todos los productos de mi base de datos
 * </p>
 */
@WebServlet("/ReadGeneralServlet")
public class ReadGeneralServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @version 1.0
	 * 
	 * Método doPost que me genera el listado de los productos en tipo MIME text/html
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. Declaramos variables
		String urlServer = "jdbc:mysql://localhost:3306/store?serverTimezone=UTC";
		String username = "root";
		String password = "mysqlr00t";
		String sql = "select * from products";
		//2. Declaramos objectos
		Connection conn = null;
		Statement stmnt = null;
		ResultSet rs = null;
		RequestDispatcher rd = null;
		PrintWriter pw = response.getWriter();
		List<Product> myProducts = new ArrayList<Product>();
		
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
			while(rs.next())
			{
				Product p = new Product();
				p.setIdProduct(rs.getInt(1));
				p.setProduct(rs.getString(2));
				p.setProductName(rs.getString(3));
				p.setProductPrice(rs.getDouble(4));
				myProducts.add(p);
			}

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
		
		request.setAttribute("myProducts", myProducts);
		
		rd = request.getRequestDispatcher("readGeneral.jsp");
		
		rd.forward(request, response);
	}

}
