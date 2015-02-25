package Controller;

import modelInterface.ITrafficLight;
import ControllerInterface.ITrafficLightController;

public class TrafficLightController implements ITrafficLightController {
	ITrafficLight trafficLight;
	
	public TrafficLightController(ITrafficLight t){
		trafficLight = t;
	}
	
	
	@Override
	public void on() {
		trafficLight.on();

	}

	@Override
	public void off() {
		trafficLight.off();

	}


	@Override
	public void setIntervalTime(String sec) {
		int s =  Integer.parseInt(sec); 	
		trafficLight.setInterval(s);
	}

}
