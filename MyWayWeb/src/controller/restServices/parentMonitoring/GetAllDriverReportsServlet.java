package controller.restServices.parentMonitoring;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DriverReport;
import model.UserProfile;

import com.ibm.json.java.JSONArray;
import com.ibm.json.java.JSONObject;

import dao.ParentMonitoringDao;
import dao.ParentMonitoringDaoImpl;
import dao.UserProfileDoa;
import dao.UserProfileDoaImpl;

/**
 * Servlet implementation class GetAllDriverReportsServlet
 */
@WebServlet("/getAllDriverReports")
public class GetAllDriverReportsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllDriverReportsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getAllDriverReports(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getAllDriverReports(request,response);
	}

	private void getAllDriverReports(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		UserProfileDoa userProfileDoa = new UserProfileDoaImpl();

		String driverUserName = request.getParameter("driverUserName");

		UserProfile driverProfile = userProfileDoa.retriveUserProfile(driverUserName);
		
		ParentMonitoringDao parentMonitoringDao = new ParentMonitoringDaoImpl();
		
		List<DriverReport> driverReports = parentMonitoringDao.getAllDriverReports(driverProfile);
		
		
		JSONObject json = new JSONObject();
		json.put("message", "success");
		json.put("result_code", 0);
		
		
		JSONArray result_data = new JSONArray();

		for(DriverReport driverReport : driverReports) {
			
			JSONObject jsonReport = new JSONObject();
			jsonReport.put("report_date", driverReport.getDate());
			jsonReport.put("report_lat", driverReport.getLat());
			jsonReport.put("report_log", driverReport.getLon());
			jsonReport.put("report_reason", driverReport.getReason());
			jsonReport.put("report_time", driverReport.getTime());
			
			result_data.add(jsonReport);
		}
		
		json.put("result_data", result_data);
		
		
		response.getWriter().print(json);
		
		
	}

}
