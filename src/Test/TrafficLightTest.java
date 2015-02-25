package Test;

import Controller.TrafficLightController;
import ControllerInterface.ITrafficLightController;
import view.TrafficLightView;
import model.TrafficLight;
import modelInterface.ITrafficLight;

public class TrafficLightTest {

	
	
	public static void main(String args[]){
		
		TrafficLight t = new TrafficLight(4);
		ITrafficLightController c = new TrafficLightController(t);
		TrafficLightView tv = new TrafficLightView(t,c);
		tv.on();
		
		t.registerObserver(tv);
	
	}
}
