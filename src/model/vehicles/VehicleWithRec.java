package model.vehicles;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import view.MapView;

import constValue.ConstValues;

import mapInfo.Exit;
import mapInfo.Junction;
import mapInfo.Light;
import mapInfo.MapInfoManagement;
import model.TrafficCondition;
import model.VehicleManagement;
import modelInterface.IVehicle;

public class VehicleWithRec implements IVehicle {

	 int id;
	 int width;
	 int length;
	 int location_x;
	 int location_y;
	 int speed;// if the refresh 0.1s,the min speed is 1m/s therefore
						// every pixel represent 0.1 meter
	 
	 
	 boolean priority = false ;
	 boolean giveWay = false;  //give way for vehicles with priority
	 
	 
	 
	 int gap = 10; //between vehicles;
	 int collisionCount=0;
	 
	 int speedLimit;//varies from vehivles to vehicles
	 
	 int angle;// 0-360
	
	int acceleration;

	 static int  count = 0;
	
	 double updateIntervar = 0.1;
	 
	 
	 
	
	private int status;// next position will calculate based on this information
	/*
	 * 0: normal; 1: emergency stop; 2: stop; 4: recover from emergency stop;
	 */

	private String next;// what will the vehicle do
	
	
	 Rectangle rectangle;
	 Rectangle carRectangle;

	
	ImageIcon carIcon; 
	
	private  boolean vehicleColision = false;
	
	
	
