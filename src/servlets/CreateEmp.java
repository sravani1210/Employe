package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import pojo.Employe;

public class CreateEmp extends HttpServlet{
 
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 
	try {
		processInsert(req,resp);
		resp.sendRedirect("s.jsp");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
	private void processInsert(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
		Employe employe=new Employe();
		employe.setEmpId(req.getParameter("empId"));
		employe.setEmpName(req.getParameter("empName"));
		employe.setEmpOrg(req.getParameter("empOrg"));
		employe.setEmpSal(req.getParameter("empOrg"));
		employe.setEmpDom(req.getParameter("empDom"));
		Dao.create(employe);
	}
}
