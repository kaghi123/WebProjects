package lab13.servelt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CurrencyConverter")
public class CurrencyConverter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CurrencyConverter() {
        super();
        
    }
    
    public void init( ServletConfig config ) throws ServletException
    {
        super.init( config );
       
        Map<String,Double> data = new HashMap<String,Double>();
        
        try {
        		Scanner in = new Scanner( new File (getServletContext().getRealPath("/WEB-INF/rates.txt")));
        
        		while(in.hasNextLine()){
        			String line = in.nextLine();
        			String tokens[] = line.split( " " );
        			data.put(tokens[0], Double.valueOf(tokens[1]));
        		}
        		
        		in.close();
        }
        catch( FileNotFoundException e){
        	throw new ServletException (e);
        }
        
        getServletContext().setAttribute("data", data);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher( "/WEB-INF/CurrencyConverter.jsp" )
		.forward( request, response );
        
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String,Double> data = (Map<String,Double>) getServletContext().getAttribute("data");
		
		String convertFrom = request.getParameter( "convertFrom" );
		String convertTo = request.getParameter( "convertTo" );
		double initValue = Double.parseDouble(request.getParameter( "initValue" ));
		double value = initValue * data.get(convertTo) / data.get(convertFrom);
		
		request.setAttribute( "convertFrom", convertFrom );
		request.setAttribute( "convertTo", convertTo );
		request.setAttribute( "initValue", initValue );
		request.setAttribute( "value", value );
		
		request.getRequestDispatcher( "/WEB-INF/Answer.jsp" )
        .forward( request, response );
	}

}