package Test;

import java.util.ArrayList;
import java.util.List;

import observer.ITrafficMgtPolicyObserver;

import Controller.TrafficLightController;
import ControllerInterface.ITrafficLightController;
import model.TrafficLight;
import model.TrafficMgtPolicy;
import model.Vehicle;
import model.VehicleGenerator;
import model.VehicleManagement;
import modelInterface.ITrafficLight;
import modelInterface.IVehicle;
import view.MainView;
import view.MapView;

public class MainViewTest {

	public static void main(String args[]) {

		VehicleManagement vm =VehicleManagement.getInstance();
		TrafficLight t0 = new TrafficLight(3, 0);
		// TrafficLight t1 = new TrafficLight(4,0);

		List<ITrafficLight> TrafficLights = new ArrayList();
		TrafficLights.add(t0);
		// TrafficLights.add(t1);

		TrafficMgtPolicy tp = new TrafficMgtPolicy();
		t0.registerTMPObserver(tp);
		
		
		
		ITrafficLightController c = new TrafficLightController(TrafficLights);
		MapView mapPanel = new MapView(TrafficLights, c);

		t0.registerObserver(mapPanel);
		// t1.registerObserver(mapPanel);

		MainView mv = new MainView(mapPanel);
         
		vm.registerObserver(mv);
		
		VehicleGenerator vg = new VehicleGenerator(1);
        vg.on();
        
		vm.setIntervalTime(1);
		vm.start();

	}
}
