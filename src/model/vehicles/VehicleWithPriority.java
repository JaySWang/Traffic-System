package model.vehicles;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import mapInfo.Junction;
import mapInfo.MapInfoManagement;
import model.VehicleManagement;
import modelInterface.IVehicle;

import constValue.ConstValues;

public class VehicleWithPriority  extends VehicleWithRec{
	
	private Rectangle priorityRectangle;
	
	private int priorityGap = 30;

	public VehicleWithPriority(int id, int location_x, int location_y, int angle,int behavior) {
		super(id, location_x, location_y, angle, behavior);

		
		
		width = 25;
		length = 30;
		speedLimit = ConstValues.CoachSpeedLimit;
		acceleration = ConstValues.CoachAcceleration;
		
		
		carIcon = new ImageIcon(getClass().getResource("/Icon/red.jpg"));
	
	priority = true;
	setRectangle();

	
	
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
	        
			int pX = getLocation_x();
			int pY = getLocation_y() ;
		    int pWidth = getLength();
		    int pHeight = getWidth();
	        
	        double  increment = getSpeed()*updateIntervar;
			switch(getAngle()){
			case ConstValues.EastToWest:
				y-=getWidth();
				cY = y;
				pY = y - priorityGap;
				x = (int)(x - increment-gap);
				pX = x;
				
				width = (int)(width+increment+gap);
				pWidth = width;
				pHeight +=2* priorityGap;
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
            
			pX -= priorityGap;
			pWidth+=2* priorityGap;
			
			y = (int)(y - increment-gap);
			pY = y;
			pHeight = height;
			break;
			
			}

			
			rectangle = new Rectangle( x, y,width,height);
			carRectangle = new Rectangle( cX, cY,cWidth,cHeight);
			priorityRectangle = new Rectangle( pX, pY,pWidth,pHeight);
		}




	public Rectangle getPriorityRectangle() {
		return priorityRectangle;
	}

private int collisionDetect() {
		
		
		int collision = ConstValues.Clear;
		
	
		List<IVehicle>  vehicles = VehicleManagement.getInstance().getCloneVehicles();
		// passed by reference
		
		List<IVehicle>  tempVehicles =  (List<IVehicle>) ((ArrayList)vehicles).clone();
		tempVehicles.remove(this);
		
		//List<Junction> junctions = MapInfoManagement.getInstance().getJunctions();
	
// there is no traffic light
	for(IVehicle v:tempVehicles){
				
		if(this.getRectangle().intersects(((VehicleWithRec)v).getCarRectangle())){
				
			return	ConstValues.VehicleCollision;
			}
			
	}
	return	ConstValues.Clear;

}


public void setSpeed(int speed) {

		this.speed = speed;

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
					location_x = j.getLocation_x()+19;
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

}
