package com.mconnect.common;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mconnect.database.UserDbHelper;
import com.mconnect.database.VerificationTable;

/**
 * Servlet implementation class for adding a new user
 */
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public SignupServlet() {
		super();
	}

	// Handle a Sign up Request
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		// Get the parameters from the post request.
		String user = request.getParameter("user");
		String password = request.getParameter("pwd");
		String passwordRe = request.getParameter("pwdRe");

		if(password.compareTo(passwordRe) != 0){
			RedirectToError("Retyped password does not match the original password.", 
			response);
		}
		else
		{	
			try {
				UserDbHelper helper = new UserDbHelper();
				VerificationTable tableHelper = new VerificationTable();
				
				// If user already exist error out
				if(helper.doesUserExist(user))
				{
					RedirectToError("User already registered, Try recovering password or login "
					+ "with a new email id.", response);
				}
				else
				{
					// Insert user into our DB and redirect to homepage
					helper.insertUser(user, password);
					int userId = helper.getUserId(user);
					
					String verificationCode = tableHelper.AddVerificationCode(userId);
					
					SendVerificationMail(user, userId, verificationCode);
					
					response.sendRedirect("home.jsp");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}


	}

	private void SendVerificationMail(String user, int userId,
			String verificationCode) {
		
		//TODO : logic here
		
	}

	private void RedirectToError(String string, HttpServletResponse response) 
			throws IOException {
		response.sendRedirect("login.html");
	}

}
