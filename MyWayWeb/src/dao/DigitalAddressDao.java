package dao;

import model.DigitalAddress;

public interface DigitalAddressDao {

	DigitalAddress getLatLong(int digitalAddress);
	
}
