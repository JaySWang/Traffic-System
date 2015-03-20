package modelInterface;

public interface IVehicle {

	public int getLocation_x();
	public int getLocation_y();
	public int getWidth();
	public int getLength();
	public int getId();
	public int getSpeed();
	public int getAcceleration();
	public int getDirection();
	
	public void setAcceleration(int acceleration);
	
	public void setLocation_x(int location_x);

	public void setLocation_y(int location_y);

	public void setWidth(int width);

	public void setLength(int length);

	
	public void setSpeed(int speed);


	
}
