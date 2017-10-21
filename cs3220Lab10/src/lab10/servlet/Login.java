package lab10.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }
    
    String username = "";
	String password = "";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        out.println( "<html><head><title>Login</title></head><body>" );
		
		
			
			out.println( "<form id='newFolder' action='Members' method='post'>" );
	        out.println( "<p>Username: <input type='text' name=" + username + "/></p>" );
	        out.println( "<p>Password: <input type='text' name=" + password + "/></p>" );
	        out.println( "<p><input type='submit' name='submit' value='Login' /></p>" );
	        out.println( "</form>");
		
        out.println( "</body></html>" );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if(username.equals("cysun") && password.equals("abcd") ){
			response.sendRedirect( "Members" );
		}
		response.sendRedirect( "Login" );
	}

}
