package com.revature.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Employee;
import com.revature.daos.EmployeeDaoImpl;
import com.revature.daos.ReimbursementDaoImpl;

@WebServlet("/resolveReimbusement")
public class ResolveReimbursement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       	       
			protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
				HttpSession session = request.getSession(false);
				if(session != null) {
					request.getRequestDispatcher("Manager1Home.html").forward(request, response);
					ReimbursementDaoImpl rd = new ReimbursementDaoImpl();
					EmployeeDaoImpl ed = new EmployeeDaoImpl();
					Employee e = new Employee();
					session.setAttribute("empid", e.getEmp_id());
					
					try {
						rd.getPendingReimb(e.getEmp_id());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					response.sendRedirect("login");
				}
			}
			protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				doPost(request,response);
		}

}
