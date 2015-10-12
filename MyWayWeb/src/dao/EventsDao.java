package dao;

import java.util.List;

import model.Event;


public interface EventsDao {

	void submitEvent(Event event);

	List<Event> getEvents();

	void reviewEvent(String choice, int id);

	List<Event> getPendingEvents();
}
