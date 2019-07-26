import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.*;

public class Books {
	private int id;
	private String bookName,authorName,publication;
	
	public Books(){}
	
	public int getId() { return id;}
	
	public String getBookName()
	{
		return bookName;
	}
	
	public String getAuthorName()
	
	{
		return authorName;
	}
	
	public String getPublication()
	{
		return publication;
	}
	public void setId(int Id)
	{
		this.id = Id;
	}
	public void setBookName(String bookname)
	{
		this.bookName = bookname;
	}
	
	public void setAuthorName(String authorname)
	{
		this.authorName = authorname;
	}
	
	public void setPublication(String publication)
	{
		this.publication = publication;
	}
	
	
	
	public static int update(Books book){  
        int status=0;
        
        try{  
        	
        	Class.forName("com.mysql.jdbc.Driver");
        	Connection conn=null;    	
            conn = (Connection) DriverManager.getConnection(Configuration.DBPATH,Configuration.USERNAME,Configuration.PASSWORD);
			
			
            String	updateQuery =	"update books set bookname=?,authorname=?,publication=?  where id=?";
            
			PreparedStatement ps=(PreparedStatement) conn.prepareStatement(updateQuery);  
            ps.setString(1,book.getBookName());  
            ps.setString(2,book.getAuthorName());  
            ps.setString(3,book.getPublication());  
            ps.setInt(4,book.getId());  
              
            status=ps.executeUpdate();  
              
            conn.close();  
        }
        catch(Exception ex)
        {
        	ex.printStackTrace();
        }  
          
        return status;  
    }  
	
	public  static Books getBookById(int id){  
        
	    Books book = new Books();
          
        try
        {  
        	
        	Class.forName("com.mysql.jdbc.Driver");
        	Connection conn=null;
            conn = (Connection) DriverManager.getConnection(Configuration.DBPATH,Configuration.USERNAME,Configuration.PASSWORD);	 
            
        	String query = "select * from books where id=?";
        	PreparedStatement ps=(PreparedStatement) conn.prepareStatement(query);  
            ps.setInt(1,id); 
            
            ResultSet rs=ps.executeQuery();
            
            if(rs.next()){  
                book.setId(rs.getInt(4));  
                book.setBookName(rs.getString(1));  
                book.setAuthorName(rs.getString(2));  
                book.setPublication(rs.getString(3));  
                  
            }  
            
            conn.close();  
        }
        
        catch(Exception ex)
        {
        	ex.printStackTrace();
        }  
          
        return book;  
    }  
	
	
	public List<Books> getBooksList()
	{
		
		List<Books> list = new ArrayList<Books>();
		
		
		try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = null;
				conn = (Connection) DriverManager.getConnection(Configuration.DBPATH,Configuration.USERNAME,Configuration.PASSWORD);	 
	            
				if(conn!= null )
				{
					System.out.println("Connected successfully");
				}
				else
				{
					System.out.println("Not connected successfully");
				}
				
				
				String query = "select * from books";
				PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query);		
				ResultSet rs = ps.executeQuery(); 
				
				Books books;
				while(rs.next())
				{
					books = new Books();
					System.out.println(rs.getInt(4));
					books.setId(rs.getInt(4));
					
					System.out.println(rs.getString(1));
					books.setBookName(rs.getString(1));
					
					System.out.println(rs.getString(2));
					books.setAuthorName(rs.getString(2));
					
					System.out.println(rs.getString(3));
					books.setPublication(rs.getString(3));
					list.add(books);
					
				}
				
				conn.close();
		  }
		catch(Exception e)
			{
			System.out.println(e);
			}
		
		return list;
	}

	public static int deleteRow(String bookid) {
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = null;
			conn = (Connection) DriverManager.getConnection(Configuration.DBPATH,Configuration.USERNAME,Configuration.PASSWORD);	 
	        
			int id =Integer.parseInt(bookid);
				
				if(conn!= null )
				{	
					String query = "delete from books where id=?";
					
					PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query);		
					ps.setInt(1,id);
					
					int status= ps.executeUpdate(); 
					
					if(status > 0)
					{
						return 1;
					
					}
				}
				else
				{
					System.out.println("Not connected successfully");
				}
				
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		return 0;
	}
}
