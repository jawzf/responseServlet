package kk;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class kkka
 */
public class resp_serv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Connection con;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public resp_serv() {
        super();
        // TODO Auto-generated constructor stub
    }
    
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//Integer equip_id=request.getAttribute(arg0);

//response.set

		
		
		//ServletContext sc = request.getServletContext();
		//RequestDispatcher rd =sc.getRequestDispatcher("/second.html");
		//rd.forward(request, response);
	
	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("hello");
		Connection conn=null;
		try
		{
			System.out.println("hi");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
			
			Statement s=conn.createStatement();
			disp();
			
			ResultSet rs1=s.executeQuery("update kar set age=99 where name='kar'");
			
			System.out.println("updated");
			disp();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	void disp()
	{
		Connection con=null;
		
	try
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
	
		Statement s=con.createStatement();
		
	
		ResultSet rs=s.executeQuery("select * from kar");//since the query returns many rows.. so we use result set
		System.out.println("no 	name 	age");
		while(rs.next())
		{
		
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));//must give the proper order for the corresponding col name...1 2 3 are the index positions of the cols in table
			
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	}

}
