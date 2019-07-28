package com.revature.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Employee;
import com.revature.daos.EmployeeDaoImpl;
import com.revature.daos.ReimbursementDaoImpl;

@WebServlet("/viewAllResolvedReimbursement")
public class ViewAllResolvedReimbursement extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession(false);
		if(session != null) {
			request.getRequestDispatcher("ManagerHome.html").forward(request, response);
			ReimbursementDaoImpl rd = new ReimbursementDaoImpl();
			EmployeeDaoImpl ed = new EmployeeDaoImpl();
			Employee e = new Employee();
			session.setAttribute("managerid", e.getManager_id());
			
			try {
				rd.getAllResolvedReimb();
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
