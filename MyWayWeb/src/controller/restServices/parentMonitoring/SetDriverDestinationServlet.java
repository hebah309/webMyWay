package controller.restServices.parentMonitoring;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DriverDestination;
import model.UserProfile;

import com.ibm.json.java.JSONArray;
import com.ibm.json.java.JSONObject;

import dao.ParentMonitoringDao;
import dao.ParentMonitoringDaoImpl;
import dao.UserProfileDoa;
import dao.UserProfileDoaImpl;

/**
 * Servlet implementation class setDriverDestinationServlet
 */
@WebServlet("/setDriverDestination")
public class SetDriverDestinationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetDriverDestinationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setDriverDestination(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setDriverDestination(request,response);
	}
	
	private void setDriverDestination(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		String lat = request.getParameter("lat");
		
		String lon = request.getParameter("lon");
		
		String userName = request.getParameter("userName");
		
		
	
		UserProfileDoa userProfileDoa = new UserProfileDoaImpl();
		UserProfile driverProfile = userProfileDoa.retriveUserProfile(userName);
		
		DriverDestination driverDestination = new DriverDestination(driverProfile,lat,lon);
		
		JSONObject json = new JSONObject();
		
		ParentMonitoringDao parentMonitoringDao = new ParentMonitoringDaoImpl();
		parentMonitoringDao.setDriverDestination(driverDestination);
			
		json.put("message", "success");
		json.put("result_code", 0);
		
			
		JSONArray result_data = new JSONArray();
		json.put("result_data", result_data);
		
		
		response.getWriter().print(json);
		
		
	}

}
