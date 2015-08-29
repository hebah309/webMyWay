package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.IncidentReport;

public class ReportsDoaImpl implements ReportsDao{
	
	public EntityManager getMyWayEntityManager() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("myway");
		return emf.createEntityManager();
	}
	
	public List<IncidentReport> getAllPendingReports() {
		
		EntityManager em = this.getMyWayEntityManager();
		
		Query query = em.createQuery("select reports from IncidentReport reports where reports.reportStatus = 'pending'");
		
		return query.getResultList();
	}
	
	public void updateReportStatus(int id, String status) {
		
		EntityManager em = this.getMyWayEntityManager();
		
		IncidentReport incidentReport = em.find(IncidentReport.class, id);
		
		incidentReport.setReportStatus(status);
		
		em.getTransaction().begin();
		em.merge(incidentReport);
		em.getTransaction().commit();
	}
	
	public void addReport(IncidentReport incidentReport) {
		
		EntityManager em = this.getMyWayEntityManager();
		em.getTransaction().begin();
		em.persist(incidentReport);
		em.getTransaction().commit();
		
	}

}
