

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.google.gson.*;


/**
 * Servlet implementation class InsertBooks
 */
@WebServlet("/InsertBooks")
public class InsertBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertBooks() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		
		String bookName = request.getParameter("book");
		String authorName = request.getParameter("author");
		String pulication = request.getParameter("publication");
		String returnMessage;
		
		Connection conn = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			out.println("worked!");
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useSSL=false","root","Temp@#$5");
			
			if(conn!=null)
			{
				out.println("Connected successfully to database!..");
			
				PreparedStatement ps = (PreparedStatement) conn.prepareStatement("insert into books(bookname,authorname,publication) values(?,?,?)");
						
						ps.setString(1,bookName);
						ps.setString(2,authorName);
						ps.setString(3,pulication);
						int status = ps.executeUpdate();
						if(status > 0)
						{
							returnMessage = "Successfully inserted";
							response.sendRedirect("WelcomeUser.html");
						}
						else
						{
							returnMessage = "something went wrong in inserting data...";
						}
						
						
						response.setContentType("application/json");
						out.println("successfully");
						
						
						//new Gson().toJson(returnMessage, response.getWriter());
				
					
						
				
			}
			
			
			
		}
		catch(Exception e)
		{
			out.println(e.getMessage());
				out.println("Not connected successfully to database.. (or) Error in inserting...");
			
		}
		finally
		{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	//	doGet(request, response);
	}

}
