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
import com.revature.services.EmployeeService;
import com.revature.services.LoginService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private LoginService ls = LoginService.getInstance();
	private EmployeeService es = EmployeeService.getInstance();

	// GET
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
						req.getRequestDispatcher("Login.html").forward(req, res);
	}

	// POST
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		HttpSession session = req.getSession();

		String user = req.getParameter("username");
		String pw = req.getParameter("pw");
		if (session != null) {
			boolean logt=false;
			
				logt = ls.LoginValidation(user, pw);
		
			Employee e = new Employee();

			if ((logt == true) && (e.getEmp_role()=="Manager")) {

				session = newSession(user, session);
				res.sendRedirect("welcomeManager");

			} else if ((logt == true) && (e.getEmp_role()=="Employee")) {
				session = newSession(user, session);
				res.sendRedirect("welcomeEmployee");
			}
			session.setAttribute("Problem", "invalid credentials");
			res.sendRedirect("login");
		}
	}

	public HttpSession newSession(String user, HttpSession session) {

		Employee e = null;
			es.EmpByUsername(user);
		session.setAttribute("empid", e.getEmp_id());
		session.setAttribute("emprole", e.getEmp_role());
		session.setAttribute("firstname", e.getFirstname());
		session.setAttribute("lastname", e.getLastname());
		session.setAttribute("department", e.getDept());
		session.setAttribute("managerid", e.getManager_id());
		return session;
	}

}
