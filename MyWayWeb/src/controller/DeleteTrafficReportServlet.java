package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.TrafficReportsDao;
import dao.TrafficReportsDaoImpl;


/**
 * Servlet implementation class DeleteTrafficReport
 */
@WebServlet("/deleteTrafficReport")
public class DeleteTrafficReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTrafficReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		deleteReport(request,response);
		response.sendRedirect("ReviewTrafficReports.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		deleteReport(request,response);
		response.sendRedirect("ReviewTrafficReports.jsp");
	}
	
	void deleteReport(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TrafficReportsDao report = new TrafficReportsDaoImpl();
		
		String isDelete = request.getParameter("delete");	
		report.deleteReport(isDelete);
		
		
	
	}


}
