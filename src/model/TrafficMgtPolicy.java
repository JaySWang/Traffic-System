package model;

import log.LogManagement;
import log.TrafficMgtPolicyLog;
import observer.ITrafficMgtPolicyObservable;
import observer.ITrafficMgtPolicyObserver;

public class TrafficMgtPolicy implements ITrafficMgtPolicyObserver {

	LogManagement lm = LogManagement.getInstance();
	
	int speedLimit;
	int lightState;
	int startTime = -1;
	int endTime;
	int lightIntervalTime;
	TrafficMgtPolicyLog tpl ;
	
	
	
	
	@Override
	public void update(ITrafficMgtPolicyObservable o) {
		if(startTime!=-1){
			addLog();

		}
		
		if(o instanceof TrafficLight ){
			lightState = ((TrafficLight)o).getLightState();
			lightIntervalTime =  ((TrafficLight)o).getLightState();
			
		}
		
		if(o instanceof VehicleManagement ){
			if(startTime!=-1){
				addLog();

			}
			startTime = VehicleManagement.getTiming();
			speedLimit =  ((VehicleManagement)o).getSpeedLimit();
			
			
		}
		
	}




	private void addLog() {
		endTime = VehicleManagement.getTiming();
		 tpl = new TrafficMgtPolicyLog( lightState,  speedLimit,  startTime, endTime);
		 lm.addLog(tpl);
		 startTime = endTime;		
	}

}
