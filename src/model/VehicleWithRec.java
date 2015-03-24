package model;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import constValue.ConstValues;

import mapInfo.Junction;
import mapInfo.MapInfoManagement;
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

	private static int  count = 0;
	
	private double updateIntervar = 0.1;
	
	private int status;// next position will calculate based on this information
	/*
	 * 0: normal; 1: emergency stop; 2: stop; 4: recover from emergency stop;
	 */

	private String next;// what will the vehicle do
	
	
	private Rectangle rectangle;
	private Rectangle carRectangle;

	
	
	
	private  boolean vehicleCollision = false;
	
	
	
	public VehicleWithRec(int id, int width, int length, int location_x,
			int location_y, int angle, int speed) {
		super();
		this.id = count;
		count++;

		this.width = width;
		this.length = length;
		this.location_x = location_x;
		this.location_y = location_y;
		this.speed = speed;
		this.angle = angle;
		
		setRectangle();
		
	}
	
	
	
	





	public boolean isVehicleCollision() {
		return vehicleCollision;
	}









	public void setVehicleCollision(boolean vehicleCollision) {
		this.vehicleCollision = vehicleCollision;
	}









	public Rectangle getCarRectangle() {
		return carRectangle;
	}









	public void setCarRectangle(Rectangle carRectangle) {
		this.carRectangle = carRectangle;
	}









	public Rectangle getRectangle() {
		return rectangle;
	}





	private void setRectangle() {
		

		
		int x = getLocation_x();
		int cX = getLocation_x();
		int y = getLocation_y() ;
		int cY = getLocation_y() ;
		int width = getLength();
        int height = getWidth();
        int cWidth = getLength();
        int cHeight = getWidth();
        
        double  increment = getSpeed()*updateIntervar;
		switch(getAngle()){
		case ConstValues.EastToWest:
			y-=getWidth();
			cY = y;
			x = (int)(x - increment-1);
			width = (int)(width+increment+1);
		break;
    	case ConstValues.WestToEest:
    		x-=getLength();
    		cX = x;
    	    width = (int)(width+increment+1);
		break;
		case ConstValues.NorthToSouth: 
			x-=getWidth();
			y-=getLength();
			cX = x;
			cY = y;

			int temp = height;
			int cTemp = cHeight;
			
			height =(int)(width + increment+1) ;
			cHeight =cWidth; 
			width = temp;
			cWidth = cTemp;
		break;
		case ConstValues.SouthToNorth: 
		int temp2 = height;
		int cTemp2 = cHeight;
		height =(int)(width + increment+1) ;
		cHeight =cWidth; 

		width = temp2;
		cWidth = cTemp2;
		cY = y;

		y = (int)(y - increment);
		break;
		
		}

		
		rectangle = new Rectangle( x, y,width,height);
		carRectangle = new Rectangle( cX, cY,cWidth,cHeight);

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





	@Override
	public boolean update() {
		
//		   System.out.println("angle: "+this.id +" "+this.angle);

		
	int collisionState = collisionDetect();
		
		
		if(collisionState == ConstValues.Clear){
			
		
	         speed = 80;

		
        double  increment = getSpeed()*updateIntervar;

		switch(getAngle()){
		case ConstValues.EastToWest:
			location_x = (int)(location_x - increment);
		break;
    	case ConstValues.WestToEest:
			location_x = (int)(location_x + increment);

		break;
		case ConstValues.NorthToSouth: 
			location_y = (int)(location_y + increment);

		break;
		case ConstValues.SouthToNorth: 

			location_y = (int)(location_y - increment);

		break;
		
		}
		
		//update rectangle
		setRectangle();
		
		}
		
		else if (collisionState == ConstValues.VehicleCollision){
         speed = 0;
		}
		
		
		return true;
	}





	private int collisionDetect() {
		
		List<IVehicle>  vehicles = VehicleManagement.getInstance().getCloneVehicles();
		// passed by reference
		
		List<IVehicle>  tempVehicles =  (List<IVehicle>) ((ArrayList)vehicles).clone();
		tempVehicles.remove(this);
		
		List<Junction> junctions = MapInfoManagement.getInstance().getJunctions();

	for(IVehicle v:tempVehicles){
			
			
		if(this.getRectangle().intersects(((VehicleWithRec)v).getRectangle())){
				
				
			switch(this.getAngle()){
				case ConstValues.EastToWest:
					if(v.getAngle()==ConstValues.NorthToSouth){
					
						if(this.getRectangle().intersects(((VehicleWithRec)v).getCarRectangle())){
							vehicleCollision = true;
							return ConstValues.VehicleCollision;

						}
						vehicleCollision = false;

						
					}else if((v.getAngle() == ConstValues.SouthToNorth)){
						if(!((VehicleWithRec) v).isVehicleCollision()){
							return ConstValues.VehicleCollision;
							
						}
						
				
					}else if(this.location_x>v.getLocation_x()){
					
						
						return ConstValues.VehicleCollision;
					}
					break;
				case ConstValues.WestToEest:
					if(this.location_x<v.getLocation_x()){
						return ConstValues.VehicleCollision;
					}

				break;
				case ConstValues.NorthToSouth: 
					
			
						if((v.getAngle() == ConstValues.EastToWest)){
							if(!((VehicleWithRec) v).isVehicleCollision()){
								return ConstValues.VehicleCollision;
								
							}
							
					
						}else if(this.location_y<v.getLocation_y()){
						return ConstValues.VehicleCollision;
				
					}

				break;
				
				case ConstValues.SouthToNorth: 
					if(v.getAngle()==ConstValues.EastToWest){
						
						if(this.getRectangle().intersects(((VehicleWithRec)v).getCarRectangle())){
							vehicleCollision = true;
							return ConstValues.VehicleCollision;

						}
						vehicleCollision = false;

						
					}else if(this.location_y>v.getLocation_y()){
						return ConstValues.VehicleCollision;
					}

					
				break;
				
				}
				
				
				
			}
			

		}
		
		
		return	ConstValues.Clear;	
	}



}
