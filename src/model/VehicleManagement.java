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
	
	//for vehicle list   in case of "java.util.ConcurrentModificationException"
	int synchronizedLock = 1;
	
	
	public static VehicleManagement getInstance(){
		if(vm==null){
			vm = new VehicleManagement();
		}
		
		return vm;
		
		
	};
	
	
	public void clean(){
		vehicles.clear();
		vehicleObservers.clear();
		trafficMgtPolicyObservers.clear();
	}
	
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
			synchronizedLock = 0;

			for(IVehicle v:vehicles){

				VehicleLog vLog = new VehicleLog(v.getId(), v.getLocation_x(), v.getLocation_y(),
			v.getSpeed(),timing);
				lm.addLog(vLog);
				
				switch(v.getDirection()){
					case ConstValues.EastToWest : v.setLocation_x(v.getLocation_x()-v.getSpeed());
					break;
					
					case ConstValues.WestToEest : v.setLocation_x(v.getLocation_x()+v.getSpeed());
					break;

					case ConstValues.SouthToNorth : v.setLocation_y(v.getLocation_y()-v.getSpeed());
					break;

					case ConstValues.NorthToSouth : v.setLocation_y(v.getLocation_y()+v.getSpeed());

				
				}
			
				v.setSpeed(v.getSpeed()+v.getAcceleration());
				
				

			}
			
			notifyObservers();
			timing+=intervalTime;

			synchronizedLock = 1;
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
	//	System.out.println("add "+synchronizedLock);
 		if(synchronizedLock==1)
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
	

