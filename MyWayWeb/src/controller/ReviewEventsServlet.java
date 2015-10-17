package controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Event;

import com.ibm.json.java.JSONArray;
import com.ibm.json.java.JSONObject;

import dao.EventsDao;
import dao.EventsDaoImpl;

/**
 * Servlet implementation class ReviewEventsServlet
 */
@WebServlet("/reviewEvents")
public class ReviewEventsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReviewEventsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String selectedId = request.getParameter("selectedId");
		String selectedChoice = request.getParameter("selectedChoice");
		if(selectedId != null && selectedChoice != null){
			if("A".equalsIgnoreCase(selectedChoice)) selectedChoice = "Approved";
			if("R".equalsIgnoreCase(selectedChoice)) selectedChoice = "Rejected";
			ReviewEvent(selectedId,selectedChoice);
			response.sendRedirect("reviewPointsOfInterest.jsp");
		}else{
			viewPendingEvents(request, response);
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String selectedId = request.getParameter("selectedId");
		String selectedChoice = request.getParameter("selectedChoice");
		if(selectedId != null && selectedChoice != null){
			if("A".equalsIgnoreCase(selectedChoice)) selectedChoice = "approved";
			if("R".equalsIgnoreCase(selectedChoice)) selectedChoice = "rejected";
			ReviewEvent(selectedId,selectedChoice);
			response.sendRedirect("reviewPointsOfInterest.jsp");
		}else{
			viewPendingEvents(request, response);
		}
	}

	private void ReviewEvent(String selectedId, String selectedChoice) {
		EventsDao eventsDao = new EventsDaoImpl();
		eventsDao.reviewEvent(selectedChoice,Integer.parseInt(selectedId));
	}

	void viewPendingEvents(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		EventsDao eventsDao = new EventsDaoImpl();
		List<Event> events = eventsDao.getPendingEvents();

		JSONArray result_data = new JSONArray();

		for (int i = 0; i < events.size(); i++) {

			JSONObject jsonReport = new JSONObject();
			Event e = events.get(i);
			jsonReport.put("id", e.getEventId());
			jsonReport.put("category", e.getCategory());
			jsonReport.put("name", e.getName());
			jsonReport.put("description", e.getDescription());
			jsonReport.put("image", e.getImage());
			jsonReport.put("startDate", new Date().toString());
			jsonReport.put("endDate", new Date().toString());
			jsonReport.put("latitude", e.getLatitude());
			jsonReport.put("longitude", e.getLongitude());

			result_data.add(jsonReport);
		}

		response.getWriter().print(result_data);
	}

}
