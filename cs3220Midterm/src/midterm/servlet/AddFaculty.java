package midterm.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddFaculty")
public class AddFaculty extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddFaculty() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher( "/WEB-INF/AddFaculty.jsp" ).forward( request,
		         response );
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String department = request.getParameter( "department" );
		String name = request.getParameter( "name" );
		boolean isChairperson = Boolean.parseBoolean(request.getParameter( "chairperson" ));
		
		List<Faculty> entries = (List<Faculty>) getServletContext().getAttribute("entries" );
		
		entries.add( new Faculty(department, name, isChairperson));
		
		response.sendRedirect( "ECSTFaculty" );
	}

}
