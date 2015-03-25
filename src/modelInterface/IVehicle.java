package modelInterface;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

public interface IVehicle {

	public int getLocation_x();
	public int getLocation_y();
	public int getWidth();
	public int getLength();
	public int getId();
	public int getSpeed();
	public int getAcceleration();

	public int getAngle();
	public void setAcceleration(int acceleration);
	
	public void setLocation_x(int location_x);

	public void setLocation_y(int location_y);

	public void setWidth(int width);

	public void setLength(int length);

	
	public boolean withPriority();
	
	public void setSpeed(int speed);
	public void setAngle(int angle);
	public boolean update();
	
	public ImageIcon getCarIcon();
	public Rectangle getCarRectangle();

	
}
