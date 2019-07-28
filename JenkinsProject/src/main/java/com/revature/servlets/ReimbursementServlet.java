package com.revature.servlets;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Reimbursement;
import com.revature.daos.ReimbursementDaoImpl;

@WebServlet("/createReimbursement")
public class ReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	HttpSession session = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		session = request.getSession(false);
		if(session != null) {
			response.sendRedirect("welcomeEmployee");
		}
		else {
			response.sendRedirect("login");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		session = request.getSession(false);
	
		ReimbursementDaoImpl rd = new ReimbursementDaoImpl();

		if(session != null) {
			double reimbamount = Double.parseDouble(request.getParameter("Reimb_Amount"));
			String reimbtype = request.getParameter("reimbtype");
			String receipt =null;
			String reimbstatus ="Pending";
			String reimbdate = (request.getParameter("Reimb_Date").toString());
			String empid = session.getAttribute("Emp_ID").toString();
			
			Reimbursement r = new Reimbursement(reimbamount, reimbtype, receipt, reimbstatus, reimbdate,  empid);
			try {
				rd.createReimbursement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(r!= null) {
				response.setStatus(200);
				response.getWriter().write("Reimbursement request is successfully submitted");
				response.sendRedirect("welcomemployee");
			}
				response.getWriter().write("An error occured!!, try again");
				response.sendRedirect("employeeHomePage");
		
		}
		response.sendRedirect("login");
		}

}
