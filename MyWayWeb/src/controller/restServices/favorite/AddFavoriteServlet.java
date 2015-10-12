package controller.restServices.favorite;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Favorite;
import model.UserProfile;
import com.ibm.json.java.JSONObject;
import dao.FavoritesDao;
import dao.FavoritesDaoImpl;
import dao.UserProfileDoa;
import dao.UserProfileDoaImpl;

/**
 * Servlet implementation class AddFavoriteServlet
 */
@WebServlet("/addFavorite")
public class AddFavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFavoriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		addFavorite(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		addFavorite(request,response);
	}
	
	void addFavorite(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		UserProfileDoa userProfileDoa = new UserProfileDoaImpl();

		String username = (String) request.getParameter("username");

		UserProfile userProfile = userProfileDoa.retriveUserProfile(username);
		
		
		String name = (String) request.getParameter("name");
		String latitude = (String) request.getParameter("latitude");
		String longitude = (String) request.getParameter("longitude");
		
		Favorite f = new Favorite(userProfile, name, latitude, longitude);
		
		FavoritesDao favoritesDao = new FavoritesDaoImpl();
		
		favoritesDao.addFavorite(f);
		
		JSONObject json = new JSONObject();
		json.put("message", "success");
		json.put("result_code", 0);
		json.put("result_data", "");
		
		response.getWriter().print(json);
		
	}


}
