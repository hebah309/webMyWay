package controller.restServices.favorite;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Favorite;
import model.UserProfile;
import com.ibm.json.java.JSONArray;
import com.ibm.json.java.JSONObject;
import dao.FavoritesDao;
import dao.FavoritesDaoImpl;
import dao.UserProfileDoa;
import dao.UserProfileDoaImpl;

/**
 * Servlet implementation class FavoritesServlet
 */
@WebServlet("/viewAllFavorites")
public class ViewAllFavoritesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewAllFavoritesServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		viewAllFavorites(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		viewAllFavorites(request, response);
	}

	void viewAllFavorites(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		UserProfileDoa userProfileDoa = new UserProfileDoaImpl();

		String username = (String) request.getParameter("username");

		UserProfile userProfile = userProfileDoa.retriveUserProfile(username);
		
		FavoritesDao favoritesDao = new FavoritesDaoImpl();
		
		List<Favorite> favorites = favoritesDao.getFavorites(userProfile.getId() + "");

		JSONObject json = new JSONObject();
		json.put("message", "success");
		json.put("result_code", 0);

		JSONArray result_data = new JSONArray();

		for (int i = 0; i < favorites.size(); i++) {

			JSONObject jsonReport = new JSONObject();
			Favorite f = favorites.get(i);

			jsonReport.put("name", f.getName());
			jsonReport.put("latitude", f.getLatitude());
			jsonReport.put("longitude", f.getLongitude());

			result_data.add(jsonReport);
		}

		json.put("result_data", result_data);

		response.getWriter().print(json);
	}

}
