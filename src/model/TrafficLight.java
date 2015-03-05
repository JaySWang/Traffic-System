package model;

import java.util.ArrayList;
import java.util.List;

import constValue.ConstValues;

import observer.ITrafficLightObservable;
import observer.ITrafficLightObserver;

import modelInterface.ITrafficLight;




public class TrafficLight extends Thread implements ITrafficLight,ITrafficLightObservable {

 final static Integer RED = 0;
 final static Integer GREEN = 1;

 int  intervalTime = 1000;
 int numberOfLights;
 int no;
 
 
 
 public int getNo() {
	return no;
}
 public int getNumberOfLights() {
	return numberOfLights;
}



ArrayList<ITrafficLightObserver> observers = new ArrayList<ITrafficLightObserver> ();
 
 
 int state;
 ArrayList<Integer> lightStates;
 

	public TrafficLight(int numberOfLights,int no){
		this.numberOfLights = numberOfLights;
		this.no = no;
		initial();
		off();
		start();

	}
	
	   public int getlightState(){
		   return state;
	   }
		
	
	private void initial() {
		lightStates = new ArrayList<Integer>(numberOfLights);
		for(int i = 0;i<numberOfLights;i++){
			lightStates.add(RED);
			
		}
		
	}



	@Override
	public List<Integer> getStates() {
		
		return lightStates;
	}


	@Override
	public void off() {
		state = ConstValues.OFF;
	
	
		
	}

	@Override
	public void on() {
		
		state = ConstValues.ON;
	
	}
	
	public void run(){
		
while(true){
			for(int i = 0;i < numberOfLights&&(state == ConstValues.ON);i++){
					
				for(int j = 0;j < numberOfLights;j++){
					lightStates.set(j, RED);
				}
				lightStates.set(i, GREEN);
				notifyObservers();
				test();
				
				try {
					sleep(intervalTime);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		
			
		
			
		}
		
}
	}



	private void test() {
		
		System.out.println(lightStates.toString());
		
	}



	@Override
	public void setInterval(int sec) {
		intervalTime = 1000*sec;		
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
	
	

	
}
