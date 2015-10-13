package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.DriverDashBoard;
import model.DriverDestination;
import model.DriverReport;
import model.UserProfile;

public class ParentMonitoringDaoImpl implements ParentMonitoringDao {

	public EntityManager getMyWayEntityManager() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("myway");
		return emf.createEntityManager();
	}

	@Override
	public List<UserProfile> getAllDrivers(String parentUserName) {
		EntityManager em = this.getMyWayEntityManager();

		Query q = em.createQuery("select u from UserProfile u where u.parent='"
				+ parentUserName + "'");
		List<UserProfile> us = q.getResultList();

		return us;
	}

	@Override
	public void addDriver(String parentUserName, UserProfile driver) {

		driver.setParent(parentUserName);

		EntityManager em = this.getMyWayEntityManager();
		em.getTransaction().begin();
		em.persist(driver);
		em.getTransaction().commit();

	}

	@Override
	public List<DriverReport> getAllDriverReports(UserProfile driverProfile) {

		EntityManager em = this.getMyWayEntityManager();
		List<DriverReport> driverReports = null;
		Query q = em
				.createQuery("select d from DriverReport d,UserProfile u where u.Id="
						+ driverProfile.getId());
		driverReports = q.getResultList();
		return driverReports;
	}

	@Override
	public DriverDashBoard getDriverDashBoard(UserProfile driverProfile) {
		EntityManager em = this.getMyWayEntityManager();
		DriverDashBoard driverDashBoard = null;
		Query q = em
				.createQuery("select d from DriverDashBoard d,UserProfile u where u.Id="
						+ driverProfile.getId());
		driverDashBoard = (DriverDashBoard)q.getSingleResult();
		return driverDashBoard;
	}

	@Override
	public void setDriverDestination(DriverDestination driverDestination) {
		EntityManager em = this.getMyWayEntityManager();
		em.getTransaction().begin();
		em.persist(driverDestination);
		em.getTransaction().commit();
	}

	@Override
	public DriverDestination getDriverDestination(UserProfile driverProfile) {
		EntityManager em = this.getMyWayEntityManager();
		DriverDestination driverDestination = null;
		Query q = em
				.createQuery("select d from DriverDestination d,UserProfile u where u.Id="
						+ driverProfile.getId());
		driverDestination = (DriverDestination)q.getSingleResult();
		return driverDestination;
	}

	@Override
	public void setDriverDashBoard(DriverDashBoard driverDashBoard) {
		EntityManager em = this.getMyWayEntityManager();
		em.getTransaction().begin();
		em.persist(driverDashBoard);
		em.getTransaction().commit();
	}

}
