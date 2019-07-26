

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class viewServlet
 */
@WebServlet("/viewServlet")
public class viewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		
		PrintWriter out = response.getWriter();
		
		out.println("<body style='background-color:#0ca3d2; color:#FFF'>");
		
		
		
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />;");
		
		
		out.println("<h1>.....Books List.....</h1>");
		out.println("<a style='background-color:#FFF;' href='WelcomeUser.html'>Home Page</a>");
		out.println("<a style='background-color:#FFF;' href='addBooks.html'>Add Books</a>");
		Books books  = new Books();
		
		List<Books> list = books.getBooksList();
		System.out.println(list);
		
		out.println("<table border='1' width='100%'>");
		out.print("<tr><th>Id</th><th>BookName</th><th>AuthorName</th><th>Publication</th></tr>");  
       
		for(Books b:list){  
			System.out.println(b.getId() + " " +  b.getBookName() + " " + b.getAuthorName() + " " + b.getPublication()  + " ");
        out.print("<tr><td>"+b.getId()+"</td><td>"+b.getBookName()+"</td><td>"+b.getAuthorName()+"</td><td>"+b.getPublication()+ "</td><td><a href='EditBook?id="+b.getId()+"'>edit</a></td><td><td><a href='DeleteBook?id="+b.getId()+"'>delete</a</td></tr>");  
			}  
		
		out.println("</table>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
