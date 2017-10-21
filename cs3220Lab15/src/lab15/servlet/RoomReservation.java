package lab15.servlet;

import java.io.IOException; 
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/RoomReservation")
public class RoomReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Integer idSeed = 100;
	
	
	
       
    public RoomReservation() {
        super();
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Reservation> entries = new ArrayList<Reservation>();
		// i know this is wrong
		
		String day1 = request.getParameter("day");
		String time1 = request.getParameter("time");
		String name1= request.getParameter("name");
		
		Reservation reservation = new Reservation(idSeed, day1, time1, name1);
		entries.add(reservation);
		
		getServletContext().setAttribute("entries", entries);
		
		idSeed++;
		
		int counter = 0;
		
		for( Reservation entry  : entries ) {
			
			if(counter + 1 == entries.size()){
				
				request.getRequestDispatcher( "/WEB-INF/RoomReservation.jsp" ).forward( request,
				         response );
			}
			
			entry = entries.get(counter);
			
			String day = entry.getDay();
			String time = entry.getTime();
			String name = entry.getName();
			Integer id  = entry.getId();
			
			request.setAttribute( "day", day );
			request.setAttribute( "time", time );
			request.setAttribute( "name", name );
			request.setAttribute("id", id);
			
		}
		
		
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
