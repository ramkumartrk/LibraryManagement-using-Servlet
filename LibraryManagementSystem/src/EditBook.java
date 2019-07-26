

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.*;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


@WebServlet("/EditBook")
public class EditBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<center><h1>Update Books</h1></center>");  
		
		response.setContentType("text/html");
		
		response.setCharacterEncoding("UTF-8");
		
		int bookid = Integer.parseInt(request.getParameter("id"));
	
			Books b = new Books();
			b = Books.getBookById(bookid);
		
	 
			out.println("<html><head>");
	         out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
	         out.println("<title>Hello, World</title></head>");
			
			out.println("<body style='background-color:#0ca3d2; color:#FFF'><center>");	
			out.print("<form method='POST'>");  
			
	        out.print("<table border='1'; style='width:100%';>");  
	        out.print("<tr><td></td><td><input type='hidden' name='id' id='bookid' value='"+b.getId()+"'/></td></tr>");  
	        out.print("<tr><td>Book Name:</td><td><input type='text' name='bookname' id='bookname' value='"+b.getBookName()+"'/></td></tr>");  
	        out.print("<tr><td>Author Name:</td><td><input type='text' name='authorname' id='authorname' value='"+b.getAuthorName()+"'/> </td></tr>");  
	        out.print("<tr><td>Publication:</td><td><input type='text' name='publication' id='publication' value='"+b.getPublication()+"'/></td></tr>");  
	          
	        out.print("<tr><td></td><td colspan='2'><input type='submit' id='submit' value='Edit & Save '/></td></tr>");  
	        out.println("<div class='message'></div>");
	        out.print("</table>");  
	        out.print("</form>");
	        out.print("<script type=\"text/javascript\" src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\n" + 
	        		"	");
	        
	        
	        out.print("<script type=\"text/javascript\" src=\"update.js\"></script>");
	        out.print("</center></body>");
	        out.close();  
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	

	

}
