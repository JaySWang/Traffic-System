package view;


import java.util.List;

import javax.swing.ImageIcon;


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

		Light light1 = new Light(296,245, 1);
		Light light2 = new Light(296,360, 0);
		Light light3 = new Light(409, 360,1);
		
		Light light4 = new Light(721,245,1);
		Light light5 = new Light(721,360,0);
		Light light6 = new Light(834,360,1);
		Light light7 = new Light(834,245,1);

		lightList.add(light1);
		lightList.add(light2);
		lightList.add(light3);
		
		 lightList.add(light4);
		 lightList.add(light5);
		 lightList.add(light6);
		 lightList.add(light7);


	}

}
