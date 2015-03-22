package Test;

import java.util.ArrayList;
import java.util.List;


import Controller.TrafficConditionController;
import Controller.TrafficLightController;
import ControllerInterface.ITrafficConditionController;
import ControllerInterface.ITrafficLightController;
import log.LogManagement;
import model.TrafficCondition;
import model.TrafficLight;
import model.TrafficPolicyManagement;
import model.VehicleGenerator;
import model.VehicleManagement;
import modelInterface.ITrafficCondition;
import modelInterface.ITrafficLight;
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

		TrafficPolicyManagement tp = new TrafficPolicyManagement();
		t0.registerTMPObserver(tp);
		
		LogManagement lm = LogManagement.getInstance();
		lm.setTrafficPolicyMgt(tp);
		
		ITrafficLightController tlc = new TrafficLightController(TrafficLights);
		MapView mapPanel = new MapView(TrafficLights, tlc);

		t0.registerObserver(mapPanel);

		//generator
				VehicleGenerator vg = new VehicleGenerator(1);
		        vg.on();
		
		
		//traffict condition
		ITrafficCondition tc = TrafficCondition.getInstance();
		ITrafficConditionController tcc = new TrafficConditionController(tc);
		MainView mv = new MainView(mapPanel, tcc);
		
		((TrafficCondition)tc).registerTMPObserver(tp);
		((TrafficCondition)tc).registerConditionObserver(vg);

		
        
        
        
		vm.registerObserver(mv);
		vm.setIntervalTime(1);
		vm.start();

	}
}
