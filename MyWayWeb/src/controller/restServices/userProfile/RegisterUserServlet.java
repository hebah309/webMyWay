package controller.restServices.userProfile;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UserProfile;
import dao.UserProfileDoaImpl;
import dao.UserProfileDoa;

/**
 * Servlet implementation class RegisterUserServlet
 */
@WebServlet("/registerUser")
public class RegisterUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		register(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
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

		userProfileDoa.register(userProfile);

	}

}