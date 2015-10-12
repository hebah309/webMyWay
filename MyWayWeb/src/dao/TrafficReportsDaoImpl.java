package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.TrafficReport;

public class TrafficReportsDaoImpl implements  TrafficReportsDao{
	
	public EntityManager getMyWayEntityManager() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("myway");
		return emf.createEntityManager();
	}
	
	
	public List<TrafficReport> getAllTrafficReports() {
		
		EntityManager em = this.getMyWayEntityManager();
		
		Query query = em.createQuery("select reports from TrafficReports reports");
		
		return query.getResultList();
	}
	
	public void addReport(TrafficReport trafficReport) {
		
		EntityManager em = this.getMyWayEntityManager();
		em.getTransaction().begin();
		em.persist(trafficReport);
		em.getTransaction().commit();
		
	}
	

}