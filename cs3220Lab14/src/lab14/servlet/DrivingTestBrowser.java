package lab14.servlet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/DrivingTestBrowser")
public class DrivingTestBrowser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	int index = 0;
	String value = "";
	

    public DrivingTestBrowser() {
    	super();
    }
    
    public void init(ServletConfig config) throws ServletException {
		super.init( config );
		
		List<Question> entries = new ArrayList<Question>();
        
        try {
        		Scanner in = new Scanner( new File (getServletContext().getRealPath("/WEB-INF/DrivingTest.txt")));
        
        		while(in.hasNextLine()){
        			String desc = in.nextLine();
        			String a = in.nextLine();
        			String b = in.nextLine();
        			String c = in.nextLine();
        			String answer = in.nextLine();
        			String extraline = in.nextLine();
        			
        			Question question = new Question(desc, a, b, c, Integer.valueOf(answer) );
        			entries.add(question);
        			
        		}
        		
        		in.close();
        }
        
        catch( FileNotFoundException e){
        	throw new ServletException (e);
        }
        
        getServletContext().setAttribute("entries", entries);
        
	}

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Question> entries = (List<Question>) getServletContext().getAttribute("entries" );
		
		String[] answersArray;
		answersArray = new String[entries.size()];
		
		for( Question entry  : entries ) {
			
			if(index + 1 > entries.size()){
				
				request.getRequestDispatcher( "/WEB-INF/Summary.jsp" ).forward( request,
				         response );
				index = 0;
			}
			
			entry = entries.get(index);
			
			String desc = entry.getdescription();
			String a = entry.getAnswerA();
			String b = entry.getAnswerB();
			String c = entry.getAnswerC();
			int answer = entry.getCorrectAnswer();
			
			
			
			request.setAttribute( "desc", desc );
			request.setAttribute( "a", a );
			request.setAttribute( "b", b );
			request.setAttribute( "c", c );
			request.setAttribute( "answer", answer );
			request.setAttribute( "index", index );
			
			
			
				request.getRequestDispatcher( "/WEB-INF/Display.jsp" ).forward( request,
			         response );
				 value = request.getParameter("uanswer");
			
			
			
			
			 answersArray[index] = value;
			 
			 System.out.println(answersArray[index]);
			
			
			
			
			
			
			index++;
			
			return;
			
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
