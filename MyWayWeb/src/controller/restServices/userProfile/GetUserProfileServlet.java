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
import model.UserProfile;

/**
 * Servlet implementation class UserProfileServlet
 */
@WebServlet("/getUserProfile")
public class GetUserProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetUserProfileServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getUserProfile(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getUserProfile(request, response);
	}

	private void getUserProfile(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String userName = request.getParameter("username");

		UserProfileDoa userProfileDoa = new UserProfileDoaImpl();
		UserProfile userProfile = userProfileDoa.retriveUserProfile(userName);

		JSONObject json = new JSONObject();
		json.put("message", "success");
		json.put("result_code", 0);

		JSONArray result_data = new JSONArray();

		JSONObject jsonReport = new JSONObject();
		jsonReport.put("password", userProfile.getPassWord());
		jsonReport.put("email", userProfile.getEmail());
		jsonReport.put("profile_picture", userProfile.getProfilePicture());

		result_data.add(jsonReport);

		json.put("result_data", result_data);
	
		response.getWriter().print(json);
	}

}
