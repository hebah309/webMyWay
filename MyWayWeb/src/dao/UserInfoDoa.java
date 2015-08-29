package dao;

import model.UserInfo;

public interface UserInfoDoa {
	
	UserInfo login(String userName,String passWord);
	
	boolean registerUser(UserInfo userInfo);

}
