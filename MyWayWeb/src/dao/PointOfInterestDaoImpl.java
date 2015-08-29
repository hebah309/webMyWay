package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.POIType;
import model.PointOfInterest;

public class PointOfInterestDaoImpl implements PointOfInterestDao {

	public EntityManager getMyWayEntityManager() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("myway");
		return emf.createEntityManager();
	}

	public List<POIType> getPOITypes() {

		EntityManager em = this.getMyWayEntityManager();
		Query q = em.createNamedQuery("getPoiTypes");
		List<POIType> poiTypes = q.getResultList();
		return poiTypes;
	}

	public void submitPOI(PointOfInterest poi) {

		EntityManager em = this.getMyWayEntityManager();

		em.getTransaction().begin();
		em.persist(poi);
		em.getTransaction().commit();

	}
	
	@Override
	public List<PointOfInterest> getPendingPOIs() {
		EntityManager em = this.getMyWayEntityManager();
		List<PointOfInterest> poiS = null;
		Query q = em.createQuery("SELECT poi FROM PointOfInterest poi where poi.status = 'P' ");
		poiS = q.getResultList();
		
		return poiS; 
	}

	@Override
	public List<PointOfInterest> getPOIs() {
		EntityManager em = this.getMyWayEntityManager();
		List<PointOfInterest> poiS = null;
		Query q = em.createQuery("SELECT poi FROM PointOfInterest poi where poi.status = 'A' ");
		poiS = q.getResultList();
		
		return poiS; 
	}
	
	public void reviewPOI(String choice, int id){
		EntityManager em = this.getMyWayEntityManager();
		
		PointOfInterest pointOfInterest = em.find(PointOfInterest.class, id);
		pointOfInterest.setStatus(choice.charAt(0));
		em.getTransaction().begin();
		em.merge(pointOfInterest);
		em.getTransaction().commit();
	}

}
