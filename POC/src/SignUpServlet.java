

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Com.SocialMarket.Database.DatabaseHelper;

/**
 * Servlet implementation class SignUpServlet
 */
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
 
        // get parameters for userID and password from request
        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");
        Com.SocialMarket.Database.DatabaseHelper helper;
		
        try {
        	// Create a Database helper
			helper = new DatabaseHelper();
			
			// If user already exists; error out
			if(helper.doesUserExist(user))
				response.sendRedirect("/login.html");
			else
			{
				helper.insertUser(user, pwd, "test");
			response.sendRedirect("/home.html");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        }
}
