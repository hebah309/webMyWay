package controller.restServices.event;

import java.io.IOException;
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
 * Servlet implementation class EventsServlet
 */
@WebServlet("/viewAllEvents")
public class ViewAllEventsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllEventsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		viewAllEvents(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		viewAllEvents(request,response);
	}
	
void viewAllEvents(HttpServletRequest request, HttpServletResponse response) throws IOException{

		
		EventsDao eventsDao = new EventsDaoImpl();
		List<Event> events = eventsDao.getEvents();
		
		JSONObject json = new JSONObject();
		json.put("message", "success");
		json.put("result_code", 0);
		
		
		JSONArray result_data = new JSONArray();

		for(int i = 0;i<events.size();i++) {
			
			JSONObject jsonReport = new JSONObject();
			Event e = events.get(i);
			jsonReport.put("category", e.getCategory());
			jsonReport.put("name", e.getName());
			jsonReport.put("description", e.getDescription());
			jsonReport.put("image", e.getImage());
			jsonReport.put("startDate", e.getStartDate());
			jsonReport.put("endDate", e.getEndDate());
			jsonReport.put("latitude", e.getLatitude());
			jsonReport.put("longitude", e.getLongitude());
			
			result_data.add(jsonReport);
		}
		
		json.put("result_data", result_data);
		
		
		response.getWriter().print(json);
	}

}
