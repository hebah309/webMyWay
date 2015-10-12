package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Event;

public class EventsDaoImpl implements EventsDao{

	public EntityManager getMyWayEntityManager() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("myway");
		return emf.createEntityManager();
	}
	
	
	@Override
	public void submitEvent(Event event) {
		// TODO Auto-generated method stub
		EntityManager em = this.getMyWayEntityManager();

		em.getTransaction().begin();
		em.persist(event);
		em.getTransaction().commit();
	}

	//retrieve all approved events from DB
	@Override
	public List<Event> getEvents() {
		// TODO Auto-generated method stub
		EntityManager em = this.getMyWayEntityManager();
		List<Event> events = null;
		Query q = em.createQuery("SELECT event FROM Event event where event.status = 'approved' ");
		events = q.getResultList();
		
		return events;
	}

	@Override
	public void reviewEvent(String choice, int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Event> getPendingEvents() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
