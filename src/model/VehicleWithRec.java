package model;

import java.awt.Rectangle;

import constValue.ConstValues;

import modelInterface.IVehicle;

public class VehicleWithRec implements IVehicle {

	private int id;
	private int width;
	private int length;
	private int location_x;
	private int location_y;
	private int speed;// if the refresh 0.1s,the min speed is 1m/s therefore
						// every pixel represent 0.1 meter
	private int angle;// 0-360
	private int acceleration;

	
	private double updateIntervar = 0.1;
	
	private int status;// next position will calculate based on this information
	/*
	 * 0: normal; 1: emergency stop; 2: stop; 4: recover from emergency stop;
	 */

	private String next;// what will the vehicle do
	
	
	private Rectangle rectangle;
	
	
	
	public VehicleWithRec(int id, int width, int length, int location_x,
			int location_y, int angle, int speed) {
		super();
		this.id = id;
		this.width = width;
		this.length = length;
		this.location_x = location_x;
		this.location_y = location_y;
		this.speed = speed;
		this.angle = angle;
		
		setRectangle();
		
	}
	
	
	
	
	
	public VehicleWithRec() {
		// TODO Auto-generated constructor stub
	}





	public Rectangle getRectangle() {
		return rectangle;
	}





	private void setRectangle() {
		

		
		int x = getLocation_x();
		int y = getLocation_y() ;
		int width = getLength();
        int height = getWidth();
        
        double  increment = getSpeed()*updateIntervar;
		switch(getAngle()){
		case ConstValues.EastToWest:
			y-=getWidth();
			x = (int)(x - increment);
			width = (int)(width+increment);
		break;
    	case ConstValues.WestToEest:
    		x-=getLength();
    	    width = (int)(width+increment);
		break;
		case ConstValues.NorthToSouth: 
			x-=getWidth();
			y-=getLength();
			int temp = height;
			height =(int)(width + increment) ;
			width = temp;
		break;
		case ConstValues.SouthToNorth: 
		int temp2 = height;
		height =(int)(width + increment) ;
		width = temp2;
		y = (int)(y - increment);
		break;
		
		}

		

		


	
		
		
		rectangle = new Rectangle( x, y,width,height);
	}





	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}





	public int getWidth() {
		return width;
	}





	public void setWidth(int width) {
		this.width = width;
	}





	public int getLength() {
		return length;
	}





	public void setLength(int length) {
		this.length = length;
	}





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





	public int getSpeed() {
		return speed;
	}





	public void setSpeed(int speed) {
		this.speed = speed;
	}





	public int getAngle() {
		return angle;
	}





	public void setAngle(int angle) {
		this.angle = angle;
	}





	public int getAcceleration() {
		return acceleration;
	}





	public void setAcceleration(int acceleration) {
		this.acceleration = acceleration;
	}





	public int getStatus() {
		return status;
	}





	public void setStatus(int status) {
		this.status = status;
	}





	public String getNext() {
		return next;
	}





	public void setNext(String next) {
		this.next = next;
	}



}
