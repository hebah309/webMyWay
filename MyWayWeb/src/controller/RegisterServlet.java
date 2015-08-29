package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserInfoDoa;
import dao.UserInfoDoaImpl;
import model.UserInfo;

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegisterServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		register(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		register(request,response);
	}


	private void register(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		UserInfo ui = new UserInfo();

		ui.setFirstName(request.getParameter("FirstName"));
		ui.setLastName(request.getParameter("Lastname"));
		ui.setUserName(request.getParameter("username"));
		ui.setPassWord(request.getParameter("password"));
		ui.setEmail(request.getParameter("email"));
		ui.setMobile(request.getParameter("mobile"));
		ui.setUserRole(request.getParameter("userRole").trim());
		
		UserInfoDoa userInfoDoa = new UserInfoDoaImpl();
		
		boolean userExists = userInfoDoa.registerUser(ui);
		
		if(userExists){
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/register.jsp?userExists=true");
			dispatcher.forward(request, response);
		}else{
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/userlogin.jsp");
			dispatcher.forward(request, response);
		}
		
		
	}

}
