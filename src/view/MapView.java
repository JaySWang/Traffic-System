package view;

import java.awt.AWTException;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import Tools.ScreenShotofMap;

import ControllerInterface.ITrafficLightController;

import constValue.ConstValues;

import modelInterface.ITrafficLight;
import modelInterface.IVehicle;
import modelInterface.IVehicleManagement;

import observer.ITrafficLightObservable;
import observer.ITrafficLightObserver;
import observer.IVehicleObservable;

public class MapView extends JPanel implements ITrafficLightObserver {
	ScreenShotofMap s = new ScreenShotofMap();

	List<IVehicle> vehicles;
	ImageIcon map = new ImageIcon(getClass().getResource("/Icon/map.png"));;

	ImageIcon greenIcon = new ImageIcon(getClass().getResource(
			"/Icon/green.jpg"));
	ImageIcon redIcon = new ImageIcon(getClass().getResource("/Icon/red.jpg"));

	int trafficLightState = ConstValues.OFF;

	List<Light> lightList = new ArrayList();

	List<ITrafficLight> trafficLights;
	ITrafficLightController trafficLightController;

	public MapView(List<ITrafficLight> t, ITrafficLightController c) {
		super();
		initialLights();
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

	
	
	private void initialLights() {

		Light light1 = new Light(240,115, 1);
		Light light2 = new Light(240,227, 0);
		Light light3 = new Light(350, 227,1);
		// Light light4 = new
		// Light(map.getIconWidth()/4,map.getIconHeight()/10,0);
		// Light light5 = new
		// Light(map.getIconWidth()/2,map.getIconHeight()/2,1);
		// Light light6 = new
		// Light(map.getIconWidth()/2,map.getIconHeight()/3,0);
		// Light light7 = new
		// Light(map.getIconWidth()/2,map.getIconHeight()/4,1);

		lightList.add(light1);
		lightList.add(light2);
		lightList.add(light3);
		// lightList.add(light4);
		// lightList.add(light5);
		// lightList.add(light6);
		// lightList.add(light7);


	}

	class Light {
		int location_x;
		int location_y;
		ImageIcon state;
		int lightSize = 30;

		public Light(double x, double y, int s) {

			location_x = (int) x;
			location_y = (int) y;

			setState(s);
		}

		private void setState(int s) {
			if (s == ConstValues.GREEN) {
				state = greenIcon;
			} else if (s == ConstValues.RED) {
				state = redIcon;
			}

		}
	}

	
	//screenShot
	
	public void paint(Graphics g) {
		super.paint(g);
		
    try {
		s.updateScreenShot(this);
	} catch (AWTException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	public void update(Graphics g){

		g.drawImage(map.getImage(), 0, 0, map.getIconWidth(),
				map.getIconHeight(), this);
		if (trafficLightState == ConstValues.ON) {
			for (Light l : lightList) {

				g.drawImage(l.state.getImage(), l.location_x, l.location_y,
						l.lightSize, l.lightSize, this);

			}
		}

		if (vehicles != null) {
			for (IVehicle v : vehicles) {

				g.drawRect(v.getLocation_x(), v.getLocation_y(), v.getWidth(),
						v.getLength());

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
