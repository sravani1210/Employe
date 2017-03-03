package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import pojo.Employe;


public class search extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String empId=request.getParameter("empId");
       
        Dao d=new Dao();
        Employe e=d.search(empId);
        if(e!=null){
        out.println("<h3 align=center>Employee INFORMATION</h3>");
        out.println("<table align=center border=1>");
        out.println("<tr><td><h5>EmpNO:</td><td>"+e.getEmpId()+"</h5></td></tr>");
        out.println("<tr><td><h5>EmpNAME:</td><td>"+e.getEmpName()+"</h5></td></tr>");
        out.println("<tr><td><h5>EmpOrg:</td><td>"+e.getEmpOrg()+"</h5></td></tr>");
        out.println("<tr><td><h5>EmpSal:</td><td>"+e.getEmpSal()+"</h5></td></tr>");
        out.println("<tr><td><h5>EmpDom:</td><td>"+e.getEmpDom()+"</h5></td></tr>");
       out.println("</table>");
        }
       else
       {
    	   out.println("<h3 align=center>Employee INFORMATION Doesn't Exist</h3>");
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

