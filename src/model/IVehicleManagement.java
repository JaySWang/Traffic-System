package model;

import java.util.List;

public interface IVehicleManagement {

	public List<IVehicle> getVehicles();

	void setIntervalTime(int sec);
	
	void addVehicle(IVehicle v);
	
}
