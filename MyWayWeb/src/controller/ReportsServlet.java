package controller;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.IncidentReport;
import model.Location;

import com.ibm.json.java.JSONObject;

import dao.ReportsDao;
import dao.ReportsDoaImpl;

/**
 * Servlet implementation class ReportsServlet
 */
@WebServlet("/Reports")
public class ReportsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if("add".equalsIgnoreCase(action)) {
			
			String jsonReport = request.getParameter("jsonReport");
			
			try {
				
				JSONObject report = new JSONObject().parse(jsonReport);

				String type = (String)report.get("reportType");
				String description = (String)report.get("reportDescription");
				Date date = new Date((long) report.get("reportDate"));
				String longtitude = (String) report.get("longtitude");
				String latitude = (String) report.get("latitude");
				String trafficDensity = (String) report.get("trafficDensity");
				
				addReport(type, description, date, longtitude, latitude, trafficDensity);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}else{
			Map map = request.getParameterMap();
			int count = 1;
			
			for (Object key : map.keySet()) {
				if (count == map.size())
					break;
				ReportsDao reportsDao = new ReportsDoaImpl();
				reportsDao.updateReportStatus(Integer.parseInt(key.toString()), request.getParameter(key.toString()));
				count++;
			}
			
			response.sendRedirect("reviewReports.jsp");
		}
		
	}

	private void addReport(String type, String description, Date date, String longtitude, String latitude, String trafficDensity) {
		
		Location location = new Location();
		location.setLatitude(longtitude);
		location.setLongtitude(latitude);
		
		IncidentReport incidentReport = new IncidentReport();
		incidentReport.setLocation(location);
		incidentReport.setTrafficDensity(trafficDensity);
		incidentReport.setReportDescription(description);
		incidentReport.setReportStatus("pending");
		incidentReport.setReportTime(date);
		incidentReport.setReportType(type);
		incidentReport.setVoiceNotificationPath(null);
		
		ReportsDao reportsDao = new ReportsDoaImpl();
		reportsDao.addReport(incidentReport);
		
	}

}
