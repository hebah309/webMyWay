package controller.restServices.event;

import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Event;
import model.UserProfile;
import com.ibm.json.java.JSONObject;
import dao.EventsDao;
import dao.EventsDaoImpl;
import dao.UserProfileDoa;
import dao.UserProfileDoaImpl;

/**
 * Servlet implementation class RequestEventServlet
 */
@WebServlet("/requestEvent")
public class RequestEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestEventServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestEvent(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestEvent(request,response);
	}
void requestEvent(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		UserProfileDoa userProfileDoa = new UserProfileDoaImpl();
	
		String username = (String) request.getParameter("username");
		
		UserProfile userProfile = userProfileDoa.retriveUserProfile(username);
		
		
		String name = (String) request.getParameter("name");
		String category = (String) request.getParameter("category");
		String description = (String) request.getParameter("description");
		String image = (String) request.getParameter("image");
		String latitude = (String) request.getParameter("latitude");
		String longitude = (String) request.getParameter("longitude");
		Date startDate = new Date();
		Date endDate =  new Date();
		
		Event e = new Event(userProfile, name, category, description, startDate, endDate, latitude, longitude, image, "approved");
		
		EventsDao edi = new EventsDaoImpl();
		
		edi.submitEvent(e);
		
		JSONObject json = new JSONObject();
		json.put("message", "success");
		json.put("result_code", 0);
		json.put("result_data", "");
		
		response.getWriter().print(json);
		
	}

}
