package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import pojo.Employe;

public class Delete extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	try {
		delete(req,resp);
		resp.sendRedirect("s.jsp");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

private void delete(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
	Employe e=new Employe();
	String s=(req.getParameter("empId"));
	Dao.delete(s);
}
}
