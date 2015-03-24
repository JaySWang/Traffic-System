package mapInfo;

import java.awt.Rectangle;

public class Junction {
	
	
	Rectangle rectangle;
	
	int angle;
	
	int direction;
	
	int width;
	int hight;
	
	int location_x;
	int location_y;
	
	
	//  for a vehicle to change direction
	double possibility;
	
	
	
	public int getLocation_x() {
		return location_x;
	}

	public void setLocation_x(int location_x) {
		this.location_x = location_x;
	}

	public int getLocation_y() {
		return location_y;
	}




	public void setLocation_y(int location_y) {
		this.location_y = location_y;
	}




	public int getDirection() {
		return direction;
	}




	public void setDirection(int direction) {
		this.direction = direction;
	}




	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}




	public double getPossibility() {
		return possibility;
	}

	public void setPossibility(double possibility) {
		this.possibility = possibility;
	}

	public Junction(int location_x,int location_y,int direction,double possibility){
		width = 20;
		hight = 20;
		this.location_x = location_x;
		this.location_y = location_y;
		this.possibility = possibility;
		this.direction = direction;
		rectangle = new Rectangle(location_x,location_y,width,hight);
		
	}




	public Rectangle getRectangle() {
		return rectangle;
	}




	public int getAngle() {
		return angle;
	}




	public void setAngle(int angle) {
		this.angle = angle;
	}
	
	
	

	
	
}
