package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.POIType;
import model.PointOfInterest;

import com.ibm.json.java.JSONArray;
import com.ibm.json.java.JSONObject;

import dao.ParentsMonitoringDao;
import dao.ParentsMonitoringDaoImpl;
import dao.PointOfInterestDao;
import dao.PointOfInterestDaoImpl;

/**
 * Servlet implementation class PointsOfInterestServlet
 */
@WebServlet("/PointsOfInterest")
public class PointsOfInterestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PointsOfInterestServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		handlePointsOfInterest(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		handlePointsOfInterest(request, response);
	}

	private void handlePointsOfInterest(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		String action = request.getParameter("action");
		PointOfInterestDao pointOfInterestDao = new PointOfInterestDaoImpl();

		if ("loadPOITypes".equalsIgnoreCase(action)) {
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			List<POIType> poiTypes = pointOfInterestDao.getPOITypes();
			JSONArray jsonLocations = new JSONArray();
			for (POIType poiType : poiTypes) {
				JSONObject jsonLocation = new JSONObject();
				jsonLocation.put("typeID", poiType.getTypeId());
				jsonLocation.put("type", poiType.getType());
				jsonLocations.add(jsonLocation);
			}
			out.print(jsonLocations.toString());

		} else if ("PostPOI".equalsIgnoreCase(action)) {

			String name = request.getParameter("Name");
			String description = request.getParameter("Description");

			POIType poiType = new POIType();
			poiType.setTypeId(Integer.parseInt(request
					.getParameter("TypeSelection")));

			PointOfInterest pointOfInterest = new PointOfInterest(name,
					description, poiType);

			pointOfInterestDao.submitPOI(pointOfInterest);
			response.sendRedirect("viewPointsOfInterest.jsp");
		} else if ("loadPointOfInterest".equalsIgnoreCase(action)) {

			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			
			List<PointOfInterest> poiS = pointOfInterestDao.getPOIs();

			JSONArray jsonLocations = new JSONArray();
			for (PointOfInterest poi : poiS) {
				JSONObject jsonLocation = new JSONObject();

				jsonLocation.put("poiType", poi.getPoiType().getType());
				jsonLocation.put("namePOI", poi.getNamePOI());
				jsonLocations.add(jsonLocation);
			}
			out.print(jsonLocations.toString());

		}else if("loadPointsOfInterests".equalsIgnoreCase(action)){
			
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			List<PointOfInterest> pois =  pointOfInterestDao.getPendingPOIs();
			JSONArray jsonPointOfInterest = new JSONArray();
			for(PointOfInterest pointOfInterest : pois){
				JSONObject jsonPOI = new JSONObject();
				jsonPOI.put("POIName", pointOfInterest.getNamePOI());
				int id = pointOfInterest.getId();
				jsonPOI.put("id", id);
				jsonPointOfInterest.add(jsonPOI);
			}
		
			out.print(jsonPointOfInterest.toString());
			
		} else if("ReviewPOI".equalsIgnoreCase(action)){
		
			int id=Integer.parseInt(request.getParameter("selectedId"));
			
			String choice = request.getParameter("selectedChoice");
			
			pointOfInterestDao.reviewPOI(choice, id);
			response.sendRedirect("reviewPointsOfInterest.jsp");
		}

	}

}
