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
				
				if(v.getDirection() == ConstValues.EastToWest || v.getDirection() == ConstValues.WestToEest){
					g.drawImage(carIcon.getImage(), v.getLocation_x(), v.getLocation_y(),
							v.getLength(),v.getWidth(), this);
					
				}
				else{
					g.drawImage(carIcon.getImage(), v.getLocation_x(), v.getLocation_y(),
							v.getWidth(),v.getLength(), this);
				}
				


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

			lightList.get(position + i).setState((Integer) states.get(i));

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
