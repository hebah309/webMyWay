package controller.restServices.digitalAddress;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DigitalAddress;
import model.Event;

import com.ibm.json.java.JSONArray;
import com.ibm.json.java.JSONObject;

import dao.DigitalAddressDaoImpl;
import dao.EventsDaoImpl;

/**
 * Servlet implementation class DigitalAddressServlet
 */
@WebServlet("/DigitalAddress")
public class DigitalAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DigitalAddressServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getLatLong(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getLatLong(request,response);
	}

	
void getLatLong(HttpServletRequest request, HttpServletResponse response) throws IOException{

		DigitalAddressDaoImpl dadi = new DigitalAddressDaoImpl();
		
		
		int digitalNumber = Integer.parseInt(request.getParameter("digitalAddress"));
		DigitalAddress tempDA = dadi.getLatLong(digitalNumber);
		String latitude = tempDA.getLatitude();
		String longitude = tempDA.getLongitude();
		
		JSONObject json = new JSONObject();
		json.put("message", "success");
		json.put("result_code", 0);
		
		
		JSONArray result_data = new JSONArray();


			JSONObject jsonReport = new JSONObject();
			

			jsonReport.put("latitude", latitude);
			jsonReport.put("longitude", longitude);
			
			result_data.add(jsonReport);
		
		json.put("result_data", result_data);
		
		
		response.getWriter().print(json);
	}

}
