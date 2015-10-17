package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.UserProfile;

/**
 * Servlet implementation class CheckLoginServlet
 */
@WebServlet("/CheckLogin")
public class CheckLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckLoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		checkLogin(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		checkLogin(request, response);
	}

	private void checkLogin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		UserProfile user = (UserProfile) session.getAttribute("user");

		if (user != null) {
			String isAdmin = (String)session.getAttribute("isAdmin");
			
			if ("true".equalsIgnoreCase(isAdmin)) {
				response.sendRedirect("admin.jsp");
			} else {
				response.sendRedirect("userHome.jsp");
			}
		}
		else
		{
			response.sendRedirect("userlogin.jsp");
		}
	}

}
