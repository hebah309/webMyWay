package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
 * Servlet implementation class ViewEventsServlet
 */
@WebServlet("/viewEvents")
public class ViewEventsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewEventsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		viewApprovedEvents(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		viewApprovedEvents(request, response);
	}
	
	void viewApprovedEvents(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		EventsDao eventsDao = new EventsDaoImpl();
		List<Event> events = eventsDao.getEvents();

		JSONArray result_data = new JSONArray();

		for (int i = 0; i < events.size(); i++) {

			JSONObject jsonReport = new JSONObject();
			Event e = events.get(i);
			jsonReport.put("id", e.getEventId());
			jsonReport.put("category", e.getCategory());
			jsonReport.put("name", e.getName());
			jsonReport.put("description", e.getDescription());
			jsonReport.put("image", e.getImage());
			jsonReport.put("startDate", e.getStartDate().toString().substring(0,10)+","+e.getStartDate().toString().substring(e.getStartDate().toString().length()-4,e.getStartDate().toString().length()));
			jsonReport.put("endDate", e.getEndDate().toString().substring(0,10)+","+e.getEndDate().toString().substring(e.getEndDate().toString().length()-4,e.getEndDate().toString().length()));
			jsonReport.put("latitude", e.getLatitude());
			jsonReport.put("longitude", e.getLongitude());

			result_data.add(jsonReport);
		}

		response.getWriter().print(result_data);
	}


}
