package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Favorite;

public class FavoritesDaoImpl implements FavoritesDao{

	public EntityManager getMyWayEntityManager() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("myway");
		return emf.createEntityManager();
	}
	
	@Override
	public void addFavorite(Favorite favorite) {
		// TODO Auto-generated method stub
		EntityManager em = this.getMyWayEntityManager();

		em.getTransaction().begin();
		em.persist(favorite);
		em.getTransaction().commit();
	}

	@Override
	public List<Favorite> getFavorites(String id) {
		// TODO Auto-generated method stub
		EntityManager em = this.getMyWayEntityManager();
		List<Favorite> favs = null;
		Query q = em.createQuery("select f from Favorite f,UserProfile u where u.Id="+id);
		favs = q.getResultList();
		return favs;
	}

	@Override
	public void deleteFavorite(String id, String name) {
		// TODO Auto-generated method stub
		EntityManager em = this.getMyWayEntityManager();
		Favorite fav;

		Query q = em.createQuery("select f from Favorite f,UserProfile u where u.Id="+id+" and f.name='"+name+"'");
		fav = (Favorite) q.getSingleResult();

		em.getTransaction().begin();
		em.remove(fav);
		em.getTransaction().commit();
		
	}

}
