package kk;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
public class kkka extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Connection con;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public kkka() {
        super();
        // TODO Auto-generated constructor stub
    }
    
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
			
			System.out.println("here");
			
			int eqp_id= Integer.parseInt(request.getParameter("e_id"));
			System.out.println("eqpid:"+eqp_id);
				
			request.setAttribute("equip_id", eqp_id);
			request.setAttribute("status", 2);
			
		s.executeUpdate("update kar set age=19 where no="+eqp_id);	
			System.out.println("updated");
				
			System.out.println(eqp_id);
			
			s.executeUpdate("delete from down_table where equip_id="+eqp_id);
						
			ServletContext sc = request.getServletContext();
			
	RequestDispatcher rd =sc.getRequestDispatcher("/temp");
					rd.forward(request, response);
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		
	}
	

}
