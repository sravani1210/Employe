package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojo.Employe;

public class Dao {
	
	static Connection connection = null;
	static PreparedStatement preparedStatement = null;

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("loaded");
			connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "system");
			System.out.println("connected");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public static void create(Employe e) throws SQLException {
		String sql = "insert into ibm values(?,?,?,?,?)";
		preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setString(1, e.getEmpId());
		preparedStatement.setString(2, e.getEmpName());
		preparedStatement.setString(3, e.getEmpOrg());
		preparedStatement.setString(4, e.getEmpSal());
		preparedStatement.setString(5, e.getEmpDom());
		preparedStatement.executeUpdate();
		System.out.println("inserted");
	}

	public static void delete(String s) throws SQLException {
		String sql="delete from ibm where empId=?";
		preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setString(1, s);
		preparedStatement.executeUpdate();
		System.out.println("deleted");
	}

	public static void update(Employe e) throws SQLException {
		//String sql = "update ibm set empName='"+e.getEmpName()+"',empOrg='"+e.getEmpOrg()+"',empSal='"+e.getEmpSal()+"',empDom='"+e.getEmpDom()+"' where empId='"+e.getEmpId()+"'";
		String sql = "update ibm set empName=?,empOrg=?,empSal=?,empDom=? where empId=?";
		preparedStatement=connection.prepareStatement(sql);
		//preparedStatement.setString(1, "90");
		preparedStatement.setString(2, "yyy");
		preparedStatement.setString(3, "yyy");
		preparedStatement.setString(4, "yyy");
		preparedStatement.setString(5, "yyy");
		preparedStatement.executeQuery(sql);
		System.out.println("updated");
	}

	public static void upId(Employe e) throws SQLException {
		String sql="select * from ibm where empId=?";
		preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setString(1, e.getEmpId());
		preparedStatement.execute();
		System.out.println("done");
	}

	public Employe search(String empId) {
		{   
		         Employe e=null;
		        
		        try
		        {
		        preparedStatement=connection.prepareStatement("select * from ibm where empId=?");
		        preparedStatement.setString(1, empId);
		            ResultSet rs = preparedStatement.executeQuery();
		            if(rs.next())
		            {
		                e=new Employe(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
		                		rs.getString(5));
		                
		            }
		         
		        }catch(Exception ex)
		        {
		        	
		        	ex.printStackTrace();
		        }
		     
		        return e;
		     }
		       
	}
	public boolean modify(Employe e)
    {    boolean flag=false;
        try
        {
         preparedStatement=connection.prepareStatement("update ibm set empName=?,empOrg=?,empSal=?,empDom=? where empId=?");
         preparedStatement.setString(1, e.getEmpId());
         preparedStatement.setString(2, e.getEmpName());
         preparedStatement.setString(3, e.getEmpOrg());
         preparedStatement.setString(4,e.getEmpSal());
         preparedStatement.setString(5, e.getEmpDom());
         preparedStatement.executeUpdate();
         flag=true;
        }catch(Exception ex)
        {
            System.out.println(ex);
        }
     
        return flag;
    }
    
}
	

