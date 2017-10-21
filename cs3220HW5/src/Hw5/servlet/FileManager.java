package Hw5.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FileManager")
public class FileManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Integer count;
       
    public FileManager() {
        super();
        
    }

	public void init(ServletConfig config) throws ServletException {
		super.init( config );
		
		
		
		List<File1> entries = new ArrayList<File1>();
		
		entries.add( new File1(0, "Default", null, 0, null, null, true, 0 ));

		getServletContext().setAttribute( "entries", entries );
		
		try
        {
            Class.forName( "com.mysql.jdbc.Driver" );
        }
        catch( ClassNotFoundException e )
        {
            throw new ServletException( e );
        }
	}

	
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int counter = 0;
		
		
		
		List<File1> entries = (List<File1>) getServletContext().getAttribute("entries" );
		
		List<Account> account = (List<Account>) getServletContext().getAttribute("account" );
		
		Integer acId = Integer.valueOf( request.getParameter( "accId" ) );
		
		
		
		
		Connection c = null;
    	try
        {
            String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu24";
            String username = "cs3220stu24";
            String password = "LsEokQ5j";

            c = DriverManager.getConnection( url, username,
                password );
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "select * from file1" );
            

            while( rs.next() )
            {
            	entries.add( new File1(
            			Integer.valueOf(rs.getString( "id" )),
            			rs.getString( "name" ), 
            			rs.getString( "type" ),
            			Integer.valueOf(rs.getString( "size" )),
            			rs.getString( "date" ),
            			Integer.valueOf(rs.getString( "parentId" )),
            			Boolean.valueOf(rs.getString( "isFolder" )),
            			Integer.valueOf(rs.getString( "accId" ))
            			));
            }
            
            rs.close();
            
        }
        catch( SQLException e )
        {
            throw new ServletException( e );
        }
    	finally
        {
            try
            {
                if( c != null ) c.close();
            }
            catch( SQLException e )
            {
                throw new ServletException( e );
            }
        }
		
		
		
		outerloop: for(File1 entry1 : entries){
			for( Account entry2 : account ) {
				
				if(entry2.getAccId() == acId){
					
					if(entry1.getName() == "Parent" && entry1.getAccId() == acId){
						break;
					}
					
					else if(counter + 1 >= entries.size()){
						entries.add( new File1(1, "Parent", null, 0, null, null, true, acId ));
						
						break outerloop;
					}
	
					counter++;
				}
				
			}
		}
		
			
		
		
		request.setAttribute("acId", acId);
		
		int index = 0;
		
		for( File1 entry : entries ) {
			
			entry = entries.get(index);
			
			
			Integer id = entry.getId();
			String name = entry.getName();
			String type = entry.getType();
	        Long size = entry.getSize();
	        String date = entry.getDate();
	        Integer parentId = entry.getParentId();
	        Boolean isFolder = entry.getIsFolder();
	        Integer accId = entry.getAccId();
	        
			
			request.setAttribute("id", id);
			request.setAttribute( "name", name );
			request.setAttribute( "type", type  );
			request.setAttribute( "size", size );
			request.setAttribute( "date", date );
			request.setAttribute( "parentId", parentId  );
			request.setAttribute( "isFolder", isFolder );
			request.setAttribute("accId", accId);
			
			
		}
		
		
        
		request.getRequestDispatcher( "/WEB-INF/FileManager.jsp" ).forward( request,
		         response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
	}

}