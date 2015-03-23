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




public class TrafficLight extends Thread implements ITrafficLight,ITrafficLightObservable {


ArrayList<ITrafficLightObserver> observers = new ArrayList<ITrafficLightObserver> ();
 



  int lightState = ConstValues.OFF;
 ArrayList<Integer> lightStates;
 
 int  intervalTime = ConstValues.NA;

 int numberOfLights;
 int no;
 
 int count = 0;
 
 
 
 public int getNo() {
	return no;
}
 public int getNumberOfLights() {
	return numberOfLights;
}



 public void clean(){
	 observers.clear();
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

	public TrafficLight(int numberOfLights,int no){
		this.numberOfLights = numberOfLights;
		this.no = no;
		

		initial();
		

		start();

	}

		
	
	private void initial() {
		lightStates = new ArrayList<Integer>(numberOfLights);
		for(int i = 0;i<numberOfLights;i++){
			lightStates.add(ConstValues.RED);
			
		}
		lightState = ConstValues.OFF;
		intervalTime =  ConstValues.NA;
	}



	@Override
	public List<Integer> getStates() {
		
		return lightStates;
	}


	@Override
	public void off() {
		lightState = ConstValues.OFF;
		   intervalTime =  ConstValues.NA;

		
	}

	@Override
	public void on() {
		lightState = ConstValues.ON;
		   intervalTime = 1000;


	
	}

	

	public void run(){
		
while(true){
			for(int i = 0;i < numberOfLights&&(lightState == ConstValues.ON);i++){
					
				for(int j = 0;j < numberOfLights;j++){
					lightStates.set(j, ConstValues.RED);
				}
				lightStates.set(i, ConstValues.GREEN);
				notifyObservers();
				
				try {
					sleep(intervalTime);
				} catch (InterruptedException e) {
				
					e.printStackTrace();
				}
			
		}
		
}
	}









	@Override
	public void registerObserver(ITrafficLightObserver ob) {
		observers.add(ob);
		
	}

	@Override
	public void notifyObservers() {
		for(int i = 0;i<observers.size();i++){
			observers.get(i).update(this);
		}
		
	}
	
	
	

	@Override
	public void setInterval(int sec) {
		intervalTime = 1000*sec;	


		
		
	}
	
	

	
}
