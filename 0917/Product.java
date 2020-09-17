package com.ssafy.hw;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Product
 */
@WebServlet("/info")
public class Product extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8"); 
		
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String info = request.getParameter("info");
		
		HttpSession session = request.getSession();
		session.setAttribute("name", name);
		session.setAttribute("price", price);
		session.setAttribute("info", info);
		
		RequestDispatcher disp = request.getRequestDispatcher("/work/information.jsp");
		disp.forward(request, response);
		
		
	}

}
