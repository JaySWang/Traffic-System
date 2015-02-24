package model;

import java.util.ArrayList;
import java.util.List;

import modelInterface.ITrafficLight;




public class TrafficLight extends Thread implements ITrafficLight {

 final Integer RED = 0;
 final Integer GREEN = 1;
 final Integer OFF = 0;
 final Integer ON = 1;
 int  intervalTime = 1000;
 int numberOfLights;
 
 int state;
 ArrayList<Integer> lightStates;
 
	
	public TrafficLight(int numberOfLights){
		this.numberOfLights = numberOfLights;
		
		initial();
		off();
		start();

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
		state = OFF;
	
	
		
	}

	@Override
	public void on() {
		
		state = ON;
	
	}
	
	public void run(){
		
while(true){
			for(int i = 0;i < numberOfLights&&(state == ON);i++){
					
				for(int j = 0;j < numberOfLights;j++){
					lightStates.set(j, RED);
				}
				lightStates.set(i, GREEN);
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
	
	

	
}
