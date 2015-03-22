package model;

import constValue.ConstValues;
import log.LogManagement;
import log.TrafficMgtPolicyLog;
import observer.ITrafficMgtPolicyObservable;
import observer.ITrafficMgtPolicyObserver;

public class TrafficPolicyManagement implements ITrafficMgtPolicyObserver {

	LogManagement lm = LogManagement.getInstance();
	
	int speedLimit = -1;
	int lightState;
	int startTime = 0;
	int endTime;
	int lightIntervalTime =  ConstValues.NA;
	int densityLevel = ConstValues.Low;
	
	TrafficMgtPolicyLog tpl ;
	
	
	
	
	@Override
	public void update(ITrafficMgtPolicyObservable o) {
	
			addLog();

		
		
		if(o instanceof TrafficLightManagement ){
			lightState = ((TrafficLightManagement)o).getLightState();
			if(((TrafficLightManagement)o).getIntervalTime() == ConstValues.NA){
				lightIntervalTime = ConstValues.NA;
			}
			else{
			lightIntervalTime =  ((TrafficLightManagement)o).getIntervalTime()/1000;
			}
		}
		
		if(o instanceof TrafficCondition ){
	
			speedLimit =  ((TrafficCondition)o).getSpeedLimit();
			densityLevel =  ((TrafficCondition)o).getDensity();
			
		}
		startTime = VehicleManagement.getTiming();

		
	}

	private void addLog() {
		endTime = VehicleManagement.getTiming();
		 tpl = new TrafficMgtPolicyLog(lightState,lightIntervalTime, speedLimit,  startTime, endTime);
		 lm.addLog(tpl,densityLevel);
	}

	
	public int getDensityLevel() {
		return densityLevel;
	}

	public TrafficMgtPolicyLog getCurrentMgtPolicy(){
		int eTime = VehicleManagement.getTiming();
		 tpl = new TrafficMgtPolicyLog(lightState,lightIntervalTime, speedLimit,  startTime, eTime);
	return tpl;
	
	}
}
