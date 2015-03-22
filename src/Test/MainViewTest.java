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
import model.TrafficLightManagement;
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
		TrafficLight t0 = new TrafficLight(3,0);
	    TrafficLight t1 = new TrafficLight(4,1);

		List<ITrafficLight> trafficLights = new ArrayList();
		trafficLights.add(t0);
		 trafficLights.add(t1);

		 TrafficLightManagement tlm = new TrafficLightManagement(trafficLights);
		 

		 
		 
		TrafficPolicyManagement tp = new TrafficPolicyManagement();
		 tlm.registerTMPObserver(tp);
		
		 
		LogManagement lm = LogManagement.getInstance();
		lm.setTrafficPolicyMgt(tp);
		
		ITrafficLightController tlc = new TrafficLightController(tlm);
		
		MapView mapPanel = new MapView(trafficLights, tlc);

		t0.registerObserver(mapPanel);
		t1.registerObserver(mapPanel);

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
