package controller.restServices.userProfile;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UserProfile;
import com.ibm.json.java.JSONArray;
import com.ibm.json.java.JSONObject;
import dao.UserProfileDoa;
import dao.UserProfileDoaImpl;

/**
 * Servlet implementation class UserProfileServlet
 */
@WebServlet("/loginUser")
public class LoginUserServlet extends  HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		login(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		login(request,response);
	}
	
	void login(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		
		UserProfileDoa userProfileDoa = new UserProfileDoaImpl();
		UserProfile user = userProfileDoa.login(userName, passWord);
		
		JSONObject json = new JSONObject();
		
		if(user == null){
			json.put("message", "Login Failed");
			json.put("result_code", 1);
		}else{
			json.put("message", "success");
			json.put("result_code", 0);
		}
	
		JSONArray result_data = new JSONArray();

		json.put("result_data", result_data);
		
		response.getWriter().print(json);
	}

}
