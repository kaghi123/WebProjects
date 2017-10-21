package midterm.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/ECSTFaculty")
public class ECSTFaculty extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ECSTFaculty() {
        super();
    }
    
    public void init(ServletConfig config) throws ServletException {
		super.init( config );
		
		
		List<Faculty> entries = new ArrayList<Faculty>();
		
		entries.add( new Faculty("Computer Science", "Pamula", true));
		entries.add( new Faculty("Computer Science", "Sun", false));
		entries.add( new Faculty("Electrical and Computer Engineering", "Agarwal", false));

		getServletContext().setAttribute( "entries", entries );
		
		
		List<Department> dEntries = new ArrayList<Department>();
		
		dEntries.add( new Department("Computer Science"));
		dEntries.add( new Department("Electrical and Computer Engineering"));
		
		getServletContext().setAttribute( "dEntries", dEntries );
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.getRequestDispatcher( "/WEB-INF/ECSTFaculty.jsp" ).forward( request,
		         response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