	boolean lightOn = false;
	
	
	public VehicleWithRec(int id, int location_x,
			int location_y, int angle) {
		super();
		this.id = count;
		count++;

	
		this.location_x = location_x;
		this.location_y = location_y;
		
		this.angle = angle;
		
		
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


	 void setRectangle() {
		

		
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
			x = (int)(x - increment-gap);
			width = (int)(width+increment+gap);
		break;
    	case ConstValues.WestToEest:
    		x-=getLength();
    		cX = x;
    	    width = (int)(width+increment+gap);
		break;
		case ConstValues.NorthToSouth: 
			x-=getWidth();
			y-=getLength();
			cX = x;
			cY = y;

			int temp = height;
			int cTemp = cHeight;
			
			height =(int)(width + increment+gap) ;
			cHeight =cWidth; 
			width = temp;
			cWidth = cTemp;
		break;
		case ConstValues.SouthToNorth: 
		int temp2 = height;
		int cTemp2 = cHeight;
		height =(int)(width + increment+gap) ;
		cHeight =cWidth; 

		width = temp2;
		cWidth = cTemp2;
		cY = y;

		y = (int)(y - increment-gap);
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
		int limit = TrafficCondition.getInstance().getSpeedLimit();
		if(limit!=-1){
    		if(speed>10*limit){
    			this.speed = 10*limit;
    		}else if (speed<speedLimit){
    			this.speed = speed;
    		}
    	}else{
			this.speed = speed;

    	}
		
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
		
		
		if(exitDetect()){
			return false;
		}
		
		//detect priority collision

		
		//detect junctions and decide whether to turn.
		
	int collisionState = collisionDetect();
	
	if(!(collisionState == ConstValues.Clear)&&collisionCount>10){
		//return from giving way to vehicles with priority 
				if(giveWay){		
				returnPosition();
				
				}
		turn();
		
		
	}else if(collisionState == ConstValues.Clear){
		
		//return from giving way to vehicles with priority 
		if(giveWay){		
		returnPosition();
		
		}
			turn();
			
			
			setSpeed(speed+acceleration);
			
		

		
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





	private void returnPosition() {
		// 
		switch(this.getAngle()){
		case ConstValues.EastToWest:
		this.location_y -= gap;
		setRectangle();
		break;
		case ConstValues.WestToEest:
			this.location_y += gap;
			setRectangle();
			break;
		case ConstValues.NorthToSouth:
			this.location_x -= gap;
			setRectangle();
			break;
		case ConstValues.SouthToNorth:
			this.location_x += gap;
			setRectangle();
			
        	}
	
		giveWay = false;

	}



	private int priorityDetect(IVehicle v) {
		
			if(this.getRectangle().intersects(((VehicleWithPriority) v).getPriorityRectangle())){
			switch(this.getAngle()){
			
			
			case ConstValues.EastToWest:
				//not giveway yet
				if(!giveWay){
					
					if(v.getAngle()==ConstValues.EastToWest||v.getAngle()==ConstValues.WestToEest){
			this.location_y += gap;
				setRectangle();
			giveWay = true;
			return ConstValues.VehicleCollision;

				}else
					return ConstValues.Clear;
				}
				break;
			case ConstValues.WestToEest:
				if(!giveWay){
					if(v.getAngle()==ConstValues.EastToWest||v.getAngle()==ConstValues.WestToEest){
						this.location_y -= gap;
				setRectangle();
			giveWay = true;
			return ConstValues.VehicleCollision;

				}else
					return ConstValues.Clear;

				}
				break;
			case ConstValues.NorthToSouth:
				if(!giveWay){
					if(v.getAngle()==ConstValues.NorthToSouth||v.getAngle()==ConstValues.SouthToNorth){
						this.location_x += gap;
				setRectangle();
			giveWay = true;
			return ConstValues.VehicleCollision;

					}else
						return ConstValues.Clear;

				}
				break;
			case ConstValues.SouthToNorth:
				if(!giveWay){
					if(v.getAngle()==ConstValues.NorthToSouth||v.getAngle()==ConstValues.SouthToNorth){
						this.location_x -= gap;
				setRectangle();
			giveWay = true;
			return ConstValues.VehicleCollision;

				}else
					return ConstValues.Clear;

				}
		      break;
	        	}
			
			return ConstValues.VehicleCollision;
		   }
		
		
	return ConstValues.Clear;
	}



	 boolean turn() {

		 List<Junction> junctions = MapInfoManagement.getInstance().getJunctions();
			for(Junction j:junctions){
				if(this.getCarRectangle().intersects(j.getRectangle())){
					
					//it is a turing junction with a possibility for the vehicle to change direction
					
					if((angle!=j.getDirection())&&(Math.random()<j.getPossibility())){
						angle = j.getDirection();
					switch(angle){
					case ConstValues.EastToWest:
						location_x = j.getLocation_x()+j.getWidth()-getLength();
						location_y = j.getLocation_y()+getWidth()-gap;
					     setRectangle();
						
					
						break;
					case ConstValues.WestToEest:
						location_x = j.getLocation_x()-j.getWidth()+getLength();
						location_y = j.getLocation_y();
					     setRectangle();
					
					break;
					case ConstValues.NorthToSouth: 
						location_x = j.getLocation_x()+getWidth();
						location_y = j.getLocation_y()+getLength();
					     setRectangle();

					
					     
					break;
					
					case ConstValues.SouthToNorth: 
						location_x = j.getLocation_x();
						location_y = j.getLocation_y()+j.getHeight()-getLength();
					     setRectangle();
					break;			
					}
					
					
					}	
					
					return true;
				}
			}
		return false;
	}


	 boolean exitDetect() {

		  List<Exit> exits = MapInfoManagement.getInstance().getExits();
		for(Exit e:exits){
			if((this.getRectangle().intersects(e.getRetangle()))&&this.getAngle()==e.getDirection()){
				return true;
			}
			
		}
		  
		  
		return false;
	}


	private int collisionDetect() {
		
		
		int collision = ConstValues.Clear;
		
		if(trafficLightDetect()){
			collision = ConstValues.VehicleCollision;

		}
		
		List<IVehicle>  vehicles = VehicleManagement.getInstance().getCloneVehicles();
		// passed by reference
		
		List<IVehicle>  tempVehicles =  (List<IVehicle>) ((ArrayList)vehicles).clone();
		tempVehicles.remove(this);
		
		//List<Junction> junctions = MapInfoManagement.getInstance().getJunctions();
	
		for(IVehicle v:tempVehicles){
			
			
			// priority detect
			if(v instanceof VehicleWithPriority){
			if(priorityDetect(v)==ConstValues.VehicleCollision){
				return ConstValues.VehicleCollision;
			  }
			}
		}
		
		
		
		//there is no priority vehicles
			for(IVehicle v:tempVehicles){
		
				
				if(this.getRectangle().intersects(v.getCarRectangle())){			
					switch(this.getAngle()){
						case ConstValues.EastToWest:

							if(this.location_x>v.getLocation_x()){
							
								
								return ConstValues.VehicleCollision;
							}
							break;
						case ConstValues.WestToEest:
							
							 if(this.location_x<v.getLocation_x()){
								return ConstValues.VehicleCollision;
							}
						break;
						case ConstValues.NorthToSouth: 
							
					if(this.location_y<v.getLocation_y()){
								return ConstValues.VehicleCollision;
						
							}

						break;
						
						case ConstValues.SouthToNorth: 
							 if(this.location_y>v.getLocation_y()){
								return ConstValues.VehicleCollision;
							}

							
						break;
						
						}
				
						
						
					}
					

				}
				
	
		
		
	
		
	  collisionCount=0;
		return	collision;
	}









	private boolean trafficLightDetect() {
		
		if(priority){
			return false;
		}

		
		
	 List<Light> lights =	MapView.getLightList();
	 
	 
	 lightOn = lights.get(0).isOn();
	 
	 if(lightOn){
	 for(Light l : lights){
		 
		 if(this.getRectangle().intersects(l.getRectangle())&&(l.getState()==ConstValues.RED)){
			 return true;
		 }
		 
	 }
	 }
		return false;
	}
	

	@Override
	public ImageIcon getCarIcon() {
		return  carIcon ;
	}


	@Override
	public boolean withPriority() {
		return priority;
	}



}
