package controller.restServices.parentMonitoring;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DriverDashBoard;
import model.DriverReport;
import model.UserProfile;

import com.ibm.json.java.JSONArray;
import com.ibm.json.java.JSONObject;

import dao.ParentMonitoringDao;
import dao.ParentMonitoringDaoImpl;
import dao.UserProfileDoa;
import dao.UserProfileDoaImpl;

/**
 * Servlet implementation class PostDriverReportServlet
 */
@WebServlet("/postDriverReport")
public class PostDriverReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostDriverReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		postDriverReport(request,response);
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		postDriverReport(request,response);
	}
	
	private void postDriverReport(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		String reportLon = request.getParameter("report_lon");
		
		String reportLat = request.getParameter("report_lat");
		
		String reportReason = request.getParameter("report_reason");
		
		String reportTime = request.getParameter("report_time");
		
		String reportDate = request.getParameter("report_date");
		
		String driverUserName = request.getParameter("username");
		
		
	
		UserProfileDoa userProfileDoa = new UserProfileDoaImpl();
		UserProfile driverProfile = userProfileDoa.retriveUserProfile(driverUserName);
		
		DriverReport driverReport = new DriverReport(driverProfile, reportReason, reportLat, reportLon, reportDate, reportTime);
		
		JSONObject json = new JSONObject();
		
		ParentMonitoringDao parentMonitoringDao = new ParentMonitoringDaoImpl();
		parentMonitoringDao.addDriverReports(driverReport);
			
		json.put("message", "success");
		json.put("result_code", 0);
		
			
		JSONArray result_data = new JSONArray();
		json.put("result_data", result_data);
		
		
		response.getWriter().print(json);
		
		
	}

}
