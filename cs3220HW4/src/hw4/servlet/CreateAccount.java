package hw4.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CreateAccount")
public class CreateAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Integer idSeed = 100;
	
    public CreateAccount() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher( "/WEB-INF/CreateAccount.jsp" ).forward( request,
		         response );
		
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Account> account = (List<Account>) getServletContext().getAttribute("account" );
		
		
		
		String username = request.getParameter( "username" );
		String password = request.getParameter( "password" );
		
		for(Account entry : account){
			if(username.equals(entry.getUsername()) ){
				response.sendRedirect( "CreateAccount" );
				break;
			}
			else{
				
				HttpSession session = request.getSession();
				
				session.setAttribute( "username", username );
				session.setAttribute( "password", password );
				
				
				
				account.add( new Account(username, password, idSeed++));
				
				request.getRequestDispatcher( "/WEB-INF/Login.jsp" ).forward( request,
				         response );
				}
			}
		}
		
		
		

}
