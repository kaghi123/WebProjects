package prac;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ViewContact")
public class ViewContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewContact() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Integer id = Integer.valueOf( request.getParameter( "id" ) );
		 
		 request.setAttribute("id", id);
       
		 request.getRequestDispatcher( "/WEB-INF/ViewContact.jsp" ).forward( request,
		         response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}