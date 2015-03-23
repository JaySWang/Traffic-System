package modelInterface;

import java.util.List;

public interface IVehicleManagement {

	public List<IVehicle> getVehicles();
	public List<IVehicle> getCloneVehicles();

	void setIntervalTime(int sec);
	
	void addVehicle(IVehicle v);
	
}
