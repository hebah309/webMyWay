package controller.restServices.trafficReport;


import java.util.List;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.json.java.JSONArray;
import com.ibm.json.java.JSONObject;

import dao.TrafficReportsDao;
import dao.TrafficReportsDaoImpl;
import model.TrafficReport;

/**
 * Servlet implementation class viewAllTrafficReport
 */
@WebServlet("/viewAllTrafficReports")
public class viewAllTrafficReportsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewAllTrafficReportsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		viewAllTrafficReport(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		viewAllTrafficReport(request,response);
		
	}

	void viewAllTrafficReport(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		System.out.print("hellooooooooooooooooooooo");
		
		TrafficReportsDao reportsDao = new TrafficReportsDaoImpl();
		List<TrafficReport> reportList = reportsDao.getAllTrafficReports();
		
		JSONArray result_data = new JSONArray();
		JSONObject json = new JSONObject();
		json.put("message", "success");
		json.put("result_code", 0);
		
		
		for (int i = 0; i < reportList.size(); i++){
			JSONObject jsonReport = new JSONObject();
			jsonReport.put("report_type", reportList.get(i).getReportTypeId());
			jsonReport.put("report_comments", reportList.get(i).getComment() );
			jsonReport.put("report_log",  reportList.get(i).getLon());
			jsonReport.put("report_lat",  reportList.get(i).getLat());
			
			result_data.add(jsonReport);
		}
		
		json.put("result_data", result_data);
		
		response.getWriter().print(json);
		
	}
	
	
}
