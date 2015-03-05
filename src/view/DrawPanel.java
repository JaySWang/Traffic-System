package view;

import java.awt.Graphics;
import java.awt.Panel;
import java.awt.Rectangle;
import java.util.List;

import javax.swing.ImageIcon;

import model.IVehicle;
import model.IVehicleManagement;

import observer.IVehicleObservable;

public class DrawPanel extends Panel {

	List<IVehicle> vehicles;
    ImageIcon map;

public void paint(Graphics g){
	map = new ImageIcon(getClass().getResource("/Icon/map.png"));
	g.drawImage(map.getImage(),0,0,map.getIconWidth(),map.getIconHeight(),this);
	
	this.setBounds(new Rectangle(0,0,map.getIconWidth(),map.getIconHeight()));
	
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
