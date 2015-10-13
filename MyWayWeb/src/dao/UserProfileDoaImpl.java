package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.UserProfile;

public class UserProfileDoaImpl implements UserProfileDoa {
	public EntityManager getMyWayEntityManager() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("myway");
		return emf.createEntityManager();
	}

	@Override
	public UserProfile login(String userName, String passWord) {
		UserProfile userProfile = null;

		EntityManager em = this.getMyWayEntityManager();

		Query q = em
				.createQuery("select u from UserProfile u where u.userName='"
						+ userName + "'and u.passWord = '" + passWord + "'");

		List<UserProfile> us = q.getResultList();

		if (us.size() != 0) {
			userProfile = us.get(0);
		}

		return userProfile;

	}

	@Override
	public UserProfile checkUserName(String userName) {
		EntityManager em = this.getMyWayEntityManager();

		UserProfile userProfile = null;

		Query q = em
				.createQuery("select u from UserProfile u where u.userName='"
						+ userName + "'");

		List<UserProfile> us = q.getResultList();

		if (us.size() != 0) {
			userProfile = us.get(0);
		}

		return userProfile;
	}

	@Override
	public void register(UserProfile userProfile) {
		EntityManager em = this.getMyWayEntityManager();
		em.getTransaction().begin();
		em.persist(userProfile);
		em.getTransaction().commit();
	}

	@Override
	public UserProfile retriveUserProfile(String userName) {
		UserProfile userProfile = null;

		EntityManager em = this.getMyWayEntityManager();

		Query q = em
				.createQuery("select u from UserProfile u where u.userName='"
						+ userName + "'");
		List<UserProfile> us = q.getResultList();

		if (us.size() != 0) {
			userProfile = us.get(0);
		}

		return userProfile;
	}

	@Override
	public void updateUserProfile(String username, String password,
			String email, String picture) {
		EntityManager em = this.getMyWayEntityManager();

		Query query = em.createQuery("update UserProfile u set u.passWord ='"
				+ password + "' where u.userName='" + username + "'");

		em.getTransaction().begin();
		query.executeUpdate();
		em.getTransaction().commit();
		query = em.createQuery("update UserProfile u set u.email ='" + email
				+ "' where u.userName='" + username + "'");

		em.getTransaction().begin();
		query.executeUpdate();
		em.getTransaction().commit();

		query = em.createQuery("update UserProfile u set u.profilePicture ='"
				+ picture + "' where u.userName='" + username + "'");

		em.getTransaction().begin();
		query.executeUpdate();
		em.getTransaction().commit();

	}

}
