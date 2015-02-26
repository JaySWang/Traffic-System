package Controller;

import java.util.ArrayList;
import java.util.List;

import model.TrafficLight;
import modelInterface.ITrafficLight;
import ControllerInterface.ITrafficLightController;

public class TrafficLightController implements ITrafficLightController {
	List<ITrafficLight> trafficLights;
	

	
	public TrafficLightController(List<ITrafficLight> t) {
		trafficLights = t;
		}

	@Override
	public void on() {
		for(ITrafficLight t :trafficLights){
			t.on();
		}
	}

	@Override
	public void off() {
		for(ITrafficLight t :trafficLights){
			t.off();
		}

	}


	@Override
	public void setIntervalTime(String sec) {
		int s =  Integer.parseInt(sec); 
		for(ITrafficLight t :trafficLights){
			t.setInterval(s);
		}
	}

	@Override
	public void addTrafficLight(ITrafficLight t) {
		trafficLights.add(t);		
	}

}
