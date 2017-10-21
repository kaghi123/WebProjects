package midterm.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AddDepartment")
public class AddDepartment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddDepartment() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher( "/WEB-INF/AddDepartment.jsp" ).forward( request,
		         response );
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String dName = request.getParameter( "dName" );
		
		List<Department> dEntries = (List<Department>) getServletContext().getAttribute("dEntries" );
		
		dEntries.add( new Department(dName));
		
		response.sendRedirect( "ECSTFaculty" );
	}

}
