package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserInfo;
import dao.UserInfoDoa;
import dao.UserInfoDoaImpl;


@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		login(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		login(request,response);
	}


	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		
		//for admins
		if("admin".equalsIgnoreCase(userName)&&"123admin".equalsIgnoreCase(passWord)){
			
			UserInfo user = new UserInfo();
			user.setUserRole("admin");
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/admin.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		//for other registered users
		UserInfoDoa userInfoDoa = new UserInfoDoaImpl();
		
		UserInfo user = userInfoDoa.login(userName, passWord);
		
		if("webLogin".equalsIgnoreCase(request.getParameter("loginType"))){
			if(user != null){
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				response.sendRedirect("userHome.jsp");
			}else{
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("/userlogin.jsp?invalidLogin=true");
				dispatcher.forward(request, response);
			}	
		}
		
	}

}
