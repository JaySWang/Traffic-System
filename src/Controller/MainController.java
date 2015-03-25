package Controller;

import java.util.ArrayList;
import java.util.List;

import constValue.ConstValues;

import observer.ITrafficLightObservable;

import view.CrossMapView;
import view.MainView;
import view.MapView;
import view.TLCrossMapView;
import view.TMapView;

import log.LogManagement;
import mapInfo.Entrance;
import mapInfo.Exit;
import mapInfo.Junction;
import mapInfo.MapInfoManagement;
import model.TrafficCondition;
import model.TrafficLight;
import model.TrafficLightManagement;
import model.TrafficPolicyManagement;
import model.VehicleGenerator;
import model.VehicleManagement;
import modelInterface.IMap;
import modelInterface.ITrafficCondition;
import modelInterface.ITrafficLight;
import ControllerInterface.IMainController;
import ControllerInterface.ITrafficConditionController;
import ControllerInterface.ITrafficLightController;

public class MainController implements IMainController{
	
	


	
	
	MapView mapView;
	MainView mv; 
	
	
	IMap map;
	
	
	
	
	public MainController(IMap map) {
         this.map = map;
	}

	
	
	@Override
	public void setMaps(String mapType) {
		
		mapView = map.setMap(mapType);
		
	}



	@Override
	public void start() {
		
		 //generator
		VehicleGenerator vg = new VehicleGenerator(1,map.getEntrance());
	        vg.on();
	        
	    	//traffict condition
	    	ITrafficCondition tc = TrafficCondition.getInstance();
	    	ITrafficConditionController tcc = new TrafficConditionController(tc);

			((TrafficCondition)tc).registerTMPObserver(map.getTPmgt());
			((TrafficCondition)tc).registerConditionObserver(vg);
			 
		
		
				 mv = new MainView(mapView, this, tcc);

			
	        VehicleManagement vm =VehicleManagement.getInstance();

	        vm.clean();
	        
			vm.registerObserver(mv);
			vm.setIntervalTime(1);
			
			if(!vm.isAlive()){
			vm.start();
			}
			
			
	}

	
	
	
}
