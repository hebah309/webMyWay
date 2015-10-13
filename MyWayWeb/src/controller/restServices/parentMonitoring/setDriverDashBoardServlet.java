package controller.restServices.parentMonitoring;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DriverDashBoard;
import model.DriverDestination;
import model.UserProfile;

import com.ibm.json.java.JSONArray;
import com.ibm.json.java.JSONObject;

import dao.ParentMonitoringDao;
import dao.ParentMonitoringDaoImpl;
import dao.UserProfileDoa;
import dao.UserProfileDoaImpl;

/**
 * Servlet implementation class setDriverDashBoardServlet
 */
@WebServlet("/setDriverDashBoard")
public class setDriverDashBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public setDriverDashBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setDriverDashBoard(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setDriverDashBoard(request,response);
	}

	private void setDriverDashBoard(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
	
		String currentLat = request.getParameter("currentLat");
		
		String currentLon = request.getParameter("currentLon");
		
		String battaryStatus = request.getParameter("battaryStatus");
		
		String userName = request.getParameter("userName");
		
		
	
		UserProfileDoa userProfileDoa = new UserProfileDoaImpl();
		UserProfile driverProfile = userProfileDoa.retriveUserProfile(userName);
		
		DriverDashBoard driverDashBoard = new DriverDashBoard(driverProfile, battaryStatus, currentLat, currentLon) ;
		
		JSONObject json = new JSONObject();
		
		ParentMonitoringDao parentMonitoringDao = new ParentMonitoringDaoImpl();
		parentMonitoringDao.setDriverDashBoard(driverDashBoard);
			
		json.put("message", "success");
		json.put("result_code", 0);
		
			
		JSONArray result_data = new JSONArray();
		json.put("result_data", result_data);
		
		
		response.getWriter().print(json);
		
		
	}

	
	
}
