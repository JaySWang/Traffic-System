package model;

import java.util.ArrayList;
import java.util.List;


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
	List<IVehicle>  cloneVehicles = new ArrayList<IVehicle>();
	List<IVehicle>  newVehicles = new ArrayList<IVehicle>();

	
	LogManagement lm = LogManagement.getInstance();
	
	int intervalTime;
	
	//timing for the simulation 
	static int timing;
	static VehicleManagement vm;
	int leaveCount=0;
	int newCount=0;

	
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

			List<IVehicle> vehiclesToLeave = new ArrayList<IVehicle>();
			
			cloneVehicles = (List<IVehicle>) ((ArrayList)vehicles).clone();

			for(IVehicle v:vehicles){

				VehicleLog vLog = new VehicleLog(v.getId(), v.getLocation_x(), v.getLocation_y(),
			v.getSpeed(),timing);
				lm.addLog(vLog);
				
				//vehicle leave
				
				if(!v.update()){
					leaveCount++;
					
					vehiclesToLeave.add(v);
					
				}
	
			}
			
			for(IVehicle v:vehiclesToLeave){
				vehicles.remove(v);
			}
			for(IVehicle v:newVehicles){
				newCount++;
				vehicles.add(v);
			}
			newVehicles =new ArrayList<IVehicle>();
			

			notifyObservers();
			timing+=intervalTime;
				try {
					sleep(intervalTime*100);
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		
			
		
				
		}
		
}

	
	@Override
	public void addVehicle(IVehicle v) {
	//	System.out.println("add "+synchronizedLock);
		newVehicles.add(v);		
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


	@Override
	public List<IVehicle> getCloneVehicles() {

		return cloneVehicles;
	}
	
	
	}
	

