package dao;
import model.UserProfile;

public interface UserProfileDoa {
 
		
		UserProfile login(String userName,String passWord);
		UserProfile checkUserName(String userName);
		void register(UserProfile up);
		UserProfile retriveUserProfile(String userName);
		void updateUserProfile(String username,String password, String email, String picture);

	}


