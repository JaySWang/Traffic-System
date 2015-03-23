package view;


import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;


import ControllerInterface.ITrafficLightController;



import mapInfo.Light;
import modelInterface.ITrafficLight;




public class TMapView extends MapView {

	 


	

	public TMapView(List<ITrafficLight> t, ITrafficLightController c) {
		super(t,c);

		map = new ImageIcon(getClass().getResource("/Icon/map.png"));
		
		initialLights();
	

	}


	
	
	private void initialLights() {


		lightList = new ArrayList();
		
		Light light4 = new Light(720,244,1);
		Light light5 = new Light(720,357,0);
		Light light6 = new Light(833,357,1);
		Light light7 = new Light(833,244,1);


		 lightList.add(light4);
		 lightList.add(light5);
		 lightList.add(light6);
		 lightList.add(light7);


	}

}
