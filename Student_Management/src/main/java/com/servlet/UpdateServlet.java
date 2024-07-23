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
import com.entity.Student;

@WebServlet("/updateStudent")
public class UpdateServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			String name = req.getParameter("name");
			String email = req.getParameter("email");
			int age = Integer.parseInt(req.getParameter("age"));
			

			int id = Integer.parseInt(req.getParameter("id"));

			Student s = new Student(id,name, email, age);

			StudentDao dao = new StudentDao(DBConnect.getConn());
			HttpSession session = req.getSession();

			if (dao.updateStudent(s)) {
				session.setAttribute("succMsg", "Student Updated Sucessfully..");
				resp.sendRedirect("index.jsp");
			} else {
				session.setAttribute("errorMsg", "something wrong on server");
				resp.sendRedirect("index.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
