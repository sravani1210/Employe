package servlets;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import pojo.Employe;

public class modify extends HttpServlet {
   
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String empId=request.getParameter("empId");
        String empName=request.getParameter("empName");
        String empOrg=request.getParameter("empOrg");
        String empSal=request.getParameter("empSal");
        String empDom=request.getParameter("empDom");
      
        Dao d=new Dao();
        Employe e=new Employe(empId, empName, empOrg, empSal, empDom);
        if(d.modify(e))
        {
            out.println("<h3 align=center>UPDATED DATA</h3>");
        }
        else
        {
            out.println("<h3 align=center>NOT UPDATED DATA</h3>");
           
        }
        
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

