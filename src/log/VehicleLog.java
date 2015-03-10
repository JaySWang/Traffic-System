package log;

public class VehicleLog {
	
	int vehicle_id;
	int position_x;
	int position_y;
	int speed;
	int time;
	public VehicleLog(int vehicle_id, int position_x, int position_y,
			int speed, int time) {
		super();
		this.vehicle_id = vehicle_id;
		this.position_x = position_x;
		this.position_y = position_y;
		this.speed = speed;
		this.time = time;
	}
	
	
	
	public int getVehicle_id() {
		return vehicle_id;
	}
	public int getPosition_x() {
		return position_x;
	}
	public int getPosition_y() {
		return position_y;
	}
	public int getSpeed() {
		return speed;
	}
	public int getTime() {
		return time;
	}

	
	
	
	
	
	
	
}

