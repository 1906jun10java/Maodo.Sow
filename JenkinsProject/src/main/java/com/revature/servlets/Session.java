package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Employee;

@WebServlet("/session")
public class Session extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		if (session != null && session.getAttribute("empid") != null) {
		
			int empID = Integer.parseInt(session.getAttribute("empid").toString());
			String empRole = session.getAttribute("emprole").toString();
			String firstName = session.getAttribute("firstanem").toString();
			String lastName = session.getAttribute("lastname").toString();
			String dept = session.getAttribute("department").toString();
			int managerID = Integer.parseInt(session.getAttribute("managerid").toString());
			Employee e = new Employee(empID ,empRole, firstName, lastName, dept, managerID);
			response.getWriter().write((new ObjectMapper()).writeValueAsString(e));
			
		}
		else {
			response.getWriter().write("{\"session\":null}");
			response.sendRedirect("login");
		}	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
}