package model;


import java.util.ArrayList;
import java.util.List;

import observer.ITrafficConditionObserver;
import observer.ITrafficConditionObservable;


import constValue.ConstValues;

import model.vehicles.Bus;
import model.vehicles.Car;
import model.vehicles.Coach;
import model.vehicles.VehicleWithRec;
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

			IVehicle v = null;
			  int type = (int) (Math.random()*ConstValues.NumOfTypes);
			  
			  switch(type){
			  case ConstValues.Car: 
				  v = new Car(vehicleCount, enrance.getLocation_x(),
								enrance.getLocation_y(), enrance.getDirection());
				  break;
			  case ConstValues.Coach: 
				  v = new Coach(vehicleCount, enrance.getLocation_x(),
								enrance.getLocation_y(), enrance.getDirection());
				  break;  
			  case ConstValues.Bus: 
				  v = new Bus(vehicleCount, enrance.getLocation_x(),
								enrance.getLocation_y(), enrance.getDirection());
				  break; 
				  
			  }
	
				VehicleManagement.getInstance().addVehicle(v);



		}		
		
		try {
					sleep(intervalTime);
				} catch (InterruptedException e) {
				
					e.printStackTrace();
				}
				
		
			
		
			
	}
}	





	private boolean createOrNot() {
    if(Math.random()<0.2*densityLevel)
    	return true;
		
		return false;
	}




	@Override
	public void update(ITrafficConditionObservable o) {
		densityLevel = 	((TrafficCondition)o).getDensity();	
	}






}
