package Test;

import java.util.ArrayList;
import java.util.List;

import Controller.TrafficLightController;
import ControllerInterface.ITrafficLightController;
import view.TrafficLightView;
import model.TrafficLight;
import modelInterface.ITrafficLight;

public class TrafficLightTest {

	
	
	public static void main(String args[]){
		
		TrafficLight t0 = new TrafficLight(4,0);
		TrafficLight t1 = new TrafficLight(3,1);

	
	

		List<ITrafficLight> TrafficLights = new ArrayList();
		TrafficLights.add(t0);
		TrafficLights.add(t1);
		ITrafficLightController c = new TrafficLightController(TrafficLights);
		
		TrafficLightView tv = new TrafficLightView(TrafficLights,c);


		
		t0.registerObserver(tv);
		t1.registerObserver(tv);
	
	}
}
