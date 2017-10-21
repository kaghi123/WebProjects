package hw4.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Login") 
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Integer idSeed = 0;
       
    public Login() {
        super();
    }
    
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Account acc1 = new Account("cysun", "abcd", idSeed++);
		Account acc2 = new Account("george", "kassar", idSeed++);
		
		List<Account> account = new ArrayList<Account>();
		account.add(acc1);
		account.add(acc2);
		
		
		getServletContext().setAttribute( "account", account );
		
		request.getRequestDispatcher( "/WEB-INF/Login.jsp" ).forward( request,
		         response );
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user = request.getParameter( "user" );
        String pass = request.getParameter( "pass" );
        
        List<Account> account = (List<Account>) getServletContext().getAttribute("account" );
		
		int counter = 0;
		
		for( Account acc  : account ) {
			
			acc = account.get(counter);
        
			if( acc.getUsername().equals(user) && acc.getPassword().equals(pass) ) {
				
				HttpSession session = request.getSession();
				
				session.setAttribute( "user", user );
				session.setAttribute( "pass", pass );
				
				Integer accId = acc.getAccId();
				response.sendRedirect( "FileManager?accId=" + accId );
				break;
			}
			
			counter++;
			
			if(counter == account.size()) {
				response.sendRedirect( "Login" );
			}
		
		}	
		
		
		
	}

}
