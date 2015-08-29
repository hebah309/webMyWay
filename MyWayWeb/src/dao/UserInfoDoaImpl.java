package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.UserInfo;

public class UserInfoDoaImpl implements UserInfoDoa{

	public EntityManager getMyWayEntityManager() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("myway");
		return emf.createEntityManager();
	}

	
	@Override
	public UserInfo login(String userName, String passWord) {
		UserInfo userInfo = null;
		
		EntityManager em = this.getMyWayEntityManager();
		
		Query q = em.createQuery("select u from UserInfo u where u.userName='"
				+ userName + "' and u.passWord = '" + passWord+"'");
		List<UserInfo> us = q.getResultList();
		
		if(us.size() != 0){
			userInfo = us.get(0);
		}
		
		return userInfo;
	}

	@Override
	public boolean registerUser(UserInfo userInfo) {
		boolean userNameExists = true;
		
		EntityManager em = this.getMyWayEntityManager();
		
		Query q = em.createQuery("select u from UserInfo u where u.userName='"+userInfo.getUserName()+"'");
		List<UserInfo> dbUser = q.getResultList();
		
		if(dbUser.size() == 0){
			userNameExists = false;
			em.getTransaction().begin();
			em.persist(userInfo);
			em.getTransaction().commit();
		}
		return userNameExists;
	}

}
