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
import model.VehicleManagement;
import modelInterface.IVehicle;

public class VehicleWithRec implements IVehicle {

	private int id;
	 int width;
	 int length;
	private int location_x;
	private int location_y;
	 int speed;// if the refresh 0.1s,the min speed is 1m/s therefore
						// every pixel represent 0.1 meter
	 
	 int desireSpeed;
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

	
	ImageIcon carIcon; 
	
	private  boolean vehicleCollision = false;
	
	
	
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
			x = (int)(x - increment-3);
			width = (int)(width+increment+3);
		break;
    	case ConstValues.WestToEest:
    		x-=getLength();
    		cX = x;
    	    width = (int)(width+increment+3);
		break;
		case ConstValues.NorthToSouth: 
			x-=getWidth();
			y-=getLength();
			cX = x;
			cY = y;

			int temp = height;
			int cTemp = cHeight;
			
			height =(int)(width + increment+3) ;
			cHeight =cWidth; 
			width = temp;
			cWidth = cTemp;
		break;
		case ConstValues.SouthToNorth: 
		int temp2 = height;
		int cTemp2 = cHeight;
		height =(int)(width + increment+3) ;
		cHeight =cWidth; 

		width = temp2;
		cWidth = cTemp2;
		cY = y;

		y = (int)(y - increment-3);
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
		
		
		if(exit()){
			return false;
		}
		
		//detect junctions and decide whether to turn.
		turn();
		
		
	int collisionState = collisionDetect();
		
		
		if(collisionState == ConstValues.Clear){
			
		
	         speed = desireSpeed;

		
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





	private boolean turn() {

		 List<Junction> junctions = MapInfoManagement.getInstance().getJunctions();
			for(Junction j:junctions){
				if(this.getCarRectangle().intersects(j.getRectangle())){
					
					//it is a turing junction with a possibility for the vehicle to change direction
					
					if((angle!=j.getDirection())&&(Math.random()<j.getPossibility())){
						angle = j.getDirection();
					switch(angle){
					case ConstValues.EastToWest:
					
						break;
					case ConstValues.WestToEest:
						location_x = j.getLocation_x()+length;
						location_y = j.getLocation_y();
					     setRectangle();
					
					break;
					case ConstValues.NorthToSouth: 
					
					break;
					
					case ConstValues.SouthToNorth: 
						location_x = j.getLocation_x();
						location_y = j.getLocation_y()-length;
					     setRectangle();
					break;			
					}
					
					
					}	
					
					return true;
				}
			}
		return false;
	}


	private boolean exit() {

		  List<Exit> exits = MapInfoManagement.getInstance().getExits();
		for(Exit e:exits){
			if(this.getCarRectangle().intersects(e.getRetangle())){
				return true;
			}
			
		}
		  
		  
		return false;
	}


	private int collisionDetect() {
		
		
		if(trafficLightCollision()){
			return ConstValues.VehicleCollision;

		}
		List<IVehicle>  vehicles = VehicleManagement.getInstance().getCloneVehicles();
		// passed by reference
		
		List<IVehicle>  tempVehicles =  (List<IVehicle>) ((ArrayList)vehicles).clone();
		tempVehicles.remove(this);
		
		//List<Junction> junctions = MapInfoManagement.getInstance().getJunctions();
	
		
		
		//when light is on, there is no need to give way 
		if(lightOn){
			for(IVehicle v:tempVehicles){
				if(this.getRectangle().intersects(((VehicleWithRec)v).getCarRectangle())){			
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
				
				
				return	ConstValues.Clear;	
			
		}
		
		
		
	
// there is no traffic light
	for(IVehicle v:tempVehicles){
			
		if(this.getCarRectangle().intersects(((VehicleWithRec)v).getCarRectangle())){	
			
			if((v.getLocation_x())<836&&(755<v.getLocation_x())){
				if((v.getLocation_y())<360&&(280<v.getLocation_y())){
					System.out.println(" crash:"+v.getLocation_x()+" "+v.getLocation_y	());

				}
			}
		}		
	
		if(this.getRectangle().intersects(((VehicleWithRec)v).getRectangle())){
				
			
	
			switch(this.getAngle()){
				case ConstValues.EastToWest:
					
					if(v.getAngle()==ConstValues.NorthToSouth){
					
						if(this.getRectangle().intersects(((VehicleWithRec)v).getCarRectangle())){
							vehicleCollision = true;
							return ConstValues.VehicleCollision;

						}
						vehicleCollision = false;

						
					}
//					else if((v.getAngle() == ConstValues.SouthToNorth)){
//						
//						
////						return ConstValues.VehicleCollision;
//
////						if(!((VehicleWithRec) v).isVehicleCollision()){
////							return ConstValues.VehicleCollision;
////							
////						}
//						
//				
//					}
			else if(this.location_x>v.getLocation_x()&&(this.getRectangle().intersects(((VehicleWithRec)v).getCarRectangle()))){
					
						
						return ConstValues.VehicleCollision;
					}
					break;
					
				case ConstValues.WestToEest:
					
//					if((v.getAngle() == ConstValues.NorthToSouth)){
//				//		return ConstValues.VehicleCollision;
////						if(!((VehicleWithRec) v).isVehicleCollision()){
////							return ConstValues.VehicleCollision;
////							
////						}
//					}
//						else
							if(v.getAngle()==ConstValues.SouthToNorth){
						
						if(this.getRectangle().intersects(((VehicleWithRec)v).getCarRectangle())){
							vehicleCollision = true;
							return ConstValues.VehicleCollision;

						}
						vehicleCollision = false;

						
					}else if(this.location_x<v.getLocation_x()&&(this.getRectangle().intersects(((VehicleWithRec)v).getCarRectangle()))){
						return ConstValues.VehicleCollision;
					}
				break;
				case ConstValues.NorthToSouth: 
					
			
//						if((v.getAngle() == ConstValues.EastToWest)){
//					//		return ConstValues.VehicleCollision;
////							if(!((VehicleWithRec) v).isVehicleCollision()){
////								return ConstValues.VehicleCollision;
////								
////							}
//						}
//							else
								if(v.getAngle()==ConstValues.WestToEest){
								
								if(this.getRectangle().intersects(((VehicleWithRec)v).getCarRectangle())){
									vehicleCollision = true;
									return ConstValues.VehicleCollision;

								}
								vehicleCollision = false;

						}else if(this.location_y<v.getLocation_y()&&(this.getRectangle().intersects(((VehicleWithRec)v).getCarRectangle()))){
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

						
					}
//					else if((v.getAngle() == ConstValues.WestToEest)){
//				//		return ConstValues.VehicleCollision;
////						if(!((VehicleWithRec) v).isVehicleCollision()){
////							return ConstValues.VehicleCollision;
////							
////						}
//						
//				
//					}
	
						
					else if((this.location_y>v.getLocation_y())&&(this.getRectangle().intersects(((VehicleWithRec)v).getCarRectangle()))){
						return ConstValues.VehicleCollision;
					}

					
				break;
				
				}
				
				
				
			}
			

		}
		
		
		return	ConstValues.Clear;	
	}









	private boolean trafficLightCollision() {

		
		
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



}
