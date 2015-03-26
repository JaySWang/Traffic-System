package model.vehicles;

import javax.swing.ImageIcon;

import constValue.ConstValues;

public class Coach extends VehicleWithRec{

	public Coach(int id, int location_x, int location_y,
			int angle,int behavior) {
		super(id, location_x, location_y, angle, behavior);
        
		width = 25;
		length = 30;
		speedLimit = ConstValues.CoachSpeedLimit;
		acceleration = ConstValues.CoachAcceleration;
		
		
		carIcon = new ImageIcon(getClass().getResource("/Icon/coach.jpg"));
		setRectangle();

	}

}
