package dao;

import java.util.List;
import model.Favorite;

public interface FavoritesDao {
	
	void addFavorite(Favorite favorite);
	
	List<Favorite> getFavorites(String id);
	
	void deleteFavorite(String id, String name);
	
}
