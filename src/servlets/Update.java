package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import pojo.Employe;

public class Update extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String empId=request.getParameter("empId");
        Dao d=new Dao();
		Employe employe=d.search(empId);
        out.println("<h2 align=center>UPDATE HERE</h2>");
        out.println("<form action='modify'>");
         out.println("<table align='center'>");
             out.println("<tr><td><b>EmpId:</b></td><td><input type='text'   name='empId'   value="+employe.getEmpId()+"></td></tr>");
             out.println("<tr><td><b>EmpNAME:</b></td><td><input type='text' name='empName' value="+employe.getEmpName()+"></td></tr>");
             out.println("<tr><td><b>EmpOrg:</b></td><td><input type='text'  name='empOrg'  value="+employe.getEmpOrg()+"></td></tr>");
             out.println("<tr><td><b>EmpSalary:</b></td><td><input type='text'  name='empSal'  value="+employe.getEmpSal()+"></td></tr>");
             out.println("<tr><td><b>EmpDom:</b></td><td><input type='text'     name='empDom'  value="+employe.getEmpDom()+"></td></tr>");
             out.println("<tr><td><input type='submit'  value='UPDATE'></td><td><input type='reset'  value='RESET'></td></tr>");
         out.println("</table>");
         out.println("<form>");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}

