package model.vehicles;

import javax.swing.ImageIcon;

import constValue.ConstValues;

public class Car extends VehicleWithRec{


	
	
	



	public Car(int id, int location_x, int location_y,
			int angle,int behavior) {
		super(id, location_x, location_y, angle,behavior);
		
		  
				width = 20;
				length = 25;
				speedLimit = ConstValues.CarSpeedLimit;
				acceleration = ConstValues.CarAcceleration;
				
		carIcon = new ImageIcon(getClass().getResource("/Icon/car.jpg"));
		setRectangle();

	}

}
