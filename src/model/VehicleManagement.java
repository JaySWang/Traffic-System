package model;

import java.util.ArrayList;
import java.util.List;

import observer.IVehicleObservable;
import observer.IVehicleObserver;

public class VehicleManagement extends Thread implements IVehicleObservable,IVehicleManagement {

	List<IVehicleObserver>  vehicleObservers = new ArrayList<IVehicleObserver>();
	List<IVehicle>  vehicles = new ArrayList<IVehicle>();
	
	
	long intervalTime;
	
	
	
	
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
	
	@Override
	public void setInterval(long msec) {
		intervalTime = msec;		
	}
	
	public void run(){
		while(true){
			for(IVehicle v:vehicles){
				v.setX(v.getX()+10);
				v.setY(v.getY());
System.out.println(v.getX());
			}
			
			notifyObservers();
				
				try {
					sleep(intervalTime);
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
	
	
	}
	

