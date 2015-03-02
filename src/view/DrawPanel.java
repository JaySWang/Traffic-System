package view;

import java.awt.Graphics;
import java.awt.Panel;
import java.util.List;

import model.IVehicle;
import model.IVehicleManagement;

import observer.IVehicleObservable;

public class DrawPanel extends Panel {

	List<IVehicle> vehicles;
	
public void paint(Graphics g){
	
	if(vehicles!=null){
	for(IVehicle v:vehicles){
		g.drawRect(v.getLocation_x(),v.getLocation_y(),v.getWidth(),v.getLength());
		
	}
	}
	
}

public void update(IVehicleObservable o) {
vehicles = ((IVehicleManagement)o).getVehicles();

Graphics g= this.getGraphics();
update(g);
}
	
	
}
