package model.vehicles;

import javax.swing.ImageIcon;

import constValue.ConstValues;

public class Coach extends VehicleWithRec{

	public Coach(int id, int location_x, int location_y,
			int angle) {
		super(id, location_x, location_y, angle);
        
		width = 30;
		length = 45;
		speed = ConstValues.CoachSpeed;
		desireSpeed = speed;

		carIcon = new ImageIcon(getClass().getResource("/Icon/coach.jpg"));
		setRectangle();

	}

}
