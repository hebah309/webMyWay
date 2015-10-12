package controller.restServices.parentMonitoring;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UserProfile;
import com.ibm.json.java.JSONArray;
import com.ibm.json.java.JSONObject;
import dao.ParentMonitoringDao;
import dao.ParentMonitoringDaoImpl;
import dao.UserProfileDoa;
import dao.UserProfileDoaImpl;


/**
 * Servlet implementation class AddUserDriverServlet
 */
@WebServlet("/addUserDriver")
public class AddUserDriverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserDriverServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		addUserDriver(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		addUserDriver(request,response);
	}

	private void addUserDriver(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		String parentUserName = request.getParameter("parentUserName");
		
		String driverIdentifier = request.getParameter("driverIdentifier");
		
		
		UserProfileDoa userProfileDoa = new UserProfileDoaImpl();
		UserProfile driverProfile = userProfileDoa.retriveUserProfile(driverIdentifier);
		
		JSONObject json = new JSONObject();
		
		if(driverProfile != null){
			ParentMonitoringDao parentMonitoringDao = new ParentMonitoringDaoImpl();
			parentMonitoringDao.addDriver(parentUserName, driverProfile);
			
			json.put("message", "success");
			json.put("result_code", 0);
		}else{
			json.put("message", "failed");
			json.put("result_code", 1);
		}
			
		JSONArray result_data = new JSONArray();
		json.put("result_data", result_data);
		
		
		response.getWriter().print(json);
		
		
	}

}
