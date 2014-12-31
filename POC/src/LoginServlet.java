
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Com.SocialMarket.Database.DatabaseHelper;
 
/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
 
        // get request parameters for userID and password
        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");
         

        Com.SocialMarket.Database.DatabaseHelper helper;
		try {
			helper = new DatabaseHelper();
	        helper.insertUser(user, pwd, "test");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        }
     }
