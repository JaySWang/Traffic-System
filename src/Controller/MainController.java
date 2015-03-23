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
import model.TrafficCondition;
import model.TrafficLight;
import model.TrafficLightManagement;
import model.TrafficPolicyManagement;
import model.VehicleGenerator;
import model.VehicleManagement;
import modelInterface.ITrafficCondition;
import modelInterface.ITrafficLight;
import ControllerInterface.IMainController;
import ControllerInterface.ITrafficConditionController;
import ControllerInterface.ITrafficLightController;

public class MainController implements IMainController{
	
	
	TrafficPolicyManagement tp;
	List<ITrafficLight>  trafficLights = new ArrayList();
    List<Entrance> entrances = new ArrayList<Entrance>();

	
	
	ITrafficLightController tlc;
	MapView mapView;
	MainView mv; 
	
	
	
	@Override
	public void setMaps(String map) {
  
		if(map.equals("TLCrossRoad")){
			TrafficLight t0 = new TrafficLight(3,0);
		    TrafficLight t1 = new TrafficLight(4,1);
		    for(ITrafficLight tl:trafficLights){
		    	((TrafficLight)tl).clean();
		    }
			trafficLights.clear();

			trafficLights.add(t0);
			 trafficLights.add(t1);
			
			 initial();
			 
			 mapView = new TLCrossMapView(trafficLights, tlc);
		 
	

				Entrance e1 = new Entrance(0,121,60,ConstValues.NorthToSouth);
				entrances.add(e1);
				Entrance e2 = new Entrance(1,335,539,ConstValues.SouthToNorth);
				entrances.add(e2);
				
				Entrance e3 = new Entrance(2,761,539,ConstValues.SouthToNorth);
				entrances.add(e3);
				
				Entrance e4 = new Entrance(3,1146,349,ConstValues.EastToWest);
				entrances.add(e4);
				
				Entrance e5 = new Entrance(4,825,60,ConstValues.NorthToSouth);
				entrances.add(e5);

	 
		} else if(map.equals("CrossRoad")){
			TrafficLight t0 = new TrafficLight(3,0);
			 for(ITrafficLight tl:trafficLights){
			    	((TrafficLight)tl).clean();
			    }
			trafficLights.clear();
			trafficLights.add(t0);
			
			 initial();
			 mapView = new CrossMapView(trafficLights, tlc);
		 
	

				Entrance e1 = new Entrance(0,95,28,ConstValues.NorthToSouth);
				entrances.add(e1);
//				Entrance e2 = new Entrance(1,336,539,ConstValues.SouthToNorth);
//				entrances.add(e2);
				
//				Entrance e3 = new Entrance(2,761,539,ConstValues.SouthToNorth);
//				entrances.add(e3);
//				
//				Entrance e4 = new Entrance(3,1146,324,ConstValues.EastToWest);
//				entrances.add(e4);
//				
				Entrance e5 = new Entrance(4,800,28,ConstValues.NorthToSouth);
				entrances.add(e5);

	 
		}
		 else if(map.equals("TRoad")){
				TrafficLight t0 = new TrafficLight(4,0);
				
				 for(ITrafficLight tl:trafficLights){
				    	((TrafficLight)tl).clean();
				    }
				trafficLights.clear();
				trafficLights.add(t0);
				
				 initial();
				 mapView = new TMapView(trafficLights, tlc);
			 
		

					Entrance e1 = new Entrance(0,121,60,ConstValues.NorthToSouth);
					entrances.add(e1);
					Entrance e2 = new Entrance(1,336,539,ConstValues.SouthToNorth);
					entrances.add(e2);
					
					Entrance e3 = new Entrance(2,761,539,ConstValues.SouthToNorth);
					entrances.add(e3);
					
					Entrance e4 = new Entrance(3,1146,324,ConstValues.EastToWest);
					entrances.add(e4);
					
					Entrance e5 = new Entrance(4,800,28,ConstValues.NorthToSouth);
					entrances.add(e5);

		 
			}
		
		
		for(ITrafficLight tl:trafficLights){
			((ITrafficLightObservable)tl).registerObserver(mapView);
		}
		



	}

	private void initial() {
		TrafficLightManagement tlm = new TrafficLightManagement(trafficLights);
		 tp = new TrafficPolicyManagement();
		 tlm.registerTMPObserver(tp);
		 
			LogManagement lm = LogManagement.getInstance();
			lm.clean();
			
		
		 lm.setTrafficPolicyMgt(tp);	
	     tlc = new TrafficLightController(tlm);
	     
	  
			 
	}

	@Override
	public void start() {
		
		 //generator
			VehicleGenerator vg = new VehicleGenerator(1,entrances);
	        vg.on();
	        
	    	//traffict condition
	    	ITrafficCondition tc = TrafficCondition.getInstance();
	    	ITrafficConditionController tcc = new TrafficConditionController(tc);

			((TrafficCondition)tc).registerTMPObserver(tp);
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
