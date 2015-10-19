package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.DigitalAddress;

public class DigitalAddressDaoImpl implements DigitalAddressDao{

	public EntityManager getMyWayEntityManager() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("myway");
		return emf.createEntityManager();
	}
	
	@Override
	public DigitalAddress getLatLong(int digitalAddress) {
		// TODO Auto-generated method stub
		
		EntityManager em = this.getMyWayEntityManager();
		DigitalAddress da = null;
		
		Query q = em.createQuery("SELECT address FROM DigitalAddress address where address.digitalNumber ="+digitalAddress+"");
		da = (DigitalAddress) q.getSingleResult();
		return da;
	}

}
