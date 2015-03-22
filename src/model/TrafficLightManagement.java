package model;

import java.util.ArrayList;
import java.util.List;

import constValue.ConstValues;

import observer.ITrafficLightObservable;
import observer.ITrafficLightObserver;
import observer.ITrafficMgtPolicyObservable;
import observer.ITrafficMgtPolicyObserver;

import log.LogManagement;
import modelInterface.ITrafficLight;
import modelInterface.ITrafficLightManagement;




public class TrafficLightManagement implements ITrafficLightManagement,ITrafficMgtPolicyObservable {


List<ITrafficLight> trafficLights;
	
 
LogManagement lm = LogManagement.getInstance();
ArrayList<ITrafficMgtPolicyObserver> trafficMgtPolicyObservers = new ArrayList<ITrafficMgtPolicyObserver> ();



  int lightState = ConstValues.OFF;

 
 int  intervalTime = ConstValues.NA;




public TrafficLightManagement(List<ITrafficLight> trafficLights) {
this.trafficLights = trafficLights;
}


 

public int getLightState() {
	return lightState;
}
public void setLightState(int state) {
	this.lightState = state;
}
public int getIntervalTime() {
	return intervalTime;
}


		
	





	@Override
	public void off() {
		lightState = ConstValues.OFF;
		   intervalTime =  ConstValues.NA;
		   
		   for(ITrafficLight tl:trafficLights){
			   tl.off();
		   }
		   
		   
			notifyTMPObservers();	

		
	}

	@Override
	public void on() {
		lightState = ConstValues.ON;
		   intervalTime = 1000;
		   for(ITrafficLight tl:trafficLights){
			   tl.on();
		   }
		   
			notifyTMPObservers();

	
	}


	
	
	
	@Override
	public void registerTMPObserver(ITrafficMgtPolicyObserver ob) {
		trafficMgtPolicyObservers.add(ob);		
	}
	@Override
	public void notifyTMPObservers() {
		for(int i = 0;i<trafficMgtPolicyObservers.size();i++){
			trafficMgtPolicyObservers.get(i).update(this);
		}
				
	}
	@Override
	public void setInterval(int sec) {
		
		
		intervalTime = 1000*sec;
		

		   for(ITrafficLight tl:trafficLights){
			   tl.setInterval(sec);
		   }
			notifyTMPObservers();
		
		
	}



	

	
}
