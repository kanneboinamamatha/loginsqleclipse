
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginTest")
public class LoginTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String id = request.getParameter("id");        
         String name = request.getParameter("username");
         String age = request.getParameter("age"); 
         String dob = request.getParameter("dob");
         String pw=request.getParameter("password"); 
         String mobileno = request.getParameter("mobileno");
         Connection conn = null;      
         try       
		{              
		Class.forName("oracle.jdbc.driver.OracleDriver");              
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root" );              
		conn.createStatement();              
	
		PreparedStatement ps = conn.prepareStatement("insert into registration12 values (?,?,?,?,?,?)");
		ps.setString(1, id);
		ps.setString(2, name);
		ps.setString(3, age);
		ps.setString(4, dob);
		ps.setString(5, pw);
		ps.setString(6, mobileno);
		int i =ps.executeUpdate();
		
		if(i>0)   {             
			out.println("Inserted Successfully");   
		}
	
		else {    
		
		out.println("Insert Unsuccessful");        
		}
		}
		catch(Exception e)        
		{         
			out.println(e);               
		 }    
	}


	}
