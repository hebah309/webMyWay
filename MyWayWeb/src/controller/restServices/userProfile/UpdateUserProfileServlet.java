package controller.restServices.userProfile;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.json.java.JSONArray;
import com.ibm.json.java.JSONObject;

import dao.UserProfileDoa;
import dao.UserProfileDoaImpl;


/**
 * Servlet implementation class updateUserProfile
 */
@WebServlet("/updateUserProfile")
public class UpdateUserProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateUserProfileServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		updateUserProfile(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		updateUserProfile(request, response);
	}

	void updateUserProfile(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserProfileDoa userProfileDoa = new UserProfileDoaImpl();

		String username = request.getParameter("username");
		String newPassword = request.getParameter("password");

		String newEmail = request.getParameter("email");

		String newPicture = request.getParameter("profile_picture");

		userProfileDoa.updateUserProfile(username, newPassword, newEmail,
				newPicture);

		JSONObject json = new JSONObject();
		json.put("message", "success");
		json.put("result_code", 0);
		JSONArray result_data = new JSONArray();
		json.put("result_data", result_data);
		response.getWriter().print(json);
	}

}
