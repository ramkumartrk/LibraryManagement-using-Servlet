

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AndroidWebService
 */
@WebServlet("/AndroidWebService")
public class AndroidWebService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AndroidWebService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println(request);
		System.out.println("doGet - request-hit");
		
			String name = request.getParameter("Name");
			response.getWriter().append("Hello..." + name);
			
			
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		System.out.println("dopost - request-hit");
		PrintWriter printWriter = response.getWriter();
		
		try
		{
			int length = request.getContentLength();
			printWriter.println("From DoPost method:" + length);
		
		byte[] input = new byte[length];
		
		ServletInputStream servletInputStream = request.getInputStream();
		
		int c, count = 0 ;
        while ((c = servletInputStream.read(input, count, input.length-count)) != -1) {
            count +=c;
        }
        servletInputStream.close();
    
        
        String receivedString = new String(input);
        
        response.setStatus(HttpServletResponse.SC_OK);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(response.getOutputStream());
        outputStreamWriter.write("Hello Mr/Mrs.. Indian " + input );
        outputStreamWriter.flush();
        outputStreamWriter.close();
		
		}
		catch(Exception e)
		{
			try
			{
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().print(e.getMessage());
                response.getWriter().close();	
			}
			catch(IOException ex)
			{
				ex.printStackTrace();
			}
			
		}
	
	}

}
