package lab15.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteReservation")
public class DeleteReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteReservation() {
        super();
    }

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.valueOf( request.getParameter( "id" ) );
		
		List<Reservation> entries = (List<Reservation>) getServletContext().getAttribute("entries" );
        
        
        for( Reservation entry : entries )
            if( entry.getId().equals(id) )
            {
                entries.remove( entry );
                break;
            }

        response.sendRedirect( "RoomReservation" );
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
