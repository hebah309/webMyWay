package controller;

/*
 * this servlet file works as a resource for REST  
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ibm.json.java.JSONArray;
import com.ibm.json.java.JSONObject;

import dao.ParentsMonitoringDao;
import dao.ParentsMonitoringDaoImpl;
import model.Journey;
import model.UserInfo;


@WebServlet("/ParentsMonitoring")
public class ParentsMonitoringServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ParentsMonitoringServlet() {
		super();
	}

	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		UserInfo user = (UserInfo)session.getAttribute("user");
		out.println(PrintJourneys(user.getUserName()));
		out.close();
		return;

	}

	private String PrintJourneys(String userName) {

		ParentsMonitoringDao parentsMonitoringDao = new ParentsMonitoringDaoImpl();
		// create array of type JASON
		JSONArray jsonDetailsArray = new JSONArray();
		List<Journey> journeys = parentsMonitoringDao
				.getJourneysForParent(userName);
		for (Journey journey : journeys) {
			JSONObject jsonDetails = new JSONObject();
			// print for debugging
			System.out.println("User ID is " + journey.getId());
			System.out.println("The Current Location is "
					+ journey.getCurrentLocation());
			System.out.println("The Final Destination is "
					+ journey.getFinalDestination());
			System.out.println("The Speed is " + journey.getSpeed());
			System.out.println("The speedAverage is "
					+ journey.getSpeedAverage());

			jsonDetails.put("Username", userName);
			jsonDetails.put("UserID", journey.getId());
			jsonDetails.put("lat", journey.getCurrentLocation().getLatitude());
			jsonDetails.put("lon", journey.getCurrentLocation().getLongtitude());
			jsonDetails.put("FinalDestination", journey.getFinalDestination());
			jsonDetails.put("Speed", journey.getSpeed());
			jsonDetails.put("speedAverage", journey.getSpeedAverage());
			jsonDetails.put("stop", journey.getStops());
			jsonDetailsArray.add(jsonDetails);
		}
		System.out.println(jsonDetailsArray.toString());
		return (jsonDetailsArray.toString());
	}

}
