package Controller;



import model.TrafficLightManagement;
import ControllerInterface.ITrafficLightController;

public class TrafficLightController implements ITrafficLightController {
	TrafficLightManagement trafficLightMgt;
	

	
	public TrafficLightController(TrafficLightManagement tlm) {
		trafficLightMgt = tlm;
		}

	
	@Override
	public void on() {
		trafficLightMgt.on();
	}

	@Override
	public void off() {
		trafficLightMgt.off();

	}


	@Override
	public void setIntervalTime(String sec) {
		int s =  Integer.parseInt(sec); 
		trafficLightMgt.setInterval(s);
	}



}
