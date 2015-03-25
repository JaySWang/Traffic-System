package model;

import java.util.ArrayList;
import java.util.List;

import Controller.TrafficLightController;
import ControllerInterface.ITrafficLightController;
import observer.ITrafficLightObservable;
import view.CrossMapView;
import view.MapView;
import view.TLCrossMapView;
import view.TMapView;
import constValue.ConstValues;
import log.LogManagement;
import mapInfo.Entrance;
import mapInfo.Exit;
import mapInfo.Junction;
import mapInfo.MapInfoManagement;
import modelInterface.IMap;
import modelInterface.ITrafficLight;

public class Map implements IMap {

	List<ITrafficLight>  trafficLights = new ArrayList();
	
	MapView mapView;
	ITrafficLightController tlc;
    List<Entrance> entrances;
    List<Exit> exits;
    List<Junction> junctions;

    
	TrafficPolicyManagement tp;

	
	public MapView  setMap(String map){
		
		entrances = new ArrayList<Entrance>();
		exits = new ArrayList<Exit>();
		
		junctions = new ArrayList<Junction>();
		
		
		if(map.equals("TLCrossRoad")){
			
			setTLCrossRoadMap();
			
			
		} else if(map.equals("CrossRoad")){
			
			setCrossRoadMap();
		}
		 else if(map.equals("TRoad")){
			 
			 setTRoadMap();
		 }
		
		
		for(ITrafficLight tl:trafficLights){
			((ITrafficLightObservable)tl).registerObserver(mapView);
		}
		
		MapInfoManagement.getInstance().setExits(exits);

		MapInfoManagement.getInstance().setJunctions(junctions);

		
		return mapView;
		



	
		
		
	}
	
	private void setTRoadMap() {


		TrafficLight t0 = new TrafficLight(3,0);
	    for(ITrafficLight tl:trafficLights){
	    	((TrafficLight)tl).clean();
	    }
		trafficLights.clear();

		trafficLights.add(t0);
		
		 initial();
		 
		 mapView = new TMapView(trafficLights, tlc);
	 



			Entrance e1 = new Entrance(0,0,310,ConstValues.WestToEest);
			entrances.add(e1);
			Exit exit1 = new Exit(1,0,330,ConstValues.SouthToNorth);
			exits.add(exit1);
		 

		 
			Entrance e2 = new Entrance(1,335,600,ConstValues.SouthToNorth);
			entrances.add(e2);
			
			Exit exit2 = new Exit(2,385,600,ConstValues.NorthToSouth);
			exits.add(exit2);

			
			
			Entrance e3 = new Entrance(3,1200,349,ConstValues.EastToWest);
			entrances.add(e3);
			
			Exit exit3 = new Exit(3,1195,295,ConstValues.WestToEest);
			exits.add(exit3);
			
			

			Junction j1 = new Junction(115,281,ConstValues.WestToEest,1,30,8);
			junctions.add(j1);
			


 
			
	}

	private void setCrossRoadMap() {

	    TrafficLight t = new TrafficLight(4,0);
	    for(ITrafficLight tl:trafficLights){
	    	((TrafficLight)tl).clean();
	    }
		trafficLights.clear();

		 trafficLights.add(t);
		
		 initial();
		 
		 mapView = new CrossMapView(trafficLights, tlc);
	 


			Entrance e1 = new Entrance(0,0,310,ConstValues.WestToEest);
			entrances.add(e1);
			Exit exit1 = new Exit(1,0,330,ConstValues.SouthToNorth);
			exits.add(exit1);
		 
		 

			


			Entrance e2 = new Entrance(2,761,600,ConstValues.SouthToNorth);
			entrances.add(e2);
			
			Exit exit2 = new Exit(2,810,600,ConstValues.NorthToSouth);
			exits.add(exit2);
			
			Entrance e3 = new Entrance(3,1200,349,ConstValues.EastToWest);
			entrances.add(e3);
			
			Exit exit3 = new Exit(3,1195,295,ConstValues.WestToEest);
			exits.add(exit3);
			
			Entrance e4 = new Entrance(4,825,0,ConstValues.NorthToSouth);
			entrances.add(e4);
			
			Exit exit4 = new Exit(4,755,0,ConstValues.SouthToNorth);
			exits.add(exit4);
			
			MapInfoManagement.getInstance().setExits(exits);

			
			
			Junction j1 = new Junction(755,330,ConstValues.EastToWest,0.1,40,10);
			 
			junctions.add(j1);
			

			
			
			
			
	}

	private void setTLCrossRoadMap() {

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
	 


			Entrance e1 = new Entrance(0,121,0,ConstValues.NorthToSouth);
			entrances.add(e1);
			Exit exit1 = new Exit(1,60,0,ConstValues.SouthToNorth);
			exits.add(exit1);
		 
		 
			Entrance e2 = new Entrance(1,335,600,ConstValues.SouthToNorth);
			entrances.add(e2);
			
			Exit exit2 = new Exit(2,385,600,ConstValues.NorthToSouth);
			exits.add(exit2);

			Entrance e3 = new Entrance(2,761,600,ConstValues.SouthToNorth);
			entrances.add(e3);
			
			Exit exit3 = new Exit(3,810,600,ConstValues.NorthToSouth);
			exits.add(exit3);
			
			Entrance e4 = new Entrance(3,1200,349,ConstValues.EastToWest);
			entrances.add(e4);
			
			Exit exit4 = new Exit(4,1195,295,ConstValues.WestToEest);
			exits.add(exit4);
			
			Entrance e5 = new Entrance(4,825,0,ConstValues.NorthToSouth);
			entrances.add(e5);
			
			Exit exit5 = new Exit(5,755,0,ConstValues.SouthToNorth);
			exits.add(exit5);
			
			
			
			
		
			

			
			
			
			Junction j1 = new Junction(55,325,ConstValues.SouthToNorth,1,40,40);
 
			junctions.add(j1);
			
			Junction j2 = new Junction(115,281,ConstValues.WestToEest,1,30,8);
			 
			junctions.add(j2);
			
			Junction j3 = new Junction(320,330,ConstValues.EastToWest,1,40,10);
			 
			junctions.add(j3);
			
			Junction j4 = new Junction(755,330,ConstValues.EastToWest,0.1,40,10);
			 
			junctions.add(j4);
			
			Junction j5 = new Junction(370,330,ConstValues.NorthToSouth,0.1,40,30);
			 
			junctions.add(j5);
			
			
			
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
	public List<Entrance> getEntrance() {
		return entrances;
	}

	@Override
	public TrafficPolicyManagement getTPmgt() {
		return tp;
	}
}
