package model;

import java.util.ArrayList;
import java.util.List;

import constValue.ConstValues;

import log.LogManagement;
import log.VehicleLog;
import modelInterface.IVehicle;
import modelInterface.IVehicleManagement;

import observer.ITrafficMgtPolicyObservable;
import observer.ITrafficMgtPolicyObserver;
import observer.IVehicleObservable;
import observer.IVehicleObserver;

public class VehicleManagement extends Thread implements IVehicleObservable,IVehicleManagement,ITrafficMgtPolicyObservable {

	List<IVehicleObserver>  vehicleObservers = new ArrayList<IVehicleObserver>();
	ArrayList<ITrafficMgtPolicyObserver> trafficMgtPolicyObservers = new ArrayList<ITrafficMgtPolicyObserver> ();

	List<IVehicle>  vehicles = new ArrayList<IVehicle>();
	LogManagement lm = LogManagement.getInstance();
	
	int intervalTime;
	
	//timing for the simulation 
	static int timing;
	static VehicleManagement vm;
	
	
	public static VehicleManagement getInstance(){
		if(vm==null){
			vm = new VehicleManagement();
		}
		
		return vm;
		
		
	};
	
	
	
	private VehicleManagement() {
		timing = 0;
		notifyTMPObservers();
	}



	@Override
	public void registerObserver(IVehicleObserver ob) {
		vehicleObservers.add(ob);		
	}

	@Override
	public void notifyObservers() {
    for(IVehicleObserver vo :vehicleObservers)	{
	vo.update(this);
	
}
    
    
    
	}

	
	
	
	@Override
	public List<IVehicle> getVehicles() {
		return vehicles;
	}
	

	
	
	public static int getTiming() {
		return timing;
	}



	public void run(){
		while(true){
			for(IVehicle v:vehicles){
				VehicleLog vLog = new VehicleLog(v.getId(), v.getLocation_x(), v.getLocation_y(),
			v.getSpeed(),timing);
				lm.addLog(vLog);
				
				switch(v.getDirection()){
					case ConstValues.EastToWest : v.setLocation_x(v.getLocation_x()+v.getSpeed());
					break;
					
					case ConstValues.WastToEest : v.setLocation_x(v.getLocation_x()-v.getSpeed());
					break;

					case ConstValues.SouthToNorth : v.setLocation_y(v.getLocation_y()-v.getSpeed());
					break;

					case ConstValues.NorthToSouth : v.setLocation_y(v.getLocation_y()+v.getSpeed());

				
				}
			
				v.setSpeed(v.getSpeed()+v.getAcceleration());
				
				

			}
			
			notifyObservers();
			timing+=intervalTime;
			
				try {
					sleep(intervalTime*1000);
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		
			
		
			
		}
		
}

	
	@Override
	public void addVehicle(IVehicle v) {
vehicles.add(v);		
	}

	@Override
	public void setIntervalTime(int sec) {
		intervalTime = sec;		
		
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
	
	
	}
	

