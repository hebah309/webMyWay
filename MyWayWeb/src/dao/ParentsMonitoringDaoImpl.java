package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ibm.json.java.JSONArray;
import com.ibm.json.java.JSONObject;

import model.Journey;
import model.UserInfo;


public class ParentsMonitoringDaoImpl implements ParentsMonitoringDao{
	
	
	public EntityManager getMyWayEntityManager(){
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("myway");
		return emf.createEntityManager();
	}

	@Override
	public List<Journey> getJourneysForParent(String userName) {
		
		List<Journey> journeys = new ArrayList<Journey>();
		
		EntityManager em = this.getMyWayEntityManager();

		try {
			
			Query q = em.createQuery("select u from UserInfo u where u.userName='"+userName+"'");
			List<UserInfo> user = q.getResultList();
			journeys =  user.get(0).getJourneies();
				
			
		} catch (NoResultException e) {
			System.out.println("user does not exist");
		}
		return journeys;
	}
	
	

}
