package controller.restServices.userProfile;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.json.java.JSONArray;
import com.ibm.json.java.JSONObject;

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
		userProfile.setProfilePicture(request.getParameter("profilepicture"));

		UserProfileDoa userProfileDoa = new UserProfileDoaImpl();

		userProfileDoa.register(userProfile);
		
		JSONObject json = new JSONObject();
		json.put("message", "success");
		json.put("result_code", 0);

		JSONArray result_data = new JSONArray();

		JSONObject jsonReport = new JSONObject();
		
		result_data.add(jsonReport);

		json.put("result_data", result_data);

		response.getWriter().print(json);


	}

}
