package model;

import log.LogManagement;
import log.TrafficMgtPolicyLog;
import observer.ITrafficMgtPolicyObservable;
import observer.ITrafficMgtPolicyObserver;

public class TrafficMgtPolicy implements ITrafficMgtPolicyObserver {

	LogManagement lm = LogManagement.getInstance();
	
	int speedLimit;
	int lightState;
	int startTime = 0;
	int endTime;
	int lightIntervalTime;
	TrafficMgtPolicyLog tpl ;
	
	
	
	
	@Override
	public void update(ITrafficMgtPolicyObservable o) {
	
			addLog();

		
		
		if(o instanceof TrafficLight ){
			lightState = ((TrafficLight)o).getLightState();
			lightIntervalTime =  ((TrafficLight)o).getIntervalTime()/1000;
			
		}
		
		if(o instanceof VehicleManagement ){
	
			speedLimit =  ((VehicleManagement)o).getSpeedLimit();
			
			
		}
		startTime = VehicleManagement.getTiming();

		
	}




	private void addLog() {
		endTime = VehicleManagement.getTiming();
		 tpl = new TrafficMgtPolicyLog(lightState,lightIntervalTime, speedLimit,  startTime, endTime);
		 lm.addLog(tpl);
		 startTime = endTime;		
	}

}
