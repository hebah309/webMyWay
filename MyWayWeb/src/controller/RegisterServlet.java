package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.UserProfileDoa;
import dao.UserProfileDoaImpl;
import model.UserProfile;

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		register(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		register(request, response);
	}

	private void register(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		UserProfile userProfile = new UserProfile();

		userProfile.setUserName(request.getParameter("username"));
		userProfile.setPassWord(request.getParameter("password"));
		userProfile.setEmail(request.getParameter("email"));
		
		UserProfileDoa userProfileDoa = new UserProfileDoaImpl();
		
		UserProfile existedUser = userProfileDoa.checkUserName(userProfile.getUserName());
				
		if(existedUser == null){
			userProfileDoa.register(userProfile);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/userlogin.jsp");
			dispatcher.forward(request, response);
		}else{
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/register.jsp?userExists=true");
			dispatcher.forward(request, response);
		}
		
		
	}
}
