package view;


import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import constValue.ConstValues;


import ControllerInterface.ITrafficLightController;



import mapInfo.Entrance;
import mapInfo.Exit;
import mapInfo.Junction;
import mapInfo.Light;
import mapInfo.MapInfoManagement;
import model.TrafficLight;
import modelInterface.ITrafficLight;




public class CrossMapView extends MapView {


	

	public CrossMapView(List<ITrafficLight> t, ITrafficLightController c) {
		super(t,c);

		map = new ImageIcon(getClass().getResource("/Icon/one_cross_map.jpg"));
		
		initialLights();
	

	}


	
	
	private void initialLights() {

		lightList = new ArrayList();

		
		Light light4 = new Light(720,244,1,ConstValues.NorthToSouth);
		Light light5 = new Light(720,357,0,ConstValues.WestToEest);
		Light light6 = new Light(833,357,1,ConstValues.SouthToNorth);
		Light light7 = new Light(833,244,1,ConstValues.EastToWest);

		
		 lightList.add(light4);
		 lightList.add(light5);
		 lightList.add(light6);
		 lightList.add(light7);


	}

}
