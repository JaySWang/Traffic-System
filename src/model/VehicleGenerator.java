package model;


import java.util.ArrayList;
import java.util.List;

import observer.ITrafficConditionObserver;
import observer.ITrafficConditionObservable;


import constValue.ConstValues;

import modelInterface.IVehicleGenerator;
import mapCondition.Entrance;


public class VehicleGenerator extends Thread implements IVehicleGenerator,ITrafficConditionObserver {
	 int intervalTime;
     int state;
	 int densityLevel = ConstValues.Low;
     
     List<Entrance> entrances = new ArrayList<Entrance>();
     
     
     
     
     
	public VehicleGenerator(int intervalTime) {
		super();
		this.intervalTime = intervalTime*1000;
		initial();
	}
	
	
	

	private void initial() {
		Entrance e1 = new Entrance(0,0,160,ConstValues.EastToWest);
		entrances.add(e1);
		Entrance e2 = new Entrance(1,1200,200,ConstValues.WastToEest);
		entrances.add(e2);
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
	 
				
		Vehicle v1 = new Vehicle();
		v1.setLength(10);
		v1.setWidth(10);
		v1.setSpeed(10);
        v1.setAcceleration(10);
        
        Entrance enrance;
        int no = (int) (Math.random()*entrances.size());
       enrance = entrances.get(no);
		if(createOrNot()){
	
	    v1.setDirection(enrance.getDirection());
		v1.setLocation_x(enrance.getLocation_x());
		v1.setLocation_y(enrance.getLocation_y());
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
