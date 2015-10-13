package controller.restServices.parentMonitoring;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.json.java.JSONArray;
import com.ibm.json.java.JSONObject;
import model.UserProfile;
import dao.ParentMonitoringDao;
import dao.ParentMonitoringDaoImpl;

/**
 * Servlet implementation class GetUserDrivers
 */
@WebServlet("/getUserDrivers")
public class GetUserDriversServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetUserDriversServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getUserDrivers(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getUserDrivers(request,response);
	}

	private void getUserDrivers(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		System.out.print("hellooooooooooooooooooooo");
		
		String parentUserName = request.getParameter("parentUserName");
		
		ParentMonitoringDao parentMonitoringDao = new ParentMonitoringDaoImpl();
		
		List<UserProfile> drivers = parentMonitoringDao.getAllDrivers(parentUserName);
		
		
		JSONObject json = new JSONObject();
		json.put("message", "success");
		json.put("result_code", 0);
		
		
		JSONArray result_data = new JSONArray();

		for(UserProfile driver : drivers) {
			
			JSONObject jsonReport = new JSONObject();
			jsonReport.put("driver_id", driver.getId());
			jsonReport.put("driver_username", driver.getUserName());
			jsonReport.put("driver_email", driver.getEmail());
			jsonReport.put("driver_image", "fdhfdhfdfd");
			
			result_data.add(jsonReport);
		}
		
		json.put("result_data", result_data);
		
		
		response.getWriter().print(json);
		
	}

}
