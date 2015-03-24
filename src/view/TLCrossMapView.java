package view;


import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import constValue.ConstValues;


import ControllerInterface.ITrafficLightController;



import mapInfo.Light;
import modelInterface.ITrafficLight;




public class TLCrossMapView extends MapView {

	 


	

	public TLCrossMapView(List<ITrafficLight> t, ITrafficLightController c) {
		super(t,c);

		map = new ImageIcon(getClass().getResource("/Icon/map.png"));
		
		initialLights();
	

	}


	
	
	private void initialLights() {
		lightList  = new ArrayList();

		Light light1 = new Light(294,244, 1,ConstValues.NorthToSouth);
		Light light2 = new Light(294,357, 0,ConstValues.WestToEest);
		Light light3 = new Light(407, 357,1,ConstValues.SouthToNorth);
		
		Light light4 = new Light(720,244,1,ConstValues.NorthToSouth);
		Light light5 = new Light(720,357,0,ConstValues.WestToEest);
		Light light6 = new Light(833,357,1,ConstValues.SouthToNorth);
		Light light7 = new Light(833,244,1,ConstValues.EastToWest);

		lightList.add(light1);
		lightList.add(light2);
		lightList.add(light3);
		
		 lightList.add(light4);
		 lightList.add(light5);
		 lightList.add(light6);
		 lightList.add(light7);


	}

}
