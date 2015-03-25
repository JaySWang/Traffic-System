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




public class TMapView extends MapView {




		
		



	

	public TMapView(List<ITrafficLight> t, ITrafficLightController c) {
		super(t,c);

		map = new ImageIcon(getClass().getResource("/Icon/1t_map.jpg"));
		
		initialLights();
	

	}


	
	
	private void initialLights() {


		lightList = new ArrayList();
		
		Light light1 = new Light(294,244, 1,ConstValues.NorthToSouth);
		Light light2 = new Light(294,357, 0,ConstValues.WestToEest);
		Light light3 = new Light(407, 357,1,ConstValues.SouthToNorth);
		
	

		lightList.add(light1);
		lightList.add(light2);
		lightList.add(light3);


	}

}
