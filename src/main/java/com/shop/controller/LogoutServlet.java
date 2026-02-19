package com.shop.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	// Inside LogoutServlet.java
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
	    if(request.getSession().getAttribute("auth") != null) {
	        request.getSession().removeAttribute("auth");
	        // Optional: clear cart too
	        // request.getSession().removeAttribute("cart-list");
	        response.sendRedirect("login.jsp");
	    } else {
	        response.sendRedirect("index.jsp");
	    }
	}
	}