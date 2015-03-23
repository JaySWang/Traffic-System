package model;


import java.util.List;

import observer.ITrafficConditionObserver;
import observer.ITrafficConditionObservable;


import constValue.ConstValues;

import modelInterface.IVehicle;
import modelInterface.IVehicleGenerator;
import mapInfo.Entrance;


public class VehicleGenerator extends Thread implements IVehicleGenerator,ITrafficConditionObserver {
	 int intervalTime;
     int state;
	 int densityLevel = ConstValues.Low;
     
	 List<Entrance> entrances ;
     
     int vehicleCount;
     
     
	public VehicleGenerator(int intervalTime,List<Entrance> entrances) {
		this.entrances = entrances;
		this.intervalTime = intervalTime*200;
	}
	
	
	





	@Override
	public void on() {
		state = ConstValues.ON;
		
		start();
	}

	@Override
	public void off() {
		state = ConstValues.OFF;
		
	}


	public void run(){
while(true){
	 
	
	
              
        Entrance enrance;
        int no = (int) (Math.random()*entrances.size());
       enrance = entrances.get(no);
		if(createOrNot()){
	

			vehicleCount++;

			int length = 32;
			int width =26;
			int speed = 80;
			IVehicle v1 = 
					new Vehicle(vehicleCount, width, length, enrance.getLocation_x(),
					enrance.getLocation_y(), enrance.getDirection(), speed);
	
		
		VehicleManagement.getInstance().addVehicle(v1);
		

		}		
		
		try {
					sleep(intervalTime);
				} catch (InterruptedException e) {
				
					e.printStackTrace();
				}
				
		
			
		
			
	}
}	





	private boolean createOrNot() {
    if(Math.random()<0.3*densityLevel)
    	return true;
		
		return false;
	}




	@Override
	public void update(ITrafficConditionObservable o) {
		densityLevel = 	((TrafficCondition)o).getDensity();	
	}






}
