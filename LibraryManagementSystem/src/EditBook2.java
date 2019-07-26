

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditBook2
 */
@WebServlet("/EditBook2")
public class EditBook2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditBook2() {
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
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");      
        
        //String bookid      = request.getParameter("bookid");  
        //int id=Integer.parseInt(bookid);

		String bookid = request.getParameter("bookid");
	
		System.out.println("InputParamers are..... " + bookid);
		
		int id=Integer.parseInt(bookid);
		String bookname    = request.getParameter("book");  
        String authorname  = request.getParameter("author");  
        String publication = request.getParameter("publication");  
          
          
        Books book = new Books();
        
        book.setId(id);
          
        book.setBookName(bookname);  
        book.setAuthorName(authorname);  
        book.setPublication(publication);  
        //e.setCountry(country);  
          
        int status = Books.update(book);
          
        if(status>0){  
            response.sendRedirect("viewServlet");  
        }else{  
            out.println("Sorry! unable to update record");  
        }  
        response.setContentType("application/json");
        		
          out.println("success");
          
        		
        out.close();  
        
        out.print("<script type=\"text/javascript\" src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\n" + 
        		"	");
        
        doGet(request, response);
	}  
}


