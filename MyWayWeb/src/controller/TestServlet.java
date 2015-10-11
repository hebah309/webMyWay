package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.json.java.JSONArray;
import com.ibm.json.java.JSONObject;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/Test")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		viewAllIncidentReports(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		viewAllIncidentReports(request,response);
	}
	
	void viewAllIncidentReports(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		JSONObject json = new JSONObject();
		json.put("message", "success");
		json.put("result_code", 0);
		
		
		JSONArray result_data = new JSONArray();

		for(int i = 1;i<4;i++) {
			
			JSONObject jsonReport = new JSONObject();
			jsonReport.put("report_type", i);
			jsonReport.put("report_comments", "this is report number "+ i);
			jsonReport.put("report_log", "47.2838870070633");
			jsonReport.put("report_lat", "29.763296470672");
			
			result_data.add(jsonReport);
		}
		
		json.put("result_data", result_data);
		
		
		response.getWriter().print(json);
	}

}
