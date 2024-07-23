package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.StudentDao;
import com.db.DBConnect;

@WebServlet("/deleteStudent")
public class DeleteServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		
		StudentDao dao = new StudentDao(DBConnect.getConn());
		HttpSession session = req.getSession();

		if (dao.deleteStudent(id)) {
			session.setAttribute("succMsg", "Student Deleted Sucessfully..");
			resp.sendRedirect("index.jsp");
		} else {
			session.setAttribute("errorMsg", "something wrong on server");
			resp.sendRedirect("index.jsp");
		}
		

	}

}
