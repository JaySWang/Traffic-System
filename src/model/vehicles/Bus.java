package model.vehicles;

import javax.swing.ImageIcon;

import constValue.ConstValues;

public class Bus extends VehicleWithRec{

	public Bus(int id, int location_x, int location_y,
			int angle) {
		super(id, location_x, location_y, angle);
		
		  
				width = 30;
				length = 40;
				speed = ConstValues.BusSpeed;
				desireSpeed = speed;
		carIcon = new ImageIcon(getClass().getResource("/Icon/bus.jpg"));

		// TODO Auto-generated constructor stub
		setRectangle();

	
	}

}
