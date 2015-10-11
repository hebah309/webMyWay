package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.json.java.JSONArray;
import com.ibm.json.java.JSONObject;

import dao.ReportsDao;
import dao.ReportsDoaImpl;
import dao.TrafficReportsDao;
import dao.TrafficReportsDaoImpl;
import model.IncidentReport;
import model.Location;
import model.TrafficReports;

/**
 * Servlet implementation class getTrafficReport
 */
@WebServlet("/PostTrafficReport")
public class PostTrafficReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostTrafficReport() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		addAllTrafficReports(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		addAllTrafficReports(request,response);
	}
	
void addAllTrafficReports(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		JSONObject json = new JSONObject();
		json.put("message", "success");
		json.put("result_code", 0);
		
		
		JSONArray result_data = new JSONArray();

			String type = request.getParameter("report_type");
			Integer c = Integer.parseInt(type);
			String comment = request.getParameter("report_comments");
			String longtitude = request.getParameter("report_log");
			String latitude = request.getParameter("report_lat");
			String username = request.getParameter("username");
			
			addReport(c, comment,longtitude, latitude,username);

		json.put("result_data", result_data);
		
		response.getWriter().print(json);
	}
private void addReport(int type, String comment, String longtitude, String latitude, String username) {
	

	
	TrafficReports trafficReport = new TrafficReports();
	trafficReport.setComment(comment);
	trafficReport.setReportTypeId(type);
	trafficReport.setLat(latitude);
	trafficReport.setLon(longtitude);
	trafficReport.setUsername(username);
	
	TrafficReportsDao traffic = new TrafficReportsDaoImpl();
	traffic.addReport(trafficReport);

	
}
	

}
