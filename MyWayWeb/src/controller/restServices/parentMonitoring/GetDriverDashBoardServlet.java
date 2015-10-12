package controller.restServices.parentMonitoring;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class GetDriverDashBoardServlet
 */
@WebServlet("/getDriverDashBoard")
public class GetDriverDashBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetDriverDashBoardServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		getDriverDashBoard(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		getDriverDashBoard(request, response);
	}

	private void getDriverDashBoard(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		UserProfileDoa userProfileDoa = new UserProfileDoaImpl();

		String driverUserName = request.getParameter("driverUserName");

		UserProfile driverProfile = userProfileDoa
				.retriveUserProfile(driverUserName);

		ParentMonitoringDao parentMonitoringDao = new ParentMonitoringDaoImpl();

		DriverDashBoard driverDashBoard = parentMonitoringDao
				.getDriverDashBoard(driverProfile);

		JSONObject json = new JSONObject();
		json.put("message", "success");
		json.put("result_code", 0);

		JSONArray result_data = new JSONArray();

		JSONObject jsonReport = new JSONObject();
		jsonReport.put("report_battaryStatus", driverDashBoard.getBattaryStatus());
		jsonReport.put("driver_currentLat", driverDashBoard.getCurrentLat());
		jsonReport.put("driver_currentLon", driverDashBoard.getCurrentLon());
		
		result_data.add(jsonReport);

		json.put("result_data", result_data);

		response.getWriter().print(json);

	}

}
