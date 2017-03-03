<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Of Employees</title>
</head>
<body>
<h1>List Of Employeees</h1>
  <table border="1" width="30%" height="30%">
  <tr><th><font color='Red'>EMP ID</font></th><th><font color='Red'>EMP NAME</font></th><th><font color='Red'>Emp Org</font></th><th><font color='Red'>EMP Sal</font></th><th><font color='Red'>EMP Dom</font></th></tr>
<%
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","system");
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery("select * from ibm");
  while(rs.next())
  {
      String EmployeeId=rs.getString("empId");
      String EmployeeName=rs.getString("empName");
      String EmployeeOrg=rs.getString("empOrg");
      String EmployeeSal=rs.getString("empSal");
      String EmployeeDom=rs.getString("empDom");
  %>
<tr>
<td><b><font color='#663300'><%=EmployeeId%></font></b></td>
<td><b><font color='#663300'><%=EmployeeName%></font></b></td>
<td><b><font color='#663300'><%=EmployeeOrg%></font></b></td>
<td><b><font color='#663300'><%=EmployeeSal%></font></b></td>
<td><b><font color='#663300'><%=EmployeeDom%></font></b></td>
</tr>
<%
  }
 %>
 </table>
 <a href="index.jsp">Home Page</a>
     </body>
</html>