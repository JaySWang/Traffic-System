package view;

import java.awt.AWTException;
import java.awt.Graphics;
import java.awt.IllegalComponentStateException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import javax.swing.JPanel;

import Tools.ScreenShotofMap;

import ControllerInterface.ITrafficLightController;

import constValue.ConstValues;

import mapInfo.Light;
import modelInterface.ITrafficLight;
import modelInterface.IVehicle;
import modelInterface.IVehicleManagement;

import observer.ITrafficLightObservable;
import observer.ITrafficLightObserver;
import observer.IVehicleObservable;

public class MapView extends JPanel implements ITrafficLightObserver {
	ScreenShotofMap s = new ScreenShotofMap();

	List<IVehicle> vehicles;
	ImageIcon map;

	ImageIcon carIcon = new ImageIcon(getClass().getResource("/Icon/cars.jpg"));
	
	int trafficLightState = ConstValues.OFF;

	List<Light> lightList;

	List<ITrafficLight> trafficLights;
	ITrafficLightController trafficLightController;

	public MapView(List<ITrafficLight> t, ITrafficLightController c) {
		super();
		trafficLights = t;
		trafficLightController = c;

	}

	public void setTrafficLightState(int tls) {
		trafficLightState = tls;
		if(trafficLightState == ConstValues.ON){
			trafficLightController.on();
		}else{
			trafficLightController.off();

		}
	
	}

	
	


	
	//screenShot
	
	public void paint(Graphics g) {
		super.paint(g);
	
	}
	
	public void update(Graphics g){

	    try {

			s.updateScreenShot(this);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(IllegalComponentStateException e){
			e.printStackTrace();

		}
		
		g.drawImage(map.getImage(), 0, 0, map.getIconWidth(),map.getIconHeight(), this);
		
		if (trafficLightState == ConstValues.ON) {
			for (Light l : lightList) {

				g.drawImage(l.getState().getImage(), l.getLocation_x(), l.getLocation_y(),
						l.getLightSize(), l.getLightSize(), this);

			}
		}

		if (vehicles != null) {
			for (IVehicle v : vehicles) {
				
				int x = v.getLocation_x();
				int y = v.getLocation_y() ;
				int width = v.getLength();
                int height = v.getWidth();
                
				switch(v.getAngle()){
				case ConstValues.EastToWest: y-=v.getWidth();
					break;
				case ConstValues.WestToEest: x-=v.getLength();
				break;
				case ConstValues.NorthToSouth: 
					x-=v.getWidth();
					y-=v.getLength();
					int temp = height;
					height = width;
					width = temp;
				break;
				case ConstValues.SouthToNorth: 
				int temp2 = height;
				height = width;
				width = temp2;
				break;
				
				}
				g.drawImage(carIcon.getImage(), x, y,
						width,height, this);
				
		
				


			}
		}
	}

	
	
	
	public void update(IVehicleObservable o) {
		vehicles = ((IVehicleManagement) o).getVehicles();

		Graphics g = this.getGraphics();
		update(g);
	}

	@Override
	public void update(ITrafficLightObservable o) {

		List states = ((ITrafficLight) o).getStates();

		int no = ((ITrafficLight) o).getNo();

		int position = getLightPosition(no);
		for (int i = 0; i < states.size(); i++) {


Light l = lightList.get(position + i);

			l.setState((Integer) states.get(i));

		}

	}

	private int getLightPosition(int no) {
		int position = 0;
		for (int i = 0; i < no; i++) {
			position += trafficLights.get(i).getNumberOfLights();
		}

		return position;
	}

	public void setIntervalTime(String selectedItem) {

		trafficLightController.setIntervalTime(selectedItem);
	}

}
