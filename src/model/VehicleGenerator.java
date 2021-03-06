package model;


import java.util.ArrayList;
import java.util.List;

import observer.ITrafficConditionObserver;
import observer.ITrafficConditionObservable;


import constValue.ConstValues;

import model.vehicles.Bus;
import model.vehicles.Car;
import model.vehicles.Coach;
import model.vehicles.VehicleWithPriority;
import model.vehicles.VehicleWithRec;
import modelInterface.IVehicle;
import modelInterface.IVehicleGenerator;
import mapInfo.Entrance;


public class VehicleGenerator extends Thread implements IVehicleGenerator,ITrafficConditionObserver {
	 int intervalTime;
     int state;
	 int densityLevel = ConstValues.Low;
     
	 List<Entrance> entrances;
     
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
		
		
		
while(state == ConstValues.ON ){
	
	  Entrance enrance;
      int no = (int) (Math.random()*entrances.size());
     enrance = entrances.get(no);


              
      
       
       
		if(createOrNot()){
	

			vehicleCount++;

			IVehicle v = null;
			  int type = (int) (Math.random()*ConstValues.NumOfTypes);
			  
			  int behaviorType = (int) (Math.random()*ConstValues.NumOfbehaviorType);
			   int behavior = ConstValues.Normal;
			  switch(behaviorType){
			  case ConstValues.Normal:
				  behavior = ConstValues.Normal;
				    break;
			  case ConstValues.Cautious:
				  behavior = ConstValues.Cautious;
				    break;
			  }

			  
			  
			  switch(type){
			  case ConstValues.Car: 
				  v = new Car(vehicleCount, enrance.getLocation_x(),
								enrance.getLocation_y(), enrance.getDirection(),behavior);
				  break;
			  case ConstValues.Coach: 
				  v = new Coach(vehicleCount, enrance.getLocation_x(),
								enrance.getLocation_y(), enrance.getDirection(),behavior);
				  break;  
			  case ConstValues.Bus: 
				  v = new Bus(vehicleCount, enrance.getLocation_x(),
								enrance.getLocation_y(), enrance.getDirection(),behavior);
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
		double r = Math.random();

    if(r<0.1*densityLevel){
    	return true;
    }
		return false;
	}




	@Override
	public void update(ITrafficConditionObservable o) {
		densityLevel = 	((TrafficCondition)o).getDensity();	

		
		if(	((TrafficCondition)o).isNewPrivilegeVehicle()){
		  Entrance enrance = new Entrance(3,1200,330,ConstValues.EastToWest);
		
		IVehicle v = new VehicleWithPriority(vehicleCount, enrance.getLocation_x(),
enrance.getLocation_y(), enrance.getDirection(),ConstValues.Normal);
		VehicleManagement.getInstance().addVehicle(v);
		}
		
	}






}
