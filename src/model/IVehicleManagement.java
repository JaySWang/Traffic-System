package model;

import java.util.List;

public interface IVehicleManagement {

	public List<IVehicle> getVehicles();

	void setInterval(long msec);
	
	void addVehicle(IVehicle v);
	
}
